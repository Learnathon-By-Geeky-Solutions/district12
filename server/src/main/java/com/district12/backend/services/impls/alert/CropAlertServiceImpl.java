package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.request.alert.CropAlertRequest;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.User;
import com.district12.backend.entities.UserCrop;
import com.district12.backend.entities.alert.Alert;
import com.district12.backend.entities.alert.CropAlert;
import com.district12.backend.enums.CropAlertType;
import com.district12.backend.repositories.alert.CropAlertRepository;
import com.district12.backend.services.UserService;
import com.district12.backend.services.abstractions.UserCropService;
import com.district12.backend.services.abstractions.alert.AlertService;
import com.district12.backend.services.abstractions.alert.CropAlertService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CropAlertServiceImpl implements CropAlertService {

    private final CropAlertRepository cropAlertRepository;
    private final UserService userService;
    private final UserCropService userCropService;
    private final AlertService alertService;

    @Override
    public CropAlert getCropAlertById(Long cropAlertId) {
        return cropAlertRepository.findById(cropAlertId).orElseThrow(
                () -> new EntityNotFoundException("Crop Alert not found with id: " + cropAlertId)
        );
    }

    @Override
    public DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse) {

        CropAlert cropAlert = this.getCropAlertById(detailedAlertResponse.getId());
        UserCrop userCrop = userCropService.getUserCropById(cropAlert.getUserCrop().getId());

        detailedAlertResponse.addDetail("cropId", userCrop.getCrop().getId());
        detailedAlertResponse.addDetail("userCropId", userCrop.getId());
        detailedAlertResponse.addDetail("cropName", userCrop.getCrop().getName());
        detailedAlertResponse.addDetail("cropAlertType", cropAlert.getCropAlertType());

        return detailedAlertResponse;
    }

    private DetailedAlertResponse addDetailsToAlertWIO(
            DetailedAlertResponse detailedAlertResponse, CropAlert cropAlert, UserCrop userCrop) {
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

    @Override
    public DetailedAlertResponse createNewAlert(CropAlertRequest cropAlertRequest) {
        User user = userService.getUserById(cropAlertRequest.getUserId());
        Alert newAlert = alertService.saveAlert(new Alert(user, cropAlertRequest.getAlertType(), cropAlertRequest.getAlertPriority()));

        UserCrop userCrop = userCropService.getUserCropById(cropAlertRequest.getUserCropId());
        CropAlert newCropAlert = cropAlertRepository.save(new CropAlert(newAlert, userCrop, cropAlertRequest.getCropAlertType()));

        DetailedAlertResponse newAlertResponse = new DetailedAlertResponse(newAlert.getId(), newAlert.getUser().getId(), newAlert.getAlertType(), newAlert.getAlertPriority(), newAlert.getCreatedAt(), newAlert.getReadAt());
        return addDetailsToAlertWIO(newAlertResponse, newCropAlert, userCrop);
    }

    @Override
    public void deleteByAlertId(Long alertId) {
        cropAlertRepository.deleteById(alertId);
    }

}
