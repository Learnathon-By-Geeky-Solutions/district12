package com.district12.backend.services.impls.alert;

import com.district12.backend.entities.alert.Alert;
import com.district12.backend.repositories.alert.AlertRepository;
import com.district12.backend.services.abstractions.alert.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepository;

    @Override
    public Alert getAlertById(Long alertId) {
        return alertRepository.findById(alertId).orElse(null);
    }

}