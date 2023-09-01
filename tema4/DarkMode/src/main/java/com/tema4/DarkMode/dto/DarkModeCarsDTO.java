package com.tema4.DarkMode.dto;

import com.tema4.DarkMode.model.Car;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DarkModeCarsDTO {
    private String darkMode;
   private List<CarDTO> carList;
}
