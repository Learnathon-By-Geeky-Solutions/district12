package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.UserCrop;
import com.district12.backend.entities.alert.CropAlert;
import com.district12.backend.entities.alert.TaskAlert;
import com.district12.backend.repositories.alert.TaskAlertRepository;
import com.district12.backend.services.abstractions.alert.TaskAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TaskAlertServiceImpl implements TaskAlertService {

    private final TaskAlertRepository taskAlertRepository;

    @Override
    public DetailedAlertResponse addDetailsToAlert(DetailedAlertResponse detailedAlertResponse) {
        TaskAlert taskAlert = taskAlertRepository.findById(detailedAlertResponse.getId()).orElse(null);

        detailedAlertResponse.addDetail("taskType", taskAlert.getTaskType());
        detailedAlertResponse.addDetail("dueTime", taskAlert.getDueTime());

        return detailedAlertResponse;
    }

}
