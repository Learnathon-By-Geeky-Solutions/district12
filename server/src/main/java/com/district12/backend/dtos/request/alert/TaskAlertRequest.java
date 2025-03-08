package com.district12.backend.dtos.request.alert;

import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import com.district12.backend.enums.TaskType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaskAlertRequest {

    private Long userId;
    private AlertType alertType;
    private AlertPriority alertPriority;
    private ZonedDateTime createdAt;
    private ZonedDateTime readAt;
    private TaskType taskType;
    private ZonedDateTime dueTime;

}
