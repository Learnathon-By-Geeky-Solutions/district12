package com.district12.backend.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Role {
    GUEST("SCOPE_GUEST"),
    USER("SCOPE_USER"),
    OFFICER("SCOPE_OFFICER"),
    ADMIN("SCOPE_ADMIN");

    private final String value;
}
