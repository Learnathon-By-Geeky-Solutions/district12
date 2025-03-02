package com.district12.backend.controllers.alert;

import com.district12.backend.dtos.response.alert.AlertResponse;
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

    // Admin/Local Officer fetches all alerts of a certain type
    @GetMapping("/type/{alertType}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<AlertResponse>> getAllAlertsByType(
            @PathVariable("alertType") String alertType) {
        List<AlertResponse> alertsByType = alertService.getAllAlertsByType(alertType);
        return ResponseEntity.ok(alertsByType);
    }

    // Admin/Local Officer fetches all alerts of a certain user ID
    @GetMapping("/type/{userId}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<AlertResponse>> getAllAlertsByUserId(@PathVariable Long userId) {
        List<AlertResponse> alertsByUserId = alertService.getAllAlertsByUserId(userId);
        return ResponseEntity.ok(alertsByUserId);
    }



}
