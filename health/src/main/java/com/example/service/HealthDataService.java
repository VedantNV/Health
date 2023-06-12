package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.exception.CustomException;
import com.example.pojo.HealthData;
import com.example.pojo.User;
import com.example.repo.HealthDataRepository;

@Service
public class HealthDataService {
	
	@Autowired
    private  HealthDataRepository health;
	
	@Autowired
	private User user;

    public HealthDataService(HealthDataRepository health) {
        this.health = health;
    }

    public HealthData saveHealthData(HealthData health1) {
    	HealthData h = health.findByUserId(health1.getId());
    	if(h!=null && user.getAge()>=65) {
    		return  health.save(h);
    		
    	}
		 throw new CustomException("inaccurate data entered");
    	
    }

     public List<HealthData> getHealthDataByUserId(Long userId){
    	 HealthData h = health.findByUserId(userId);
    	 
        	if(h==null && user.getAge()<65) {
        		
        		throw new CustomException("inaccurate data");
        	}
			 List<HealthData>h1= health.getHealthDataByUserId( userId);
			 return h1;
    	 
    	 
     }

}

