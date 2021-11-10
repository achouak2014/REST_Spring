package com.example.api;

import com.example.api.models.Candidat;
import com.example.api.repositories.CandidatRepository;
import org.apache.juli.logging.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Configuration
public class LoadData {
    private static final Logger log = LoggerFactory.getLogger(LoadData.class);
    @Bean
    CommandLineRunner initDataBase(CandidatRepository repository) throws ParseException {
        log.info("Launch preloading");
        //test  si il y a des données dans la base
        if(repository.count()==0 ){
            SimpleDateFormat  formatter = new SimpleDateFormat("dd/MM/yyyy");
            Date dateNaissance = formatter.parse("30/10/2020");
            Candidat candidat = new Candidat("halloumi","achouak",dateNaissance,
                    "rue francois piessel","caluire", "69300");

return  args->{
    log.info("Preloading" + repository.save(candidat));
};

        }
        else{
            return args->{
                log.info("Already initialized");
            };
        }
    }
}
