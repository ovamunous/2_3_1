package web.servise;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceIml implements CarService {
    private ArrayList<Car> cars = new ArrayList<>() {
        {
            add(new Car("China", "Xiomi", 2024));
            add(new Car("Russia", "Lada", 1999));
            add(new Car("USA", "Juk", 2015));
            add(new Car("German", "BMW", 2020));
            add(new Car("France", "Bagget", 1890));
        }
    };

    @Override
    public List<Car> getCars(int count) {
        if (count < 5 && count > 0) {
            return new ArrayList<>(cars).subList(0, count);
        }
        return cars;
    }

}
