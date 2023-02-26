package com.geekster.encompass.controller;



import com.geekster.encompass.dto.StudentDto;
import com.geekster.encompass.exception.RecordNotFound;
import com.geekster.encompass.model.Student;
import com.geekster.encompass.service.StudentService;
import jakarta.websocket.server.PathParam;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody StudentDto student){
        Student __student =  studentService.addStudent(student);
        return __student;
    }

    @GetMapping("/{studentId}")
    public Student getStudent(@PathVariable String studentId) throws RecordNotFound {
        Student __student  = studentService.findByStudent(studentId);
        return __student;
    }


    @GetMapping
    public List<Student> getAllStudent(){
        List<Student> allStudent = studentService.findAllStudent();
        return allStudent;
    }

}
