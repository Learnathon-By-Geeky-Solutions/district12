package com.district12.backend.services.impls.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.TaskAlert;
import com.district12.backend.enums.CropAlertType;
import com.district12.backend.enums.TaskType;
import com.district12.backend.repositories.alert.TaskAlertRepository;
import com.district12.backend.services.abstractions.alert.TaskAlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

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

    private List<DetailedAlertResponse> addDetailsToAlerts(List<DetailedAlertResponse> detailedAlertResponses) {
        return detailedAlertResponses.stream()
                .map(this::addDetailsToAlert)
                .toList();
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByTaskType(String taskType) {
        TaskType type = TaskType.valueOf(taskType.toUpperCase());
        return addDetailsToAlerts(taskAlertRepository.findByTaskType(type));
    }

    @Override
    public List<DetailedAlertResponse> getAllAlertsByDueTime(ZonedDateTime dueTime) {
        return addDetailsToAlerts(taskAlertRepository.findByDueTime(dueTime));
    }

}
