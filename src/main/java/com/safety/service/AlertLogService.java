package com.safety.service;

import com.safety.model.AlertLog;
import com.safety.repository.AlertLogRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
public class AlertLogService {

    private final AlertLogRepository alertLogRepository;

    public AlertLogService(AlertLogRepository alertLogRepository) {
        this.alertLogRepository = alertLogRepository;
    }

    public void createLog(String message, String subSystem) {
        AlertLog alertLog = new AlertLog(
                UUID.randomUUID().toString(),
                message,
                subSystem,
                LocalDateTime.now()
        );
        alertLogRepository.save(alertLog);
    }
}
