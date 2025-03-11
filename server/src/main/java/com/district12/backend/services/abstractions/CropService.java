package com.district12.backend.services.abstractions;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.User;

import java.util.List;

public interface CropService {

    List<CropResponse> getAllCrops();
    CropResponse getCropDetailsById(Long id);
    List<CropResponse> getUserCrops(Long userId);
    List<CropResponse> selectCropsForUser(User user, List<Long> cropIds);
    List<CropResponse> deselectCropsForUser(List<Long> userCropIds);
    CropResponse addNewCrop(String name, String description);
    boolean deleteCrop(Long cropId);

}