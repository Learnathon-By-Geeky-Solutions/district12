package com.district12.backend.services.impls;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.repositories.CropRepository;
import com.district12.backend.services.abstractions.CropService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropServiceImpl implements CropService {

    private final CropRepository cropRepository;

    @Override
    public List<CropResponse> getAllCrops() {
        return cropRepository.findAllCrops();
    }

    @Override
    public CropResponse getCropDetailsById(Long id) {
        return cropRepository.getCropDetailsById(id);
    }

}