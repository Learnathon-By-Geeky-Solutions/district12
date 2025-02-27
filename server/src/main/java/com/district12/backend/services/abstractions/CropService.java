package com.district12.backend.services.abstractions;

import com.district12.backend.dtos.response.CropResponse;

import java.util.List;

public interface CropService {

    List<CropResponse> getAllCrops();
    CropResponse getCropDetailsById(Long id);
    List<CropResponse> getUserCrops(Long userId);

}