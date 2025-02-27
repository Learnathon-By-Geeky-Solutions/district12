package com.district12.backend.controllers;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.services.abstractions.CropService;
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

}