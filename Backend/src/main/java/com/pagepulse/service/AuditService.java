package com.pagepulse.service;

import com.pagepulse.model.AuditResponse;

public interface AuditService {
    AuditResponse analyze(String url);
}
