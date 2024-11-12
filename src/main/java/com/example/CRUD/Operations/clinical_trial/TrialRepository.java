package com.example.CRUD.Operations.clinical_trial;

import jakarta.annotation.PostConstruct;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Component
@Repository
public class TrialRepository {
    
   // private static final Logger log = (Logger) LoggerFactory.getLogger(TrialRepository.class);

    private final JdbcClient jdbcClient;

    public TrialRepository(JdbcClient jdbcClient){
        this.jdbcClient = jdbcClient;
    }

    public List<Clinical_trial> findAll(){
        return jdbcClient.sql("select * from CLINICAL_TRIAL").query(Clinical_trial.class).list();
    }

    public Optional<Clinical_trial> findById(String id){
        return jdbcClient.sql("select * from CLINICAL_TRIAL WHERE id=:id").param("id", id).query(Clinical_trial.class).optional();
    }

    public void create(Clinical_trial trial){
        var updated = jdbcClient.sql("INSERT INTO CLINICAL_TRIAL(id, title, status, minimumAge, maximumAge, startDate, endDate, participantCount) values(?,?,?,?,?,?,?,?)")
                .params(List.of(trial.getId(),trial.getTitle(),trial.getStatus(), trial.getMinimumAge(), trial.getMaximunAge(), trial.getStartDate(), trial.getEndDate(), trial.getParticipantCount())).update();
        // in the method we are passing in the trial which is  a instance of the class and we are adding the params of the instance ino the sql using .get  method of the instance

        Assert.state(updated==1, "Failed to create trial"+trial.getTitle());
        // will return the above message if the update fails
    }

    public void update(Clinical_trial trial, String id){
        var updated = jdbcClient.sql("update CLINICAL_TRIAL SET title=?,status=?, minimumAge=?, maximumAge=?,startDate=?,endDate=?, participantCount=? WHERE id=?")
                .params(List.of(trial.getTitle(),trial.getStatus(),trial.getMinimumAge(),trial.getMaximunAge(),trial.getStartDate(),trial.getEndDate(),trial.getParticipantCount(),trial.getId())).update();
        // the order in the params should be the same as in the sql statement

        Assert.state(updated==1, "Failed to update the trial"+trial.getTitle());
    }

    public void delete(String id){
        var updated = jdbcClient.sql("delete from CLINICAL_TRIAL WHERE id=:id").param("id", id).update();
        Assert.state(updated==1, "Failed to delete the trial"+id );
    }

    public int count(){
        return jdbcClient.sql("select * from CLINICAL_TRIAL").query().listOfRows().size();
    }

    public void saveAll(List<Clinical_trial> trials){
        trials.stream().forEach(this::create);
    }

    public List<Clinical_trial> findByStatus(String status){
        return jdbcClient.sql("select * from CLINICAL_TRIAL where status =:status").param("status",status).query(Clinical_trial.class).list();
    }


}



