package emsi.ma.studentservices;

import emsi.ma.studentservices.entities.Student;
import emsi.ma.studentservices.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication

public class StudentServicesApplication implements CommandLineRunner  {

    public static void main(String[] args) {
        SpringApplication.run(StudentServicesApplication.class, args);
    }

    @Autowired
    StudentRepository studentRepository;
    @Autowired
    RepositoryRestConfiguration repositoryRestConfiguration;

    @Override
    public void run(String... args) throws Exception {
        repositoryRestConfiguration.exposeIdsFor(Student.class);
        studentRepository.save(new Student(null,"s","s","s",new SimpleDateFormat("dd-MM-yyyy").parse("05-05-1212"),"test@"));
        studentRepository.save(new Student(null,"s","s","s",new Date(45),"test@"));
        studentRepository.save(new Student(null,"s","s","s",new Date(45),"test@"));
    }
}
