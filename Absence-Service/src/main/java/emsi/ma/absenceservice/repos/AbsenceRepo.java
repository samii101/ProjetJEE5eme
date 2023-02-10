package emsi.ma.absenceservice.repos;

import emsi.ma.absenceservice.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

public interface AbsenceRepo extends JpaRepository<Absence,Long> {

    List<Absence> findAbsencesByStudentID(Long Id);
    Absence findAbsencesByStudentIDAndCourID(Long Ids,Long Idc);
    void deleteAbsenceByStudentIDAndCourID(Long Ids,Long Idc);

}
