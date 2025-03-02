package com.district12.backend.controllers.alert;

import com.district12.backend.entities.alert.Alert;
import com.district12.backend.services.abstractions.alert.AlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/alert")
@RequiredArgsConstructor
@Slf4j
public class AlertControllerV1 {

    private final AlertService alertService;

    @GetMapping("/{alertId}")
    public ResponseEntity<Alert> getAlertById(@PathVariable("alertId") Long alertId) {
        Alert alertById = alertService.getAlertById(alertId);
        return ResponseEntity.ok(alertById);
    }

    @GetMapping("/type/{alertType}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<Alert>> getAllAlertsByType(
            @PathVariable("alertType") String alertType) {
        List<Alert> alertsByType = alertService.getAllAlertsByType(alertType);
        return ResponseEntity.ok(alertsByType);
    }


}
