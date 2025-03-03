package com.district12.backend.repositories.alert;

import com.district12.backend.dtos.response.alert.DetailedAlertResponse;
import com.district12.backend.entities.alert.Alert;
import com.district12.backend.enums.AlertType;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>, JpaSpecificationExecutor<Alert> {

    @Query("SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt) " +
            "FROM Alert a WHERE a.alertType = :alertType")
    List<DetailedAlertResponse> findAllByAlertType(@Param("alertType") AlertType alertType);

    @Query("SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt) " +
            "FROM Alert a WHERE a.user.id = :userId")
    List<DetailedAlertResponse> findAllByUserId(@Param("userId") Long userId);

    @Query("SELECT new com.district12.backend.dtos.response.alert.DetailedAlertResponse(a.id, a.user.id, a.alertType, a.alertPriority, a.createdAt, a.readAt) " +
            "FROM Alert a WHERE a.user.id = :userId AND a.readAt = NULL")
    List<DetailedAlertResponse> findUnreadAlertsByUserId(@Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE alerts SET read_at = CURRENT_TIMESTAMP WHERE id = :alertId " +
            "AND user_id = :userId RETURNING *", nativeQuery = true)
    int markAlertAsRead(@Param("alertId") Long alertId, @Param("userId") Long userId);

    @Transactional
    @Modifying
    @Query(value = "UPDATE alerts SET read_at = CURRENT_TIMESTAMP WHERE id IN :alertIds " +
            "AND user_id = :userId", nativeQuery = true)
    int markAlertsAsRead(@Param("userId") Long userId, @Param("alertIds") List<Long> alertIds);

}