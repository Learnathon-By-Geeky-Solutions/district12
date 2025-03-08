package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.response.alert.AlertResponse;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.User;
import com.district12.backend.entities.alert.Alert;
import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;

import java.util.List;

public interface AlertService {

    Alert getAlertById(Long alertId);
    Alert saveAlert(Alert alert);
    AlertResponse getAlertResponseById(Long alertId);
    DetailedAlertResponse getAlertDetailsById(Long alertId);
    List<DetailedAlertResponse> getAllAlertsByType(String alertType);
    List<DetailedAlertResponse> getAllAlertsByUserId(Long userId);
    List<DetailedAlertResponse> getUnreadAlertsByUserId(Long userId);
    int markAlertAsReadByUser(Long userId, Long alertId);
    int markAlertsAsReadByUser(Long userId, List<Long> alertIds);
    boolean deleteAlertById(Long alertId);

}