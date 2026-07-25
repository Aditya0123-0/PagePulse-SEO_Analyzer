# 🚀 Page Pulse – Website SEO & Performance Auditor

Page Pulse is a full-stack web application that audits a website URL and generates a concise SEO and performance report. It analyzes essential on-page SEO metrics and presents them in a clean, user-friendly interface.

This project was built as part of the **Digital Heroes Training Task**.

---

## ✨ Features

### Backend
- Analyze any valid website URL
- Fetch page using Jsoup
- Return HTTP status code
- Measure response time
- Extract page title
- Extract meta description
- Count H1 headings
- Count images missing `alt` attributes
- Calculate approximate word count
- Generate an SEO score (0–100)
- Provide SEO recommendations
- Handle:
    - Invalid URLs
    - Timeouts
    - Non-HTML responses
    - Unexpected server errors

### Frontend
- Simple and responsive interface
- URL input field
- Loading indicator
- Error handling with meaningful messages
- Clean audit report display
- SEO score and recommendations
- Footer credit as required by the assignment

---

# 🛠 Tech Stack

## Backend
- Java 17
- Spring Boot 3
- Maven
- Jsoup

## Frontend
- React
- Vite
- JavaScript
- CSS

---

# 📁 Project Structure

```
PagePulse-SEO_Analyzer
│
├── Backend
│   ├── src
│   ├── pom.xml
│   └── ...
│
├── Frontend
│   ├── src
│   ├── package.json
│   └── ...
│
└── README.md
```

---

# ⚙️ Getting Started

## Prerequisites

- Java 17+
- Maven
- Node.js 18+
- npm

---

## Backend Setup

```bash
cd Backend
mvn clean install
mvn spring-boot:run
```

Backend runs on:

```
http://localhost:8080
```

---

## Frontend Setup

```bash
cd Frontend
npm install
npm run dev
```

Frontend runs on:

```
http://localhost:5173
```

---

# 📡 API

## Analyze Website

### Endpoint

```
POST /api/analyze
```

### Request

```json
{
  "url": "https://example.com"
}
```

### Successful Response

```json
{
  "url": "https://example.com",
  "httpStatus": 200,
  "responseTime": 230,
  "title": "Example Domain",
  "metaDescription": "...",
  "h1Count": 1,
  "imagesMissingAlt": 0,
  "wordCount": 450,
  "seoScore": 92,
  "recommendations": [
    "No major SEO issues detected."
  ]
}
```

---

# ❌ Error Responses

## Invalid URL

```
400 Bad Request
```

```json
{
  "error": "Invalid URL"
}
```

---

## Non-HTML Response

```
415 Unsupported Media Type
```

```json
{
  "error": "URL does not return HTML content"
}
```

---

## Timeout

```
504 Gateway Timeout
```

```json
{
  "error": "Request timed out"
}
```

---

# 🧪 Testing

The application was tested with various scenarios:

- ✅ Valid HTML websites
- ✅ Invalid URLs
- ✅ Websites returning non-HTML content
- ✅ Blocked pages (403)
- ✅ Network failures

Example websites tested:

- https://example.com
- https://spring.io
- https://www.wikipedia.org

---

# 💡 Design Decisions

### 1. Used Jsoup for HTML Parsing

Jsoup provides both HTTP fetching and HTML parsing in a lightweight library, making it well suited for extracting SEO-related information.

### 2. Centralized Exception Handling

Implemented a `GlobalExceptionHandler` using `@RestControllerAdvice` to ensure consistent and meaningful error responses throughout the API.

### 3. SEO Score with Recommendations

Instead of only returning raw metrics, the application generates an SEO score and actionable recommendations, making the report easier to understand for end users.

---

# 🚀 Future Improvements

Given additional development time, I would add:

- Lighthouse/PageSpeed Insights integration
- Open Graph and Twitter Card validation
- robots.txt and sitemap.xml detection
- Canonical URL validation
- Broken link detection
- Accessibility checks
- Performance optimizations using asynchronous processing
- Result caching for repeated audits

---

# 🌐 Live Demo

**Frontend:** *(Add deployed frontend URL here)*

**Backend API:** *(Add deployed backend URL here)*

---

# 🎥 Loom Walkthrough

*(Add Loom video link here)*

---

# 👨‍💻 Author

**Aditya Wadkar**

Java Backend Developer

---

## Assignment Credit

Built for **Digital Heroes Training Task**

https://digitalheroesco.com