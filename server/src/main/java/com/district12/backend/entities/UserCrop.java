package com.district12.backend.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.ZonedDateTime;

@Entity
@Table(name = "user_crops")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserCrop {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(nullable = false)
    @ToString.Exclude
    private Crop crop;

    @Column(nullable = false)
    private ZonedDateTime selectedAt;

    public UserCrop(User user, Crop crop, ZonedDateTime selectedAt) {
        this.user = user;
        this.crop = crop;
        this.selectedAt = selectedAt;
    }

}