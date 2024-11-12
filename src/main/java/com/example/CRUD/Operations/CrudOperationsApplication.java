package com.example.CRUD.Operations;

import com.example.CRUD.Operations.clinical_trial.Clinical_trial;
import com.example.CRUD.Operations.clinical_trial.TrialRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CrudOperationsApplication {
	private static final Logger log = LoggerFactory.getLogger(CrudOperationsApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CrudOperationsApplication.class, args);
		log.info("Application Started Successfully!");


	}

//	@Bean
//	CommandLineRunner runner(TrialRepository trialRepository){
//		// we can pass class inside the command line runner and use the methods of that class to execute
//        return args -> {
//			Clinical_trial trial = new Clinical_trial("0001","clinical trial title one", "Active","18", "111", "01/01/2024", "01/10/2024", "75");
//			trialRepository.create(trial);
//
//            log.info("trial: {}", trial);
//		};
//    }

}
