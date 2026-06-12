package com.safety.service;

import com.safety.model.AlertLog;
import com.safety.repository.AlertLogRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertLogService {

    private final AlertLogRepository alertLogRepository;

    @Autowired
    public AlertLogService(AlertLogRepository alertLogRepository) {
        this.alertLogRepository = alertLogRepository;
    }

    public AlertLogService() {
        this(new AlertLogRepository());
    }

    public synchronized void createLog(String message, String subSystem) {
        alertLogRepository.save(new AlertLog(null, message, subSystem));
    }

    public synchronized List<AlertLog> findAll() {
        return alertLogRepository.findAll();
    }
}
