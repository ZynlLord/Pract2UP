package com.example.prac2up.dao;

import com.example.prac2up.models.CarModel;
import com.example.prac2up.repository.Repo_CRUD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDao implements Repo_CRUD<CarModel> {
    private static int CAR_COUNT;

    private List<CarModel> cars;

    {
        cars = new ArrayList<>();

        cars.add(new CarModel(++CAR_COUNT, "KIA RIO", 430000.00, 87));
        cars.add(new CarModel(++CAR_COUNT, "Nissan 370Z", 3500000.00, 250));
        cars.add(new CarModel(++CAR_COUNT, "Nissan GTR", 5000000.00, 300));

    }

    @Override
    public List<CarModel> index() {
        return cars;
    }

    @Override
    public CarModel show(int id) {
        return cars.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(CarModel entity) {
        entity.setId(++CAR_COUNT);
        cars.add(entity);
    }

    @Override
    public void update(int id, CarModel entity) {
        CarModel updateCar = show(id);
        updateCar.setName(entity.getName());
        updateCar.setCost(entity.getCost());
        updateCar.setPower(entity.getPower());
    }

    @Override
    public void delete(int id) {
        cars.removeIf(p -> p.getId() == id);
    }
}
