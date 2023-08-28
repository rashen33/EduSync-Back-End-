package edu.icet.controller;

import edu.icet.dto.Student;
import edu.icet.dao.StudentEntity;
import edu.icet.service.StudentService;
import jakarta.persistence.GeneratedValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;
    @PostMapping
    public void setStudent(@RequestBody Student student){
        studentService.setStudent(student);
    }
    @GetMapping
    public Iterable<StudentEntity> getStudent(){
        return studentService.getStudent();
    }
}
