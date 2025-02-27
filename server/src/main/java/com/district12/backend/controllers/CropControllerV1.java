package com.district12.backend.controllers;

import com.district12.backend.dtos.request.CropSelectRequest;
import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.User;
import com.district12.backend.services.UserService;
import com.district12.backend.services.abstractions.CropService;
import com.district12.backend.utils.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/api/crops")
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

}