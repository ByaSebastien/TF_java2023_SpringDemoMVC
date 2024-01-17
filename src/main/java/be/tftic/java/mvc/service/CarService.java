package be.tftic.java.mvc.service;


import be.tftic.java.mvc.domain.models.Car;

import java.util.List;

public interface CarService {

    void create(Car car);
    Car getOne(long id);
    List<Car> getAll();

}
