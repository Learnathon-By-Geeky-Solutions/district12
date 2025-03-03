package com.district12.backend.entities.alert;

import com.district12.backend.entities.User;
import com.district12.backend.enums.AlertPriority;
import com.district12.backend.enums.AlertType;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.ZonedDateTime;

@Entity
@Table(name = "alerts")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Alert {

    @Id
    @GeneratedValue
    @Column(updatable = false, nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(name = "alert_type", nullable = false)
    private AlertType alertType;

    @Enumerated(EnumType.STRING)
    @Column(name = "priority", nullable = false)
    private AlertPriority alertPriority;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false)
    private ZonedDateTime createdAt;

    @Column(name = "read_at", nullable = false, updatable = false)
    private ZonedDateTime readAt;

    public Alert(User user, AlertType alertType, AlertPriority alertPriority) {
        this.user = user;
        this.alertType = alertType;
        this.alertPriority = alertPriority;
        this.createdAt = ZonedDateTime.now();
        this.readAt = null;
    }
}