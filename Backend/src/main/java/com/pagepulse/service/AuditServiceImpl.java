package com.pagepulse.service;

import com.pagepulse.exception.InvalideUrlException;
import com.pagepulse.exception.NoHtmlContentException;
import com.pagepulse.model.AuditResponse;
import com.pagepulse.util.HtmlParser;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@Service
public class AuditServiceImpl implements AuditService {
    private final HtmlParser htmlParser = new HtmlParser();

    @Override
    public AuditResponse analyze(String url) {

        validateUrl(url);

        try {

            long start = System.currentTimeMillis();
            Connection.Response response = Jsoup.connect(url)
                    .timeout(5000)
                    .followRedirects(true)
                    .ignoreHttpErrors(true)
                    .execute();

            int status = response.statusCode();
            String contentType = response.contentType();

            if (contentType == null ||
                    !contentType.toLowerCase().contains("text/html")) {

                throw new NoHtmlContentException("URL does not return HTML content");
            }

            Document document = response.parse();
            String title = htmlParser.getTitle(document);
            String metaDescription = htmlParser.getMetaDescription(document);
            int h1Count = htmlParser.getH1Count(document);
            int imagesMissingAlt = htmlParser.getImagesMissingAlt(document);
            int wordCount = htmlParser.getWordCount(document);

            List<String> recommendations = new ArrayList<>();
            int seoScore = 100;

            if (title.isBlank()) {
                seoScore -= 20;
                recommendations.add("Missing page title.");
            }

            if (metaDescription.isBlank()) {
                seoScore -= 20;
                recommendations.add("Missing meta description.");
            }

            if (h1Count == 0) {
                seoScore -= 20;
                recommendations.add("No H1 heading found.");
            } else if (h1Count > 1) {
                seoScore -= 10;
                recommendations.add("Multiple H1 headings found.");
            }

            if (imagesMissingAlt > 0) {
                seoScore -= Math.min(imagesMissingAlt * 5, 20);
                recommendations.add(imagesMissingAlt + " image(s) missing alt text.");
            }

            if (wordCount < 300) {
                seoScore -= 10;
                recommendations.add("Content is quite short.");
            }

            seoScore = Math.max(seoScore, 0);

            if (recommendations.isEmpty()) {
                recommendations.add("No major SEO issues detected.");
            }

            long responseTime = System.currentTimeMillis() - start;

            return new AuditResponse(
                    url,
                    status,
                    responseTime,
                    htmlParser.getTitle(document),
                    htmlParser.getMetaDescription(document),
                    htmlParser.getH1Count(document),
                    htmlParser.getImagesMissingAlt(document),
                    htmlParser.getWordCount(document),
                    seoScore,
                    recommendations

            );

        } catch (MalformedURLException e) {

            throw new InvalideUrlException("Invalid URL");

        } catch (IOException e) {

            throw new RuntimeException("Unable to fetch webpage");

        }

    }

    private void validateUrl(String url) {

        try {

            new URL(url);

        } catch (Exception e) {

            throw new InvalideUrlException("Invalid URL");

        }

    }

}
