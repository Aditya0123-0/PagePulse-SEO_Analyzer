package com.pagepulse.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuditResponse {
    private String url;
    private int httpStatus;
    private long responseTime;
    private String title;
    private String metaDescription;
    private int h1Count;
    private int imagesMissingAlt;
    private int wordCount;
    private int seoScore;
    private List<String> recommendations;
}
