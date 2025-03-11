package com.district12.backend.controllers;

import com.district12.backend.dtos.request.CropSelectRequest;
import com.district12.backend.dtos.request.NewCropRequest;
import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.User;
import com.district12.backend.services.UserService;
import com.district12.backend.services.abstractions.CropService;
import com.district12.backend.utils.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/crops")
@RequiredArgsConstructor
@Slf4j
public class CropControllerV1 {

    private final CropService cropService;
    private final UserService userService;

    @GetMapping("/")
    public ResponseEntity<List<CropResponse>> getAllCrops() {
        List<CropResponse> allCrops = cropService.getAllCrops();
        return ResponseEntity.ok(allCrops);
    }

    @GetMapping("/{cropId}")
    public ResponseEntity<CropResponse> getCropDetails(
            @PathVariable Long cropId
    ) {
        CropResponse cropResponse = cropService.getCropDetailsById(cropId);
        return ResponseEntity.ok(cropResponse);
    }

    @PostMapping("/user/select")
    public ResponseEntity<List<CropResponse>> selectCropsForUser(
            @Valid @RequestBody CropSelectRequest cropSelectRequest
    ) {
        User user = userService.getUserById(SecurityUtils.getOwnerID());
        List<CropResponse> selectedCropsResponse = cropService.selectCropsForUser(user, cropSelectRequest.getCropIds());
        return ResponseEntity.ok(selectedCropsResponse);
    }

    @GetMapping("/user")
    public ResponseEntity<List<CropResponse>> getUserCrops() {
        List<CropResponse> cropResponses = cropService.getUserCrops(SecurityUtils.getOwnerID());
        return ResponseEntity.ok(cropResponses);
    }

    @PostMapping("/user/deselect")
    public ResponseEntity<List<CropResponse>> deSelectCropsForUser(
            @Valid @RequestBody CropSelectRequest cropDeselectRequest
    ) {
        List<CropResponse> deselectedCropsResponse = cropService.deselectCropsForUser(cropDeselectRequest.getCropIds());
        return ResponseEntity.ok(deselectedCropsResponse);
    }

    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    @PostMapping("/add")
    public ResponseEntity<CropResponse> addNewCrop(
            @Valid @RequestBody NewCropRequest newCropRequest
    ) {
        CropResponse deselectedCropsResponse = cropService.addNewCrop(newCropRequest.getName(), newCropRequest.getDescription());
        return ResponseEntity.ok(deselectedCropsResponse);
    }

    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    @DeleteMapping("/delete/{cropId}")
    public ResponseEntity<String> deleteCrop(@PathVariable Long cropId) {
        boolean isDeleted = cropService.deleteCrop(cropId);
        if (isDeleted) {
            return ResponseEntity.ok("Crop deleted successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Crop not found or could not be deleted.");
        }
    }


}