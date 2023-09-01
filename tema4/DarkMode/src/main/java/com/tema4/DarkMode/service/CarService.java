package com.tema4.DarkMode.service;

import com.tema4.DarkMode.dto.CarDTO;
import com.tema4.DarkMode.model.Car;
import com.tema4.DarkMode.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    public List<CarDTO> getAllCarsDTO() {
        List<Car> carList =  carRepository.findAll();
        List<CarDTO> carListDTO = new ArrayList<>();
        for (Car car : carList) {
            carListDTO.add(new CarDTO(car));
        }



        return carListDTO;
    }

}
