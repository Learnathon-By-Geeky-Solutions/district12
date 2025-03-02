package com.district12.backend.enums;

public enum WeatherAlertType {
    DROUGHT,            // Extended dry period with little to no rain.
    FLOOD,              // Excessive rainfall leading to flooding.
    STORM,              // Severe weather event with high winds, lightning, etc.
    HEATWAVE,           // Prolonged period of extreme heat.
    FROST,              // Risk of frost, which can damage crops.
    HAIL,               // Severe hailstorms that can damage crops.
    SNOWFALL,           // Snow affecting crop growth or harvesting.
    HIGH_WINDS,         // Wind speeds dangerous for crops or structures.
    COLD_SNAP,          // Sudden drop in temperature, causing potential frost damage.
    HUMIDITY_FLUCTUATION, // Rapid changes in humidity levels that could stress crops.
    RAINFALL_WARNING,    // Abnormal rainfall patterns, either too much or too little.
    UV_RADIATION_HIGH,  // High UV index, potentially harming sensitive crops.
    TORNADO,            // Tornado warnings for high-risk areas.
    AIR_QUALITY_POOR,   // Poor air quality impacting crop health.
    LIGHTNING,          // Lightning risk due to storm activity.
    WIND_CHILL          // Cold winds affecting crops during the winter.
}