package com.district12.backend.controllers;

import com.district12.backend.services.UserService;
import com.district12.backend.services.abstractions.CropService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/api/crops")
@RequiredArgsConstructor
@Slf4j
public class CropControllerV1 {

    private final CropService cropService;
    private final UserService userService;

}