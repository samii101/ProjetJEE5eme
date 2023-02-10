package emsi.ma.absenceservice.entities;

import emsi.ma.absenceservice.models.Cour;
import emsi.ma.absenceservice.models.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor @AllArgsConstructor
public class Absence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Transient
    private Student student;

    private Long studentID;

    @Transient
    private Cour cours;

    private Long courID;

    private int nbrAbsence;






}
