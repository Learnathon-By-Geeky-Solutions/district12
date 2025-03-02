package com.district12.backend.repositories.alert;

import com.district12.backend.entities.alert.Alert;
import com.district12.backend.enums.AlertType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlertRepository extends JpaRepository<Alert, Long>, JpaSpecificationExecutor<Alert> {

    @Query("SELECT a FROM Alert a WHERE a.alertType = :alertType")
    List<Alert> findAllByAlertType(@Param("alertType") AlertType alertType);

}