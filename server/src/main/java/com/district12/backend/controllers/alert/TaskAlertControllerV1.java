package com.district12.backend.controllers.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.services.abstractions.alert.CropAlertService;
import com.district12.backend.services.abstractions.alert.TaskAlertService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/alert/task")
@RequiredArgsConstructor
@Slf4j
public class TaskAlertControllerV1 {

    private final TaskAlertService taskAlertService;

    // Admin/Local Officer fetches all task alerts of a task type
    @GetMapping("/type/{taskType}")
    @PreAuthorize("hasAnyAuthority(T(com.district12.backend.enums.Role).ADMIN.value, " +
            "T(com.district12.backend.enums.Role).OFFICER.value)")
    public ResponseEntity<List<DetailedAlertResponse>> getAllAlertsByTaskType(
            @PathVariable("taskType") String taskType) {
        List<DetailedAlertResponse> alertsByTaskType = taskAlertService.getAllAlertsByTaskType(taskType);
        return ResponseEntity.ok(alertsByTaskType);
    }

}
