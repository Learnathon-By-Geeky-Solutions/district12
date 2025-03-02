package com.district12.backend.dtos.request.alert;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AlertsReadRequest {

    private List<Long> alertIds;

}
