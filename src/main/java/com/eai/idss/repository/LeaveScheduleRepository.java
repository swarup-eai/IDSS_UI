package com.eai.idss.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.eai.idss.model.LeaveSchedule;

@Repository
public interface LeaveScheduleRepository extends MongoRepository<LeaveSchedule, String> {

	LeaveSchedule findByUserNameAndMonthYear(String name,String monthYear);
    
    long deleteByUserNameAndMonthYear(String name,String monthYear);

}
