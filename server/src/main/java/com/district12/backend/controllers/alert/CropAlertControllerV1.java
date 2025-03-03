package com.district12.backend.controllers.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.services.abstractions.alert.CropAlertService;
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
@RequestMapping("/v1/alert/crop")
@RequiredArgsConstructor
@Slf4j
public class CropAlertControllerV1 {

    private final CropAlertService cropAlertService;

    // Admin/Local Officer fetches all alerts of a certain crop Alert type
    @GetMapping("/type/{cropAlertType}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByCropAlertType(
            @PathVariable("cropAlertType") String cropAlertType) {
        List<DetailedAlertResponse> cropAlertsByCropAlertType = cropAlertService.getAllAlertsByCropAlertType(cropAlertType);
        return ResponseEntity.ok(cropAlertsByCropAlertType);
    }

    // Admin/Local Officer fetches all alerts of a certain crop
    @GetMapping("/id/{cropId}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByCropId(
            @PathVariable("cropId") Long cropId) {
        List<DetailedAlertResponse> cropAlertsByCropId = cropAlertService.getAllAlertsByCropId(cropId);
        return ResponseEntity.ok(cropAlertsByCropId);
    }

}
