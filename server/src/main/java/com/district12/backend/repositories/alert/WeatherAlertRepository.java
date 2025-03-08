package com.district12.backend.repositories.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.WeatherAlert;
import com.district12.backend.enums.WeatherAlertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherAlertRepository extends JpaRepository<WeatherAlert, Long> {

    @Query(value = """
        SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(
            a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt
        )
        FROM WeatherAlert wa
        JOIN Alert a ON wa.alert.id = a.id
        WHERE wa.weatherAlertType = :weatherAlertType
    """)
    List<DetailedAlertResponse> findByWeatherAlertType(@Param("weatherAlertType") WeatherAlertType weatherAlertType);

    @Query(value = """
        SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(
            a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt
        )
        FROM WeatherAlert wa
        JOIN Alert a ON wa.alert.id = a.id
        WHERE wa.forecastedAt = :forecastedAt
    """)
    List<DetailedAlertResponse> findByForecastedAt(@Param("forecastedAt") ZonedDateTime forecastedAt);

}
