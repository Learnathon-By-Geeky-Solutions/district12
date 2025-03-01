package com.district12.backend.controllers;

import com.district12.backend.dtos.request.CropSelectRequest;
import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.User;
import com.district12.backend.services.UserService;
import com.district12.backend.services.abstractions.CropService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
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

    @Mock
    private UserService userService;

    @InjectMocks
    private CropControllerV1 cropControllerV1;

    private final ObjectMapper objectMapper = new ObjectMapper();

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

    @Test
    void testGetCropDetails() throws Exception {
        CropResponse mockCrop = new CropResponse(1L, "Corn", "Yellow sweet corn");

        when(cropService.getCropDetailsById(1L)).thenReturn(mockCrop);

        mockMvc.perform(get("/v1/api/crops/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("Corn"))
                .andExpect(jsonPath("$.description").value("Yellow sweet corn"));
    }

    @Test
    void testSelectCropsForUser() throws Exception {
        CropSelectRequest request = new CropSelectRequest(List.of(1L, 2L));
        User mockUser = new User();
        List<CropResponse> selectedCrops = List.of(
                new CropResponse(1L, "Wheat", "A staple grain"),
                new CropResponse(2L, "Rice", "Popular in Asia")
        );

        when(userService.getUserById(anyLong())).thenReturn(mockUser);
        when(cropService.selectCropsForUser(any(User.class), any())).thenReturn(selectedCrops);

        mockMvc.perform(post("/v1/api/crops/user/select")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Wheat"))
                .andExpect(jsonPath("$[1].name").value("Rice"));
    }

    @Test
    void testGetUserCrops() throws Exception {
        List<CropResponse> mockCrops = List.of(
                new CropResponse(1L, "Tomato", "Grows in warm weather")
        );

        when(cropService.getUserCrops(anyLong())).thenReturn(mockCrops);

        mockMvc.perform(get("/v1/api/crops/user"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value("Tomato"));
    }

    @Test
    void testDeSelectCropsForUser() throws Exception {
        CropSelectRequest request = new CropSelectRequest(List.of(1L));

        List<CropResponse> mockCrops = List.of(
                new CropResponse(2L, "Rice", "Popular in Asia")
        );

        when(cropService.deselectCropsForUser(any())).thenReturn(mockCrops);

        mockMvc.perform(post("/v1/api/crops/user/deselect")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(request)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(1))
                .andExpect(jsonPath("$[0].name").value("Rice"));
    }

}
