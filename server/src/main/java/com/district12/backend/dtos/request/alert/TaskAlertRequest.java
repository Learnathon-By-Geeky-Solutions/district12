package com.district12.backend.dtos.request.alert;

import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import com.district12.backend.enums.TaskType;
import jakarta.validation.constraints.NotNull;
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

    @NotNull(message = "User ID cannot be null")
    private Long userId;
    @NotNull(message = "Alert type cannot be null")
    private AlertType alertType;
    @NotNull(message = "Alert priority list cannot be null")
    private AlertPriority alertPriority;
    @NotNull(message = "Task type cannot be null")
    private TaskType taskType;
    @NotNull(message = "Due time cannot be null")
    private ZonedDateTime dueTime;

}
