package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.response.alert.AlertResponse;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;

import java.util.List;

public interface AlertService {

    AlertResponse getAlertById(Long alertId);
    DetailedAlertResponse getAlertDetailsById(Long alertId);
    List<DetailedAlertResponse> getAllAlertsByType(String alertType);
    List<DetailedAlertResponse> getAllAlertsByUserId(Long userId);
    List<DetailedAlertResponse> getUnreadAlertsByUserId(Long userId);
    int markAlertAsReadByUser(Long userId, Long alertId);
    int markAlertsAsReadByUser(Long userId, List<Long> alertIds);
    boolean deleteAlertById(Long alertId);

}