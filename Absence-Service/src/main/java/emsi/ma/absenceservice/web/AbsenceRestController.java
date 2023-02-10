package emsi.ma.absenceservice.web;

import emsi.ma.absenceservice.entities.Absence;
import emsi.ma.absenceservice.models.Cour;
import emsi.ma.absenceservice.models.Student;
import emsi.ma.absenceservice.repos.AbsenceRepo;
import emsi.ma.absenceservice.service.CoursRestClient;
import emsi.ma.absenceservice.service.StudentRestClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class AbsenceRestController {

   @Autowired
   AbsenceRepo absenceRepo;
    @Autowired

    CoursRestClient coursRestClient;
    @Autowired
    StudentRestClient studentRestClient;

    @GetMapping("/Absences")

    public List<Absence> getAll(){
        List<Absence> absences=absenceRepo.findAll();
//        absences.forEach(absence -> {
//            absence.setCours(coursRestClient.getCoursById(absence.getCourID()));
//            absence.setStudent(studentRestClient.getStudentById(absence.getStudentID()));
//
//        });
//        return  absences;
        return getAbsence(absences);

    }

    @GetMapping("/Absences/students/{id}")
    public List<Absence> getAbsencebyStudentsID(@PathVariable  Long id){
        List<Absence> absences=absenceRepo.findAbsencesByStudentID(id);
        return getAbsence(absences);
    }

    @Transactional
    @DeleteMapping("/absence/{ids}/{idc}")
    public void deleteAbsence(@PathVariable Long ids,@PathVariable Long idc){
        absenceRepo.deleteAbsenceByStudentIDAndCourID(ids, idc);
    }

    @PostMapping("/absence")
    public Absence addAbsence(@RequestBody Absence absence ){
        Student student= studentRestClient.getStudentById(absence.getStudentID());
        Cour cour= coursRestClient.getCoursById(absence.getCourID());

        if(cour==null || student==null){
            return absence;
        }else{

           Absence absence1 = absenceRepo.findAbsencesByStudentIDAndCourID(student.getId(), cour.getId());
           if(absence1 != null){
               absence1.setNbrAbsence(absence1.getNbrAbsence()+ absence.getNbrAbsence());
               return absenceRepo.save(absence1);

           }


            return absenceRepo.save(absence);
        }

    }






    public List<Absence> getAbsence( List<Absence> absences){
        absences.forEach(absence -> {
            absence.setCours(coursRestClient.getCoursById(absence.getCourID()));
            absence.setStudent(studentRestClient.getStudentById(absence.getStudentID()));

        });
        return absences;
    }



}
