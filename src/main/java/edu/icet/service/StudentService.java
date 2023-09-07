package edu.icet.service;

import edu.icet.dto.Student;

import java.util.List;

public interface StudentService {
    void setNewStudent(Student newStudent);
    List<Student> getRegisteredStudent();
    List<Student> retrieveStudentByUserName(String userName);

//    public void setStudent(Student student);
//    public List<Student> getStudent();
//    public List<Student> searchStudent(String name);
//
//    void deleteStudent(Long id);
}
