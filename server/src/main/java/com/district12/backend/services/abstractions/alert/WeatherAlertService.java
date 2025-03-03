package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.request.alert.WeatherAlertRequest;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;

import java.time.ZonedDateTime;
import java.util.List;

public interface WeatherAlertService {

    DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse);
    List<DetailedAlertResponse> getAllAlertsByWeatherAlertType(String taskType);
    List<DetailedAlertResponse> getAllAlertsByForecastedAt(ZonedDateTime forecastedAt);
    DetailedAlertResponse createNewAlert(WeatherAlertRequest weatherAlertRequest);
    void deleteByAlertId(Long alertId);

}
