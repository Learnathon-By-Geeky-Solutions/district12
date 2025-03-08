package com.district12.backend.dtos.request.alert;

import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import com.district12.backend.enums.CropAlertType;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CropAlertRequest {

    @NotNull(message = "User ID cannot be null")
    private Long userId;

    @NotNull(message = "Alert type cannot be null")
    private AlertType alertType;

    @NotNull(message = "Alert priority cannot be null")
    private AlertPriority alertPriority;

    @NotNull(message = "Crop alert type cannot be null")
    private CropAlertType cropAlertType;

    @NotNull(message = "User Crop ID cannot be null")
    private Long userCropId;
}