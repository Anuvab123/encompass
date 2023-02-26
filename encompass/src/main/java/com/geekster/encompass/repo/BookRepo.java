package com.geekster.encompass.repo;

import com.geekster.encompass.model.Book;
import com.geekster.encompass.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepo extends JpaRepository<Book,String> {

    List<Book> findAllBookByStudent(Student student);
}
