# Page Pulse

## Features

- Website SEO Analyzer
- HTTP Status
- Response Time
- Meta Description
- H1 Count
- Word Count
- SEO Score
- Recommendations

## Tech Stack

Backend
- Java 17
- Spring Boot
- Jsoup

Frontend
- React
- Vite

## Setup

Backend

mvn spring-boot:run

Frontend

npm install
npm run dev

## API

POST /api/analyze

Request

{
"url":"https://example.com"
}

Response

{
"url": "https://example.com",
"httpStatus": 200,
"responseTime": 265,
"title": "Example Domain",
"metaDescription": "",
"h1Count": 1,
"imagesMissingAlt": 0,
"wordCount": 19,
"seoScore": 70,
"recommendations": [
"Missing meta description.",
"Content is quite short."
]
}

## Design Decisions

1. Used Jsoup because it provides HTML parsing and HTTP fetching in one library.
2. Implemented GlobalExceptionHandler for centralized error handling.
3. Added SEO scoring and recommendations to provide actionable insights instead of raw metrics.

## Future Improvements

- Lighthouse integration
- Robots.txt analysis
- Sitemap detection
- Open Graph validation