package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.TaskAlert;
import com.district12.backend.entities.alert.WeatherAlert;
import com.district12.backend.repositories.alert.WeatherAlertRepository;
import com.district12.backend.services.abstractions.alert.WeatherAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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

}
