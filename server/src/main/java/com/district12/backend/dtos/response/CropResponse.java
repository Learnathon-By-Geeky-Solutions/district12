package com.district12.backend.dtos.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CropResponse {

    private Long id;
    private String name;
    private String description;

}