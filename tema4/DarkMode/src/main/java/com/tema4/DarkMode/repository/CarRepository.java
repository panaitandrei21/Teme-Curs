package com.tema4.DarkMode.repository;

import com.tema4.DarkMode.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer>{
}
