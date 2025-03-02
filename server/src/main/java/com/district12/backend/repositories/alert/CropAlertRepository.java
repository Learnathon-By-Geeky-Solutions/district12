package com.district12.backend.repositories.alert;

import com.district12.backend.entities.alert.CropAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CropAlertRepository extends JpaRepository<CropAlert, Long> {
}
