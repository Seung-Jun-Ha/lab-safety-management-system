package com.safety.service;

import com.safety.model.AlertLog;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class AlertLogService {

    private final List<AlertLog> alertLogs = new ArrayList<>();

    public synchronized void createLog(String message, String subSystem) {
        alertLogs.add(new AlertLog(message, subSystem, LocalDateTime.now()));
    }

    public synchronized List<AlertLog> findAll() {
        return List.copyOf(alertLogs);
    }
}
