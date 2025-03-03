package com.district12.backend.dtos.request.alert;

import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import com.district12.backend.enums.WeatherAlertType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;

@Getter
@Setter
@AllArgsConstructor
public class WeatherAlertRequest {

    private Long userId;
    private AlertType alertType;
    private AlertPriority alertPriority;
    private ZonedDateTime createdAt;
    private ZonedDateTime readAt;
    private WeatherAlertType weatherAlertType;
    private ZonedDateTime forecastedAt;

}
