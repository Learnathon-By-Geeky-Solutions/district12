package com.district12.backend.repositories;

import com.district12.backend.entities.UserCrop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCropRepository extends JpaRepository<UserCrop, Long>, JpaSpecificationExecutor<UserCrop> {

}