package com.example.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.pojo.HealthData;

@Repository
@EnableJpaRepositories

public interface HealthDataRepository extends JpaRepository<HealthData, Long> {
   public HealthData findByUserId(Long userId);
   
   
   public List<HealthData> getHealthDataByUserId(Long userId);

}

