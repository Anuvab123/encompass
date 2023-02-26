package com.geekster.encompass.repo;

import com.geekster.encompass.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepo extends JpaRepository<Course,String> {
}
