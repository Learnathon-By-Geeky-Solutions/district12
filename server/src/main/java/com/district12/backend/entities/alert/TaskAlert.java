package com.district12.backend.entities.alert;

import com.district12.backend.enums.TaskType;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "task_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskAlert {

    @Id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "alert_id", referencedColumnName = "id", nullable = false)
    private Alert alert;

    @Enumerated(EnumType.STRING)
    @Column(name = "task_type", nullable = false)
    private TaskType taskType;

    @Column(name = "due_time", nullable = false)
    private ZonedDateTime dueTime;
}
