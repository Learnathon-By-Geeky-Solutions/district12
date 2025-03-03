package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.request.alert.TaskAlertRequest;
import com.district12.backend.dtos.response.alert.DetailedAlertResponse;

import java.time.ZonedDateTime;
import java.util.List;

public interface TaskAlertService {

    DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse);
    List<DetailedAlertResponse> getAllAlertsByTaskType(String taskType);
    List<DetailedAlertResponse> getAllAlertsByDueTime(ZonedDateTime dueTime);
    DetailedAlertResponse createNewAlert(TaskAlertRequest taskAlertRequest);
    void deleteByAlertId(Long alertId);

}
