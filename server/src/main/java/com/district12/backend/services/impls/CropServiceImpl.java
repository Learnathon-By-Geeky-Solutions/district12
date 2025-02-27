package com.district12.backend.services.impls;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.Crop;
import com.district12.backend.entities.User;
import com.district12.backend.entities.UserCrop;
import com.district12.backend.repositories.CropRepository;
import com.district12.backend.repositories.UserCropRepository;
import com.district12.backend.services.abstractions.CropService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;
    private final UserCropRepository userCropRepository;

    @Override
    public List<CropResponse> getAllCrops() {
        return cropRepository.findAllCrops();
    }

    @Override
    public CropResponse getCropDetailsById(Long id) {
        return cropRepository.getCropDetailsById(id);
    }

    @Override
    public List<CropResponse> getUserCrops(Long userId) {
        return userCropRepository.findAllCropsByUserId(userId);
    }

    private List<Crop> getCropsById(List<Long> cropIds) {
        List<Crop> crops = cropRepository.findAllById(cropIds);
        if (crops.size() != cropIds.size())
            throw new EntityNotFoundException("Some crops not found for provided IDs.");
        return crops;
    }

    @Override
    public List<CropResponse> selectCropsForUser(User user, List<Long> cropIds) {

        List<Crop> crops = getCropsById(cropIds);
        List<CropResponse> cropResponses = new ArrayList<>();

        for (Crop crop : crops) {
            UserCrop userCrop = new UserCrop(user, crop, ZonedDateTime.now());
            userCropRepository.save(userCrop);
            cropResponses.add(new CropResponse(crop.getId(), crop.getName(), crop.getDescription()));
        }

        return cropResponses;
    }

}