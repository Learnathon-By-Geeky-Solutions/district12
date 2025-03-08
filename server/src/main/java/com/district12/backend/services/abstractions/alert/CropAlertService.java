package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.request.alert.CropAlertRequest;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.CropAlert;

import java.util.List;

public interface CropAlertService {

    CropAlert getCropAlertById(Long cropAlertId);
    DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse);
    List<DetailedAlertResponse> getAllAlertsByCropAlertType(String cropAlertType);
    List<DetailedAlertResponse> getAllAlertsByCropId(Long cropId);
    DetailedAlertResponse createNewAlert(CropAlertRequest cropAlertRequest);
    void deleteByAlertId(Long alertId);

}
