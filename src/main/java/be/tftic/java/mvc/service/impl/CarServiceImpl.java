package be.tftic.java.mvc.service.impl;

import be.tftic.java.mvc.domain.models.Car;
import be.tftic.java.mvc.service.CarService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CarServiceImpl implements CarService {

    private final Map<Long, Car> cars = new HashMap<>();
    private long nextID = 1;

    public CarServiceImpl() {
        Car car1 = new Car(nextID++, "vrim", "vroom", 120);
        Car car2 = new Car(nextID++, "dibadi", "longa", 120);
        Car car3 = new Car(nextID++, "honda", "toyata", 120);
        cars.put(car1.getId(), car1);
        cars.put(car2.getId(), car2);
        cars.put(car3.getId(), car3);
    }

    @Override
    public void create(Car car) {
        car.setId(nextID++);
        cars.put(car.getId(),car);
    }

    @Override
    public Car getOne(long id) {
        Car car = cars.get(id);
        if( car == null )
            throw new RuntimeException("no such Car");
        return car;
    }

    @Override
    public List<Car> getAll() {
        return new ArrayList<>( cars.values() );
    }


}
