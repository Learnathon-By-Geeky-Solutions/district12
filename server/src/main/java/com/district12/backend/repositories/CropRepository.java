package com.district12.backend.repositories;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.Crop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CropRepository extends JpaRepository<Crop, Long>, JpaSpecificationExecutor<Crop> {

    @Query("SELECT new com.district12.backend.dtos.response.CropResponse(c.id, c.name, c.description) " +
            "FROM Crop c")
    List<CropResponse> findAllCrops();

    @Query("SELECT new com.district12.backend.dtos.response.CropResponse(c.id, c.name, c.description) " +
            "FROM Crop c " +
            "WHERE c.id = :cropId")
    CropResponse getCropDetailsById(@Param("cropId") Long cropId);

}