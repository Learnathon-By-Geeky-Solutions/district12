package com.district12.backend.dtos.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NewCropRequest {

    @NotNull(message = "Crop name cannot be null")
    private String name;

    @NotNull(message = "Crop description cannot be null")
    private String description;

}
