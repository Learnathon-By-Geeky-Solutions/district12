package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.AlertResponse;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.Alert;
import com.district12.backend.enums.AlertType;
import com.district12.backend.repositories.alert.AlertRepository;
import com.district12.backend.services.abstractions.alert.AlertService;
import com.district12.backend.services.abstractions.alert.CropAlertService;
import com.district12.backend.services.abstractions.alert.TaskAlertService;
import com.district12.backend.services.abstractions.alert.WeatherAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;

    private final CropAlertService cropAlertService;
    private final TaskAlertService taskAlertService;
    private final WeatherAlertService weatherAlertService;

    private DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse) {
        if(detailedAlertResponse.getAlertType() == AlertType.CROP)
            return cropAlertService.addDetailsToAlert(detailedAlertResponse);
        else if(detailedAlertResponse.getAlertType() == AlertType.TASK)
            return taskAlertService.addDetailsToAlert(detailedAlertResponse);
        else if(detailedAlertResponse.getAlertType() == AlertType.WEATHER)
            return weatherAlertService.addDetailsToAlert(detailedAlertResponse);

        return detailedAlertResponse;
    }

    private List<DetailedAlertResponse> addDetailsToAlerts(List<DetailedAlertResponse> detailedAlertResponses) {
        return detailedAlertResponses.stream()
                .map(this::addDetailsToAlert)
                .toList();
    }


    @Override
    public AlertResponse getAlertById(Long alertId) {
        Alert alertById = alertRepository.findById(alertId).orElse(null);
        if (alertById == null) return null;

        return new AlertResponse(alertById.getId(), alertById.getUser().getId(), alertById.getAlertType(),
                alertById.getAlertPriority(), alertById.getCreatedAt(), alertById.getReadAt());
    }

    @Override
    public DetailedAlertResponse getAlertDetailsById(Long alertId) {
        Alert alertById = alertRepository.findById(alertId).orElse(null);
        if (alertById == null) return null;

        DetailedAlertResponse detailedAlertResponse = new DetailedAlertResponse(alertById.getId(), alertById.getUser().getId(), alertById.getAlertType(),
                alertById.getAlertPriority(), alertById.getCreatedAt(), alertById.getReadAt());
        return addDetailsToAlert(detailedAlertResponse);
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByType(String alertType) {
        try {
            AlertType type = AlertType.valueOf(alertType.toUpperCase());
            return addDetailsToAlerts(alertRepository.findAllByAlertType(type));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid alert type: " + alertType);
        }
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByUserId(Long userId) {
        try {
            return addDetailsToAlerts(alertRepository.findAllByUserId(userId));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No alerts found for userId: " + userId);
        }
    }

    @Override
    public List<DetailedAlertResponse> getUnreadAlertsByUserId(Long userId) {
        return alertRepository.findUnreadAlertsByUserId(userId);
    }

    @Override
    public int markAlertAsReadByUser(Long userId, Long alertId) {
        return alertRepository.markAlertAsRead(userId, alertId);
    }

    @Override
    public int markAlertsAsReadByUser(Long userId, List<Long> alertIds) {
        return alertRepository.markAlertsAsRead(userId, alertIds);
    }

}