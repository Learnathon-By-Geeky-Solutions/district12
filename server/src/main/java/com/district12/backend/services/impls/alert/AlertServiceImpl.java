package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.AlertResponse;
import com.district12.backend.entities.alert.Alert;
import com.district12.backend.enums.AlertType;
import com.district12.backend.repositories.alert.AlertRepository;
import com.district12.backend.services.abstractions.alert.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;

    @Override
    public Alert getAlertById(Long alertId) {
        return alertRepository.findById(alertId).orElse(null);
    }

    @Override
    public List<AlertResponse> getAllAlertsByType(String alertType) {
        try {
            AlertType type = AlertType.valueOf(alertType.toUpperCase());
            return alertRepository.findAllByAlertType(type);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid alert type: " + alertType);
        }
    }

    @Override
    public List<AlertResponse> getAllAlertsByUserId(Long userId) {
        try {
            return alertRepository.findAllByUserId(userId);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("No alerts found for userId: " + userId);
        }
    }

}