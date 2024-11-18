package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.model.Car;
import web.servise.CarServiceIml;

import java.util.List;

@Controller
public class CarController {

    @GetMapping("/cars")
    public String gettingCarsWithParam(@RequestParam(value = "count", required = false) Integer count, ModelMap model) {
        CarServiceIml carService = new CarServiceIml();
        List<Car> cars;
        if (count != null) {
            cars = carService.getCars(count);
        } else {
            cars = carService.getCars();
        }
        model.addAttribute("cars", cars);
        return "cars";
    }
}
