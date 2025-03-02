package com.district12.backend.enums;

public enum CropAlertType {
    DROUGHT_STRESS,          // Crop hasn't been watered for an extended period.
    OVER_WATERING,            // Excessive watering detected.
    NUTRIENT_DEFICIENCY,     // Signs of nutrient deficiency (e.g., yellowing leaves).
    PEST_INFESTATION,        // Pests detected on crops.
    FUNGAL_DISEASE,          // Fungal infection (e.g., powdery mildew, rust).
    BACTERIAL_DISEASE,       // Bacterial infection (e.g., bacterial blight).
    VIRAL_DISEASE,           // Viral disease affecting crops.
    WEED_COMPETITION,        // High presence of weeds competing with crops.
    GROWTH_STAGNATION,       // Crop growth has stalled unexpectedly.
    FRUIT_DROP,              // Premature fruit drop detected.
    HARVEST_READY,           // Crop is ready for harvesting.
    TEMPERATURE_STRESS,      // Extreme temperatures affecting crops.
    SOIL_MOISTURE_LOW,       // Soil moisture below optimal levels.
    SOIL_MOISTURE_HIGH,      // Soil moisture above optimal levels.
    PH_IMBALANCE,            // Soil pH not within ideal range.
    WIND_DAMAGE,             // Crops damaged by strong winds.
    FROST_WARNING,           // Frost conditions expected or detected.
    HEAT_STRESS              // High temperatures causing stress.
}