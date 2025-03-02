package com.district12.backend.repositories.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.CropAlert;
import com.district12.backend.enums.CropAlertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CropAlertRepository extends JpaRepository<CropAlert, Long> {

    @Query(value = """
        SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(
            a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt
        )
        FROM CropAlert ca
        JOIN Alert a ON ca.alert.id = a.id
        WHERE ca.cropAlertType = :cropAlertType
    """)
    List<DetailedAlertResponse> findByCropAlertType(@Param("cropAlertType") CropAlertType cropAlertType);

}
