package com.district12.backend.services.impls;

import com.district12.backend.repositories.CropRepository;
import com.district12.backend.repositories.UserCropRepository;
import com.district12.backend.services.abstractions.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;
    private final UserCropRepository userCropRepository;

}