package com.district12.backend.dtos.request.alert;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AlertsReadRequest {

    @NotEmpty(message = "Alert IDs list cannot be empty")
    private List<Long> alertIds;

}
