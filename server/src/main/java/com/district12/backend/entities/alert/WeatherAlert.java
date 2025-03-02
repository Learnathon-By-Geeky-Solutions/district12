package com.district12.backend.entities.alert;

import com.district12.backend.enums.WeatherAlertType;
import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "weather_alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WeatherAlert {

    @Id
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @MapsId
    @JoinColumn(name = "alert_id", referencedColumnName = "id", nullable = false)
    private Alert alert;

    @Enumerated(EnumType.STRING)
    @Column(name = "weather_type", nullable = false)
    private WeatherAlertType weatherAlertType;

    @Column(name = "forecasted_at", nullable = false)
    private ZonedDateTime forecastedAt;

}