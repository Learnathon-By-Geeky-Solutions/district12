package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;

import java.util.List;

public interface CropAlertService {

    DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse);
    List<DetailedAlertResponse> getAllAlertsByCropAlertType(String cropAlertType);
}
