package com.geekster.encompass.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Book {

    @Id

    private String ID;

    private String title;
    private String author;
    private String description;
    private String price;


    @ManyToOne
    private Student student;

}
