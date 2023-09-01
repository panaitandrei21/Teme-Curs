package com.tema4.DarkMode.controller;

import com.tema4.DarkMode.dto.DarkModeCarsDTO;
import com.tema4.DarkMode.dto.DarkModeDTO;
import com.tema4.DarkMode.model.Car;
import com.tema4.DarkMode.service.CarService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.List;
@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public ResponseEntity<DarkModeCarsDTO> getCars(@CookieValue(value = "darkmode", defaultValue = "false") String darkModeCookie) {

        DarkModeCarsDTO darkModeCarsDTO = new DarkModeCarsDTO(darkModeCookie,carService.getAllCarsDTO());
        return ResponseEntity.ok()
                .header(darkModeCookie)
                .body(darkModeCarsDTO);
    }

    @PutMapping("/dark-mode")
    public ResponseEntity<String> setDarkMode(@RequestBody DarkModeDTO darkMode) {
        ResponseCookie cookie = ResponseCookie.from("darkmode", String.valueOf(darkMode.getDarkMode()))
                .path("/")
                .build();
       return ResponseEntity.ok()
               .header(HttpHeaders.SET_COOKIE, cookie.toString())
               .body("Dark mode atasat cu succes");
    }
}
