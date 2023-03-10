package com.geekster.encompass.service;


import com.geekster.encompass.dto.LaptopDto;
import com.geekster.encompass.exception.RecordNotFound;
import com.geekster.encompass.model.Laptop;
import com.geekster.encompass.model.Student;
import com.geekster.encompass.repo.LaptopRepo;
import com.geekster.encompass.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class LaptopService {

    @Autowired
    private LaptopRepo laptopRepo;

    @Autowired
    private StudentService studentService;

    @Autowired
    private StudentRepo studentRepo;

    public Laptop addLaptop(LaptopDto laptopDto) throws RecordNotFound {
        Student byStudent = studentService.findByStudent(laptopDto.getStudentID());
        Laptop laptop = new Laptop();
        String ID = UUID.randomUUID().toString();

        laptop.setID(ID);
        laptop.setName(laptopDto.getName());
        laptop.setBrand(laptopDto.getBrand());
//        Laptop.se(byStudent);
        laptop.setPrice(laptopDto.getPrice());
        laptop.setStudent(byStudent);
//        byStudent.setLaptop(Laptop);

        Laptop __Laptop = laptopRepo.save(laptop);
//        Student save = studentRepo.save(byStudent);
//        return save;
        return __Laptop;
    }

    public Laptop findByLaptop(String laptopId) throws RecordNotFound {
        Optional<Laptop> LaptopOptional = laptopRepo.findById(laptopId);

        if(LaptopOptional.isPresent())
            return LaptopOptional.get();
        throw new RecordNotFound("Laptop Not Found By Id "+laptopId);

    }

    public List<Laptop> findAllLaptop() {
        List<Laptop> LaptopRepoAll = laptopRepo.findAll();
        return LaptopRepoAll;
    }
}
