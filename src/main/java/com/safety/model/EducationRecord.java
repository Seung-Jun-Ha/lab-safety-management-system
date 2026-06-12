package com.safety.model;

import lombok.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EducationRecord {
    private String recordId;
    private String userId;
    private String scheduleId;
    private LocalDateTime completedAt;
    private int hoursCompleted;
}