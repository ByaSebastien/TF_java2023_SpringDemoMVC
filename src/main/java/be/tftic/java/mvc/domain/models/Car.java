package be.tftic.java.mvc.domain.models;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Car {

    private Long id;
    private String model;
    private String brand;
    private int power;

    public Car(Long id, String model, String brand, int power) {
        this.id = id;
        this.model = model;
        this.brand = brand;
        this.power = power;
    }

    public Car(String model, String brand, int power) {
        this.model = model;
        this.brand = brand;
        this.power = power;
    }
}
