package com.usp.mba.repositories;

import com.usp.mba.entities.UserEntity;
import com.usp.mba.enums.Technology;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    Page<UserEntity> findByExperiencePrimaryTechnologyAndExperienceYearsOfExperienceGreaterThanEqual(
            Technology primaryTechnology,
            int minYearsOfExperience,
            Pageable pageable);
}
