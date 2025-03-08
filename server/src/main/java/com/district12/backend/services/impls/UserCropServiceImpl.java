package com.district12.backend.services.impls;

import com.district12.backend.entities.UserCrop;
import com.district12.backend.repositories.UserCropRepository;
import com.district12.backend.services.abstractions.UserCropService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserCropServiceImpl implements UserCropService {

    private final UserCropRepository userCropRepository;

    @Override
    public UserCrop getUserCropById(Long userCropId) {
        return userCropRepository.findById(userCropId).orElseThrow(
                () -> new EntityNotFoundException("User Crop not found with id: " + userCropId)
        );
    }

}
