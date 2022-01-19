package com.example.carsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ResponseEntity<List> getCars(){
        return new ResponseEntity(carService.findAllCars(), HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<List> getCarById(@PathVariable Integer id){
        Optional<CarDTO> found = carService.findAllCars().stream().filter(car -> car.getCarId() == id).findFirst();
        if(found.isPresent()){
            return new ResponseEntity(found.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/color/{color}")
    public ResponseEntity<List> getCarByColor(@PathVariable String color){
        Optional<CarDTO> found = carService.findAllCars().stream().filter(car -> car.getColor().equals(color)).findFirst();
        if(found.isPresent()){
            return new ResponseEntity(found.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(value = "/add")
    public ResponseEntity addCar(@RequestBody CarDTO car){
        boolean add = carService.findAllCars().add(car);
        if (add){

            return new ResponseEntity(HttpStatus.CREATED);

        }
        else{

            return new ResponseEntity(HttpStatus.BAD_REQUEST);

        }

    }

    @PutMapping(value = "/modify/{id}")
    public ResponseEntity modifyCar(@RequestBody CarDTO car, @PathVariable Integer id){

        Optional<CarDTO> found = carService.findAllCars().stream().filter(Car -> Car.getCarId() == id).findFirst();

        if(found.isPresent()){

            carService.findAllCars().remove(found.get());
            carService.findAllCars().add(car);
            return new ResponseEntity(HttpStatus.OK);

        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
    }

    @DeleteMapping(value = "/del/{id}")
    public ResponseEntity deleteCar(@PathVariable Integer id){

        Optional<CarDTO> found = carService.findAllCars().stream().filter(Car -> Car.getCarId() == id).findFirst();

        if(found.isPresent()){

            carService.findAllCars().remove(found.get());
            return new ResponseEntity(HttpStatus.OK);

        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }
    }

    @PatchMapping(value = "/patch/{id}")
    public ResponseEntity patchCar(@RequestBody CarDTO car, @PathVariable Integer id){

        Optional<CarDTO> found = carService.findAllCars().stream().filter(Car -> Car.getCarId() == id).findFirst();

        if(found.isPresent()){

            if(!found.get().getCarId().equals("")){

                found.get().setCarId(car.getCarId());

            }


            if(!found.get().getCarBrand().equals("")){

                found.get().setCarBrand(car.getCarBrand());

            }

            if(!found.get().getCarModel().equals("")){

                found.get().setCarModel(car.getCarModel());

            }

            if(!found.get().getColor().equals("")){

                found.get().setColor(car.getColor());

            }


            return new ResponseEntity(carService.findAllCars(), HttpStatus.OK);

        }else{

            return new ResponseEntity(HttpStatus.NOT_FOUND);

        }

    }

}