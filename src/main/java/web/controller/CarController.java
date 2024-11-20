package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.Car;
import web.servise.CarService;
import web.servise.CarServiceIml;

import java.util.List;

@Controller
public class CarController {
    @Autowired
    CarService carService;

    @GetMapping("/cars")
    public String gettingCarsWithParam(@RequestParam(value = "count", defaultValue = "0") Integer count, ModelMap model) {
        List<Car> cars;
        cars = carService.getCars(count);
        model.addAttribute("cars", cars);
        return "cars";
    }
}
