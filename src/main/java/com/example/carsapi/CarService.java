package com.example.carsapi;

import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<CarDTO> carList = new ArrayList() {{
        add(new CarDTO(1, "Audi", "A6", "black"));
        add(new CarDTO(2, "BMW", "E36", "pink"));
        add(new CarDTO(3,"Ford","Mustang","Silver"));
    }};

    public List<CarDTO> findAllCars() {
        return carList;
    }
}

