package com.safety.service;

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
        alertLogRepository.save(new AlertLog(null, message, subSystem));
    }
}
