package emsi.ma.studentservices.service;

import emsi.ma.studentservices.entities.Student;

import java.util.List;

public interface IStudentservice {

    List<Student> getStudents();
    Student getStudent(Long id);

}
