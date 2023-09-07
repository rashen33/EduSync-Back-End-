package edu.icet.service.impl;

import edu.icet.dao.StudentEntity;
import edu.icet.dto.Student;
import edu.icet.repository.StudentRepository;
import edu.icet.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class StudentServiceImpl  implements StudentService {
    @Autowired
    StudentRepository repository;
//    private ModelMapper mapper;
//
//    @Bean
//    public void setup() {
//        this.mapper = new ModelMapper();
//    }

    @Override
    public void setNewStudent(Student newStudent) {
        StudentEntity studentEntityNS = new StudentEntity();
        studentEntityNS.setUserName(newStudent.getUserName());
        studentEntityNS.setStudentEmail(newStudent.getStudentEmail());
        studentEntityNS.setPassword(newStudent.getPassword());

        repository.save(studentEntityNS);
    }

    @Override
    public List<Student> getRegisteredStudent() {
        Iterable<StudentEntity> regStudentList = repository.findAll();

        Iterator<StudentEntity> iterator = regStudentList.iterator();

        List<Student> regStudentModelList = new ArrayList<>();

        while(iterator.hasNext()){
            StudentEntity regStudentDao = iterator.next();
            Student regStudentDto = Student.builder()
                    .userName(regStudentDao.getUserName())
                    .studentEmail(regStudentDao.getStudentEmail())
                    .password(regStudentDao.getPassword())
                    .build();

            regStudentModelList.add(regStudentDto);
        }
        return regStudentModelList;
    }

    @Override
    public List<Student> retrieveStudentByUserName(String userName) {
        List<Student> retrivedStudentList = new ArrayList<>();
        Iterator<StudentEntity> iterator = repository.findByUserName(userName).iterator();

        while(iterator.hasNext()){
            StudentEntity regStudentDao = iterator.next();
            Student regStudentDto = Student.builder()
                    .userName(regStudentDao.getUserName())
                    .password(regStudentDao.getPassword())
                    .build();
            retrivedStudentList.add(regStudentDto);
        }
        return retrivedStudentList;
    }

//    @Override
//    public void setStudent(Student student) {
//        StudentEntity studentEntity = new StudentEntity();
//        studentEntity.setName(student.getName());
//        studentEntity.setDob(student.getDob());
//        studentEntity.setSex(student.getSex());
//        studentEntity.setEmail(student.getEmail());
//        studentEntity.setTpNumber(student.getTpNumber());
//        studentEntity.setAddress(student.getAddress());
//        studentEntity.setNic(student.getNic());
//        studentEntity.setSchool(student.getSchool());
//        studentEntity.setDepartment(student.getDepartment());
//        studentEntity.setCourse(student.getCourse());
//        repository.save(studentEntity);
//    }
//    @Override
//    public List<Student> getStudent() {
//        Iterable<StudentEntity> studentList = repository.findAll();
//
//        Iterator<StudentEntity> iterator = studentList.iterator();
//
//        List<Student> studentModelList = new ArrayList<>();
//
//        while(iterator.hasNext()){
//            StudentEntity studentDao = iterator.next();
//            Student studentDto = Student.builder()
//                    .name(studentDao.getName())
//                    .dob(studentDao.getDob())
//                    .sex(studentDao.getSex())
//                    .email(studentDao.getEmail())
//                    .tpNumber(studentDao.getTpNumber())
//                    .address(studentDao.getAddress())
//                    .nic(studentDao.getNic())
//                    .school(studentDao.getSchool())
//                    .department(studentDao.getDepartment())
//                    .course(studentDao.getCourse())
//                    .build();
//
//            studentModelList.add(studentDto);
//        }
//
//        return studentModelList;
//    }
//
//    @Override
//    public List<Student> searchStudent(String name) {
//        Iterable<StudentEntity> studentList = repository.findByName(name);
//
//        Iterator<StudentEntity> iterator = studentList.iterator();
//
//        List<Student> searchedStudents = new ArrayList<>();
//
//        while(iterator.hasNext()){
//            StudentEntity studentDao = iterator.next();
//
//            //Model mapping
//            Student studentDto = Student.builder()
//                    .name(studentDao.getName())
//                    .dob(studentDao.getDob())
//                    .sex(studentDao.getSex())
//                    .email(studentDao.getEmail())
//                    .tpNumber(studentDao.getTpNumber())
//                    .address(studentDao.getAddress())
//                    .nic(studentDao.getNic())
//                    .school(studentDao.getSchool())
//                    .department(studentDao.getDepartment())
//                    .course(studentDao.getCourse())
//                    .build();
//
//            searchedStudents.add(studentDto);
//        }
//        return searchedStudents;
//    }
//
//    @Override
//    public void deleteStudent(Long id) {
//        repository.deleteById(id);
//    }

}