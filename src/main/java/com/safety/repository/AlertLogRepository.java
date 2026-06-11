package com.safety.repository;

import com.safety.model.AlertLog;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class AlertLogRepository {

    private final AtomicLong sequence = new AtomicLong(1);
    private final List<AlertLog> logs = new CopyOnWriteArrayList<>();

    public void save(AlertLog alertLog) {
        if (alertLog.getLogId() == null) {
            alertLog.setLogId(sequence.getAndIncrement());
        }
        logs.add(alertLog);
    }

    public List<AlertLog> findAll() {
        return new ArrayList<>(logs);
    }

    public void clear() {
        logs.clear();
        sequence.set(1);
    }
}
