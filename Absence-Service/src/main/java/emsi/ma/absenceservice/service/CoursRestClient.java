package emsi.ma.absenceservice.service;

import emsi.ma.absenceservice.models.Cour;
import emsi.ma.absenceservice.models.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COURS-SERVICE")
public interface CoursRestClient {


    @GetMapping(path="/cours/{id}")
    Cour getCoursById(@PathVariable Long id);

    @GetMapping(path="/cours")
    List<Cour> getCours();


}
