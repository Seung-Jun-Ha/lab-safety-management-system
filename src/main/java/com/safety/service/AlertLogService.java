package com.safety.service;

import com.safety.model.AlertLog;
import com.safety.repository.AlertLogRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlertLogService {

    private final AlertLogRepository alertLogRepository;
    private final List<AlertLog> alertLogs;

    @Autowired
    public AlertLogService(AlertLogRepository alertLogRepository) {
        this.alertLogRepository = alertLogRepository;
        this.alertLogs = new ArrayList<>();
    }

    public AlertLogService() {
        this.alertLogRepository = null;
        this.alertLogs = new ArrayList<>();
    }

    public synchronized void createLog(String message, String subSystem) {
        AlertLog alertLog = new AlertLog();
        alertLog.setLogId(UUID.randomUUID().toString());
        alertLog.setMessage(message);
        alertLog.setSubSystem(subSystem);
        alertLog.setCreatedAt(LocalDateTime.now());

        if (alertLogRepository != null) {
            alertLogRepository.save(alertLog);
            return;
        }
        alertLogs.add(alertLog);
    }

    public synchronized List<AlertLog> findAll() {
        if (alertLogRepository != null) {
            return alertLogRepository.findAll();
        }
        return List.copyOf(alertLogs);
    }
}
