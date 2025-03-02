package com.district12.backend.controllers.alert;

import com.district12.backend.dtos.request.alert.AlertsReadRequest;
import com.district12.backend.dtos.response.alert.AlertResponse;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.services.abstractions.alert.AlertService;
import com.district12.backend.utils.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/alert")
@RequiredArgsConstructor
@Slf4j
public class AlertControllerV1 {

    private final AlertService alertService;

    @GetMapping("/{alertId}")
    public ResponseEntity<AlertResponse> getAlertById(@PathVariable("alertId") Long alertId) {
        AlertResponse alertById = alertService.getAlertById(alertId);
        return ResponseEntity.ok(alertById);
    }

    @GetMapping("/details/{alertId}")
    public ResponseEntity<DetailedAlertResponse> getAlertDetailsById(@PathVariable("alertId") Long alertId) {
        DetailedAlertResponse alertById = alertService.getAlertDetailsById(alertId);
        return ResponseEntity.ok(alertById);
    }

    // Admin/Local Officer fetches all alerts of a certain type
    @GetMapping("/type/{alertType}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByType(
            @PathVariable("alertType") String alertType) {
        List<DetailedAlertResponse> alertsByType = alertService.getAllAlertsByType(alertType);
        return ResponseEntity.ok(alertsByType);
    }

    // Admin/Local Officer fetches all alerts of a certain user ID
    @GetMapping("/type/{userId}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByUserId(@PathVariable Long userId) {
        List<DetailedAlertResponse> alertsByUserId = alertService.getAllAlertsByUserId(userId);
        return ResponseEntity.ok(alertsByUserId);
    }

    @GetMapping("/user/un-read")
    public ResponseEntity<List<DetailedAlertResponse>> getUnreadAlertsByUserId() {
        List<DetailedAlertResponse> unreadAlertsByUserId =
                alertService.getUnreadAlertsByUserId(SecurityUtils.getOwnerID());
        return ResponseEntity.ok(unreadAlertsByUserId);
    }

    @PutMapping("/user/mark-read/{alertId}")
    public int markAlertReadByUser(@PathVariable("alertId") Long alertId) {
        return alertService.markAlertAsReadByUser(SecurityUtils.getOwnerID(), alertId);
    }

    @PostMapping("/user/mark-read")
    public int markAlertsReadByUser(@Valid @RequestBody AlertsReadRequest alertsReadRequest) {
        return alertService.markAlertsAsReadByUser(SecurityUtils.getOwnerID(),
                alertsReadRequest.getAlertIds());
    }

}
