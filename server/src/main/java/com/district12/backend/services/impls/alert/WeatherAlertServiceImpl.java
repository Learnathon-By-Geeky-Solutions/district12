package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.WeatherAlert;
import com.district12.backend.enums.TaskType;
import com.district12.backend.enums.WeatherAlertType;
import com.district12.backend.repositories.alert.WeatherAlertRepository;
import com.district12.backend.services.abstractions.alert.WeatherAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherAlertServiceImpl implements WeatherAlertService {

    private final WeatherAlertRepository weatherAlertRepository;

    @Override
    public DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse) {
        WeatherAlert weatherAlert = weatherAlertRepository.findById(detailedAlertResponse.getId()).orElse(null);

        detailedAlertResponse.addDetail("weatherType", weatherAlert.getWeatherAlertType());
        detailedAlertResponse.addDetail("forecastedAt", weatherAlert.getForecastedAt());

        return detailedAlertResponse;
    }

    private List<DetailedAlertResponse> addDetailsToAlerts(List<DetailedAlertResponse> detailedAlertResponses) {
        return detailedAlertResponses.stream()
                .map(this::addDetailsToAlert)
                .toList();
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByWeatherAlertType(String weatherType) {
        WeatherAlertType type = WeatherAlertType.valueOf(weatherType.toUpperCase());
        return addDetailsToAlerts(weatherAlertRepository.findByWeatherAlertType(type));
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByForecastedAt(ZonedDateTime forecastedAt) {
        return addDetailsToAlerts(weatherAlertRepository.findByForecastedAt(forecastedAt));
    }

}
