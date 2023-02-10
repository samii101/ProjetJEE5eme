package com.example.subjectservice;

import com.example.subjectservice.entities.Cour;
import com.example.subjectservice.repos.CoursRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class SubjectServiceApplication implements CommandLineRunner {

    @Autowired
    CoursRepo coursRepo;
    public static void main(String[] args) {
        SpringApplication.run(SubjectServiceApplication.class, args);
    }

    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Cour.class);

        coursRepo.save(new Cour(null,"math","5IIR",70));
        coursRepo.save(new Cour(null,"test","5IIR",35));
        coursRepo.save(new Cour(null,"jiji","5IIR",50));
    }
}
