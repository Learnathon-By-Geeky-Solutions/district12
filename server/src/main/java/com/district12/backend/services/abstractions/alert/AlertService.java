package com.district12.backend.services.abstractions.alert;

import com.district12.backend.entities.alert.Alert;

import java.util.List;

public interface AlertService {

    Alert getAlertById(Long alertId);
    List<Alert> getAllAlertsByType(String alertType);

}