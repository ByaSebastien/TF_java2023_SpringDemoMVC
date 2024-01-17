package be.tftic.java.mvc.controller;

import be.tftic.java.mvc.domain.models.Car;
import be.tftic.java.mvc.forms.CarForm;
import be.tftic.java.mvc.service.CarService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/{id:^[0-9]+$}")
    public String getOne(Model model, @PathVariable long id){
        Car car = carService.getOne(id);
        model.addAttribute("car", car);
        return "car/details";
    }

    @GetMapping({"","/all"})
    public String getAll(Model model){
        model.addAttribute("cars", carService.getAll());
        return "car/list";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("carForm",new CarForm());
        return "car/create";
    }

    @PostMapping("/create")
    public String postCreate(
            @ModelAttribute @Valid CarForm carForm,
            BindingResult bindingResult,
            Model model
    ){
        if(bindingResult.hasErrors()){
            model.addAttribute(carForm);
            System.out.println("Error");
            return "car/create";
        }
        carService.create(carForm.toEntity());
        return "redirect:/car";
    }
}
