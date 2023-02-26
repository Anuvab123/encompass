package com.geekster.encompass.repo;

import com.geekster.encompass.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,String> {
}
