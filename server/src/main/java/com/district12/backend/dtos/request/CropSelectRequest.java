package com.district12.backend.dtos.request;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class CropSelectRequest {

    @NotEmpty(message = "Alert IDs list cannot be empty")
    private List<Long> cropIds;

}