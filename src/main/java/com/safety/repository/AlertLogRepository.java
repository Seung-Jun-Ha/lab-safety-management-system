package com.safety.repository;

import com.safety.model.AlertLog;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Repository
public class AlertLogRepository {

    private final List<AlertLog> alertLogs = new CopyOnWriteArrayList<>();

    public AlertLog save(AlertLog alertLog) {
        alertLogs.add(alertLog);
        return alertLog;
    }

    public List<AlertLog> findAll() {
        return List.copyOf(alertLogs);
    }
}
