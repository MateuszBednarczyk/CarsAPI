package com.example.carsapi;

public class CarDTO{

    Integer carId;
    String carBrand;
    String carModel;
    String color;

    public CarDTO(Integer carId, String carBrand, String carModel, String color) {
        this.carId = carId;
        this.carBrand = carBrand;
        this.carModel = carModel;
        this.color = color;
    }

    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
