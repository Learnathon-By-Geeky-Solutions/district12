package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.request.alert.WeatherAlertRequest;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.User;
import com.district12.backend.entities.alert.Alert;
import com.district12.backend.entities.alert.WeatherAlert;
import com.district12.backend.enums.WeatherAlertType;
import com.district12.backend.repositories.alert.AlertRepository;
import com.district12.backend.repositories.alert.WeatherAlertRepository;
import com.district12.backend.services.UserService;
import com.district12.backend.services.abstractions.alert.WeatherAlertService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherAlertServiceImpl implements WeatherAlertService {

    private final WeatherAlertRepository weatherAlertRepository;
    private final UserService userService;
    private final AlertRepository alertRepository;

    @Override
    public WeatherAlert getWeatherAlertById(Long weatherAlertId) {
        return weatherAlertRepository.findById(weatherAlertId).orElseThrow(
                () -> new EntityNotFoundException("Weather Alert not found with id: " + weatherAlertId)
        );
    }

    @Override
    public DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse) {
        WeatherAlert weatherAlert = this.getWeatherAlertById(detailedAlertResponse.getId());

        detailedAlertResponse.addDetail("weatherType", weatherAlert.getWeatherAlertType());
        detailedAlertResponse.addDetail("forecastedAt", weatherAlert.getForecastedAt());

        return detailedAlertResponse;
    }

    private DetailedAlertResponse addDetailsToAlertWIO(
            DetailedAlertResponse detailedAlertResponse, WeatherAlert weatherAlert) {
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

    @Override
    public DetailedAlertResponse createNewAlert(WeatherAlertRequest weatherAlertRequest) {
        User user = userService.getUserById(weatherAlertRequest.getUserId());
        Alert newAlert = alertRepository.save(new Alert(user, weatherAlertRequest.getAlertType(), weatherAlertRequest.getAlertPriority()));

        WeatherAlert newWeatherAlert = weatherAlertRepository.save(new WeatherAlert(newAlert, weatherAlertRequest.getWeatherAlertType(), weatherAlertRequest.getForecastedAt()));

        DetailedAlertResponse newAlertResponse = new DetailedAlertResponse(newAlert.getId(), newAlert.getUser().getId(), newAlert.getAlertType(), newAlert.getAlertPriority(), newAlert.getCreatedAt(), newAlert.getReadAt());
        return addDetailsToAlertWIO(newAlertResponse, newWeatherAlert);
    }

    @Override
    public void deleteByAlertId(Long alertId) {
        weatherAlertRepository.deleteById(alertId);
    }

}
