package com.geekster.encompass.controller;

import com.geekster.encompass.dto.CourseDto;
import com.geekster.encompass.dto.CourseStudentDto;
import com.geekster.encompass.exception.RecordNotFound;
import com.geekster.encompass.model.Course;
import com.geekster.encompass.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @PostMapping
    public Course addCourse(@RequestBody CourseDto course){
        Course __course =  courseService.addCourse(course);
        return __course;
    }

    @PostMapping("/student")
    public Course addCourseToStudent(@RequestBody CourseStudentDto course) throws RecordNotFound {
        Course __course =  courseService.addCourseToStudent(course);
        return __course;
    }


    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable String courseId) throws RecordNotFound {
        Course __course  = courseService.findByCourse(courseId);
        return __course;
    }


    @GetMapping
    public List<Course> getAllCourse(){
        List<Course> allCourse = courseService.findAllCourse();
        return allCourse;
    }

    @PostMapping("course/student/add")
    public String addStudentToCourse(@RequestParam(value = "studentId",required = true)String studentId,
                                     @RequestParam(value="courseId",required = true)String courseId) throws RecordNotFound {
        this.courseService.addStudentToCourse(studentId,courseId);
        return "student added to course";
    }
}
