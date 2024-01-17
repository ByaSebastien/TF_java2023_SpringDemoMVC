package be.tftic.java.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {


    @GetMapping("/hello")
    public String sayHello(){
        return "hello";
    }

    @GetMapping("/add")
    public String addition(Model model, @RequestParam int membreA, @RequestParam int membreB){
        int rslt = membreA + membreB;
        model.addAttribute("rslt", rslt);
        return "addition";
    }

}
