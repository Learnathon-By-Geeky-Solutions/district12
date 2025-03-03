package com.district12.backend.dtos.response.alert;

import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.ZonedDateTime;
import java.util.Map;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class DetailedAlertResponse {

    private Long id;
    private Long userId;
    private AlertType alertType;
    private AlertPriority alertPriority;
    private ZonedDateTime createdAt;
    private ZonedDateTime readAt;
    private Map<String, Object> details;

    public DetailedAlertResponse(Long id, Long userId, AlertType alertType, AlertPriority alertPriority, ZonedDateTime createdAt, ZonedDateTime readAt) {
        this.id = id;
        this.userId = userId;
        this.alertType = alertType;
        this.alertPriority = alertPriority;
        this.createdAt = createdAt;
        this.readAt = readAt;
    }

    @JsonAnySetter
    public void addDetail(String key, Object value) {
        details.put(key, value);
    }

    @JsonAnyGetter
    public Map<String, Object> getDetails() {
        return details;
    }

    public Optional<Object> getDetail(String key) {
        return Optional.ofNullable(details.get(key));
    }
}