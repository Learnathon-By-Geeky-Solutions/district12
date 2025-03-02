package com.district12.backend.dtos.response.alert;

import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import com.district12.backend.enums.TaskType;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class TaskAlertResponse {

    private Long id;
    private Long userId;
    private AlertType alertType;
    private AlertPriority alertPriority;
    private ZonedDateTime createdAt;
    private ZonedDateTime readAt;
    private TaskType taskType;
    private ZonedDateTime dueTime;

}
