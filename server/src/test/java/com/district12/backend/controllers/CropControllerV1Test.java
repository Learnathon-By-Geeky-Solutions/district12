package com.district12.backend.controllers;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.services.abstractions.CropService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
class CropControllerV1Test {

    private MockMvc mockMvc;

    @Mock
    private CropService cropService;

    @InjectMocks
    private CropControllerV1 cropControllerV1;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(cropControllerV1).build();
    }

    @Test
    void testGetAllCrops() throws Exception {
        List<CropResponse> mockCrops = List.of(
                new CropResponse(1L, "Wheat", "A staple grain"),
                new CropResponse(2L, "Rice", "Popular in Asia")
        );

        when(cropService.getAllCrops()).thenReturn(mockCrops);

        mockMvc.perform(get("/v1/api/crops/"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Wheat"))
                .andExpect(jsonPath("$[1].name").value("Rice"));
    }
}
