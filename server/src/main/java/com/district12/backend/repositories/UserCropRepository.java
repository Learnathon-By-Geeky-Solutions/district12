package com.district12.backend.repositories;

import com.district12.backend.dtos.response.CropResponse;
import com.district12.backend.entities.UserCrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserCropRepository extends JpaRepository<UserCrop, Long>, JpaSpecificationExecutor<UserCrop> {

    @Query("""
                SELECT new com.district12.backend.dtos.response.CropResponse(
                    uc.crop.id,
                    uc.crop.name,
                    uc.crop.description
                )
                FROM UserCrop uc
                WHERE uc.user.id = :userId
            """)
    List<CropResponse> findAllCropsByUserId(@Param("userId") Long userId);

}