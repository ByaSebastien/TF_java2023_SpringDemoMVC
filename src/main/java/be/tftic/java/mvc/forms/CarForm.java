package be.tftic.java.mvc.forms;

import be.tftic.java.mvc.domain.models.Car;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarForm{

    @NotNull(message = "Model cannot be null")
    @NotBlank(message = "Model cannot be empty")
    private String model;
    @NotNull(message = "Brand cannot be null")
    @NotBlank(message = "Brand cannot be empty")
    private String brand;
    @NotNull(message = "Power cannot be null")
    private Integer power;

    public Car toEntity(){
        return new Car(this.model,this.brand,this.power);
    }
}
