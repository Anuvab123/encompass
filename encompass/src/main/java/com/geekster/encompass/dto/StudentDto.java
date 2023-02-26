package com.geekster.encompass.dto;

import com.geekster.encompass.model.Address;
import lombok.Builder;
import lombok.Data;

@Data
public class StudentDto {

    private String name;
    private String age;
    private String phoneNumber;
    private String branch;
    private String department;
    private Address address;
}
