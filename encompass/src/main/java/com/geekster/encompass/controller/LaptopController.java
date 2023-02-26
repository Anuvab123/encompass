package com.geekster.encompass.controller;


import com.geekster.encompass.dto.LaptopDto;
import com.geekster.encompass.exception.RecordNotFound;
import com.geekster.encompass.model.Laptop;
import com.geekster.encompass.service.LaptopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("laptop")
public class LaptopController {

    @Autowired
    private LaptopService laptopService;

    @PostMapping
    public Laptop addLaptop(@RequestBody LaptopDto laptop) throws RecordNotFound {
        Laptop __laptop =  laptopService.addLaptop(laptop);
        return __laptop;
    }

    @GetMapping("/{laptopId}")
    public Laptop getLaptop(@PathVariable String laptopId) throws RecordNotFound {
        Laptop __laptop  = laptopService.findByLaptop(laptopId);
        return __laptop;
    }


    @GetMapping
    public List<Laptop> getAllLaptop(){
        List<Laptop> allLaptop = laptopService.findAllLaptop();
        return allLaptop;
    }
}
