package com.pagepulse.controller;

import com.pagepulse.model.AuditRequest;
import com.pagepulse.model.AuditResponse;
import com.pagepulse.service.AuditService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@Slf4j
public class AuditController {
    @Autowired
    private final AuditService auditService;

    @PostMapping("/analyze")
    public ResponseEntity<AuditResponse> analyze(@Valid @RequestBody AuditRequest auditRequest) {
        log.info("URL = "+auditRequest.getUrl());
        AuditResponse response = auditService.analyze(auditRequest.getUrl());
        return ResponseEntity.ok(response);
    }
}
