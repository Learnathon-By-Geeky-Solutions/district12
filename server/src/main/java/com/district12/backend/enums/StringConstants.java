package com.district12.backend.enums;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StringConstants {
    SUCCESS("success"),
    MESSAGE("message"),
    ERROR("error");

    private final String value;
}

