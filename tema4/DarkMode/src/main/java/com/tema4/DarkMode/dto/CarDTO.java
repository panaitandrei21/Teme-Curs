package com.tema4.DarkMode.dto;

import com.tema4.DarkMode.model.Car;
import lombok.Data;

@Data
public class CarDTO {
    private String model;
    private String name;

    public CarDTO(Car car) {
        this.name = car.getName();
        this.model = car.getModel();
    }
}
