package com.district12.backend.repositories.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.TaskAlert;
import com.district12.backend.enums.CropAlertType;
import com.district12.backend.enums.TaskType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskAlertRepository extends JpaRepository<TaskAlert, Long> {

    @Query(value = """
        SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(
            a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt
        )
        FROM TaskAlert ta
        JOIN Alert a ON ta.alert.id = a.id
        WHERE ta.taskType = :taskType
    """)
    List<DetailedAlertResponse> findByTaskType(@Param("taskType") TaskType taskType);

}
