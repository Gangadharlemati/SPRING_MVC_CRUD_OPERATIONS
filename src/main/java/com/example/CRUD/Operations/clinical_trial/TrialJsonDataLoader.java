package com.example.CRUD.Operations.clinical_trial;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import java.util.List;
import org.springframework.stereotype.Component;

import java.io.InputStream;


@Component
public class TrialJsonDataLoader  implements CommandLineRunner {

    private  static final Logger log = (Logger) LoggerFactory.getLogger(TrialJsonDataLoader.class);

    private final TrialRepository trialRepository;
    private final ObjectMapper objectMapper;

    public TrialJsonDataLoader(TrialRepository trialRepository, ObjectMapper objectMapper){
        this.trialRepository =trialRepository;
        this.objectMapper =objectMapper;

    }






    @Override
    public void run(String... args) throws Exception {
        if(trialRepository.count()==0){
            try{
                InputStream inputStream = TypeReference.class.getResourceAsStream("/data/trials.json");
                Trials allTrials = objectMapper.readValue(inputStream, Trials.class);
                log.info("Reading from json and adding to the database");
                trialRepository.saveAll(allTrials.trials());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }else{
            log.info("Not loading data from json file cause database has some records already");
        }
    }




}
