package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;

import java.util.List;

public interface TaskAlertService {

    DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse);
    List<DetailedAlertResponse> getAllAlertsByTaskType(String taskType);

}
