package com.geekster.encompass.repo;

import com.geekster.encompass.model.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LaptopRepo extends JpaRepository<Laptop,String> {
}
