package com.pagepulse.util;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class HtmlParser {

    public String getTitle(Document document) {
        return document.title();
    }

    public String getMetaDescription(Document document) {
        Elements meta = document.select("meta[name=description]");
        return meta.isEmpty()
                ? ""
                : meta.first().attr("content");
    }

    public int getH1Count(Document document) {
        return document.select("h1").size();
    }

    public int getImagesMissingAlt(Document document) {
        return document.select("img:not([alt]), img[alt='']").size();
    }

    public int getWordCount(Document document) {
        String text = document.body() != null ? document.body().text() : "";

        if (text.isBlank()) {
            return 0;
        }

        return text.trim().split("\\s+").length;
    }
}