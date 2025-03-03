package com.district12.backend.controllers.alert;

import com.district12.backend.dtos.request.alert.WeatherAlertRequest;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.services.abstractions.alert.WeatherAlertService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.time.ZonedDateTime;
import java.util.List;

@RestController
@RequestMapping("/v1/alert/weather")
@RequiredArgsConstructor
@Slf4j
public class WeatherAlertControllerV1 {

    private final WeatherAlertService weatherAlertService;

    // Admin/Local Officer fetches all weather alerts of a weather alert type
    @GetMapping("/type/{weatherType}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByWeatherType(
            @PathVariable("weatherType") String weatherType) {
        List<DetailedAlertResponse> weatherAlertsByWeatherType = weatherAlertService.getAllAlertsByWeatherAlertType(weatherType);
        return ResponseEntity.ok(weatherAlertsByWeatherType);
    }

    // Admin/Local Officer fetches all weather alerts of certain forecast time
    @GetMapping("/forecast/{forecastedAt}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByForecast(
            @PathVariable("forecastedAt") ZonedDateTime forecastedAt) {
        List<DetailedAlertResponse> weatherAlertsByForecast = weatherAlertService.getAllAlertsByForecastedAt(forecastedAt);
        return ResponseEntity.ok(weatherAlertsByForecast);
    }

    // Admin/Local Officer creates new alert
    @PostMapping("/create")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<DetailedAlertResponse> createNewWeatherAlert(
            @Valid @RequestBody WeatherAlertRequest weatherAlertRequest) {
        DetailedAlertResponse createdAlert = weatherAlertService.createNewAlert(weatherAlertRequest);
        return ResponseEntity.ok(createdAlert);
    }

}
