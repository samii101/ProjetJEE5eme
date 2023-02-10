package com.example.subjectservice.repos;

import com.example.subjectservice.entities.Cour;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CoursRepo extends JpaRepository<Cour,Long> {

}
