package emsi.ma.absenceservice;

import emsi.ma.absenceservice.entities.Absence;
import emsi.ma.absenceservice.models.Cour;
import emsi.ma.absenceservice.models.Student;
import emsi.ma.absenceservice.repos.AbsenceRepo;
import emsi.ma.absenceservice.service.CoursRestClient;
import emsi.ma.absenceservice.service.StudentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AbsenceServiceApplication implements CommandLineRunner {

	@Autowired
	AbsenceRepo absenceRepo;
	@Autowired

	CoursRestClient coursRestClient;
	@Autowired
	StudentRestClient studentRestClient;


	public static void main(String[] args) {
		SpringApplication.run(AbsenceServiceApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		Student student= studentRestClient.getStudentById(1L);
		Cour cour=coursRestClient.getCoursById(1L);
		Absence absence=new Absence();
		absence.setCourID(cour.getId());
		absence.setStudentID(student.getId());
		absenceRepo.save(absence);


	}
}
