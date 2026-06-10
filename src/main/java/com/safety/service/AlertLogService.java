package com.safety.service;

import java.time.LocalDateTime;
import java.util.UUID;

import com.safety.model.AlertLog;
import com.safety.repository.AlertLogRepository;
import org.springframework.stereotype.Service;

@Service
public class AlertLogService {

    private final AlertLogRepository alertLogRepository;

    public AlertLogService(AlertLogRepository alertLogRepository) {
        this.alertLogRepository = alertLogRepository;
    }

    public void createLog(String message, String subSystem) {
        AlertLog alertLog = new AlertLog();
        alertLog.setLogId(UUID.randomUUID().toString());
        alertLog.setMessage(message);
        alertLog.setSubSystem(subSystem);
        alertLog.setCreatedAt(LocalDateTime.now());
        alertLogRepository.save(alertLog);
    }
}
