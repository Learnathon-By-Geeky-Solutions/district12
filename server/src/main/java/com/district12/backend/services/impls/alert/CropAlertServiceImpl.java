package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.UserCrop;
import com.district12.backend.entities.alert.CropAlert;
import com.district12.backend.enums.CropAlertType;
import com.district12.backend.repositories.UserCropRepository;
import com.district12.backend.repositories.alert.CropAlertRepository;
import com.district12.backend.services.abstractions.alert.CropAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropAlertServiceImpl implements CropAlertService {

    private final CropAlertRepository cropAlertRepository;
    private final UserCropRepository userCropRepository;

    @Override
    public DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse) {

        CropAlert cropAlert = cropAlertRepository.findById(detailedAlertResponse.getId()).orElse(null);
        UserCrop userCrop = userCropRepository.findById(cropAlert.getUserCrop().getId()).orElse(null);

        detailedAlertResponse.addDetail("cropId", userCrop.getCrop().getId());
        detailedAlertResponse.addDetail("userCropId", userCrop.getId());
        detailedAlertResponse.addDetail("cropName", userCrop.getCrop().getName());
        detailedAlertResponse.addDetail("cropAlertType", cropAlert.getCropAlertType());

        return detailedAlertResponse;
    }

    private List<DetailedAlertResponse> addDetailsToAlerts(List<DetailedAlertResponse> detailedAlertResponses) {
        return detailedAlertResponses.stream()
                .map(this::addDetailsToAlert)
                .toList();
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByCropAlertType(String cropAlertType) {
        CropAlertType type = CropAlertType.valueOf(cropAlertType.toUpperCase());
        return addDetailsToAlerts(cropAlertRepository.findByCropAlertType(type));
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByCropId(Long cropId) {
        return addDetailsToAlerts(cropAlertRepository.findByCropId(cropId));
    }

}
