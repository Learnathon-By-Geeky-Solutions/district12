package com.district12.backend.services.abstractions.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;

public interface TaskAlertService {

    DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse);

}
