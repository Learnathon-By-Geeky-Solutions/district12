package com.district12.backend.repositories.alert;

import com.district12.backend.entities.alert.WeatherAlert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {
}
