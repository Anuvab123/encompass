package com.geekster.encompass.service;


import com.geekster.encompass.dto.StudentDto;
import com.geekster.encompass.exception.RecordNotFound;
import com.geekster.encompass.model.Student;
import com.geekster.encompass.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;

    public Student addStudent(StudentDto studentDto) {
        Student  student = new Student();

        String ID = UUID.randomUUID().toString();


        student.setID(ID);
        student.setAge(studentDto.getAge());
        student.setName(studentDto.getName());
        student.setBranch(studentDto.getBranch());
        student.setDepartment(studentDto.getDepartment());
        student.setPhoneNumber(studentDto.getPhoneNumber());
        student.setAddress(studentDto.getAddress());
        Student __student = studentRepo.save(student);
        return __student;
    }

    public Student findByStudent(String studentId) throws RecordNotFound {
        Optional<Student> studentOptional = studentRepo.findById(studentId);

        if(studentOptional.isPresent())
            return studentOptional.get();
        throw new RecordNotFound("student Not Found By Id "+studentId);

    }

    public List<Student> findAllStudent() {
        List<Student> studentRepoAll = studentRepo.findAll();
        return studentRepoAll;
    }
}
