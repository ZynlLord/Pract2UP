package com.example.prac2up.dao;

import com.example.prac2up.models.DisplayModel;
import com.example.prac2up.repository.Repo_CRUD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DisplayDao implements Repo_CRUD<DisplayModel> {

    private static int DISPLAY_COUNT;

    private List<DisplayModel> displays;

    {
        displays = new ArrayList<>();

        displays.add(new DisplayModel(++DISPLAY_COUNT, "ROG XG27", "ASUS", 27500.00));
        displays.add(new DisplayModel(++DISPLAY_COUNT, "LH29", "Philips", 7500.00));
        displays.add(new DisplayModel(++DISPLAY_COUNT, "Long V8", "Lenovo", 11300.99));


    }

    @Override
    public List<DisplayModel> index() {
        return displays;
    }

    @Override
    public DisplayModel show(int id) {
        return displays.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(DisplayModel entity) {
        entity.setId(++DISPLAY_COUNT);
        displays.add(entity);
    }

    @Override
    public void update(int id, DisplayModel entity) {
        DisplayModel updateDisplay = show(id);
        updateDisplay.setName(entity.getName());
        updateDisplay.setCost(entity.getCost());
        updateDisplay.setFirm(entity.getFirm());
    }

    @Override
    public void delete(int id) {
        displays.removeIf(p -> p.getId() == id);
    }
}
