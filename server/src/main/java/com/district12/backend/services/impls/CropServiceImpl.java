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

    @Override
    public List<CropResponse> deselectCropsForUser(List<Long> userCropIds) {
        List<UserCrop> userCropsList = userCropRepository.findAllById(userCropIds);
        if (userCropsList.isEmpty()) {
            throw new EntityNotFoundException("No user crops found for the provided IDs.");
        }

        List<CropResponse> cropResponses = userCropsList.stream()
                .map(uc -> new CropResponse(
                        uc.getCrop().getId(),
                        uc.getCrop().getName(),
                        uc.getCrop().getDescription()))
                .toList();

        userCropRepository.deleteAll(userCropsList);

        return cropResponses;
    }

    @Override
    public CropResponse addNewCrop(String name, String description) {
        Crop newCrop = cropRepository.save(new Crop(name, description));
        return new CropResponse(newCrop.getId(), newCrop.getName(), newCrop.getDescription());
    }

    @Override
    public boolean deleteCrop(Long cropId) {
        if (cropRepository.existsById(cropId)) {
            cropRepository.deleteById(cropId);
            return true;
        }
        return false;
    }


}