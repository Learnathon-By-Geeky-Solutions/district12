package com.district12.backend.repositories.alert;

import com.district12.backend.entities.alert.TaskAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskAlertRepository extends JpaRepository<TaskAlert, Long> {
}
