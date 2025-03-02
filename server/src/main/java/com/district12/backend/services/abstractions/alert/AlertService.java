package com.district12.backend.services.abstractions.alert;

import com.district12.backend.entities.alert.Alert;

public interface AlertService {

    Alert getAlertById(Long alertId);

}