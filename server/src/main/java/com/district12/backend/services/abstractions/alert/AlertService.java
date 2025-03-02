package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.response.alert.AlertResponse;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.Alert;

import java.util.List;

public interface AlertService {

    AlertResponse getAlertById(Long alertId);
    DetailedAlertResponse getAlertDetailsById(Long alertId);
    List<DetailedAlertResponse> getAllAlertsByType(String alertType);
    List<DetailedAlertResponse> getAllAlertsByUserId(Long userId);

}