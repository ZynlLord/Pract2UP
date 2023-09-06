package com.example.prac2up.dao;


import com.example.prac2up.models.AnimalModel;
import com.example.prac2up.repository.Repo_CRUD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalDao implements Repo_CRUD<AnimalModel> {


    private static int ANIMAL_COUNT;

    private List<AnimalModel> animals;

    {
        animals = new ArrayList<>();

        animals.add(new AnimalModel(++ANIMAL_COUNT, "Шарик", 3, "Собака"));
        animals.add(new AnimalModel(++ANIMAL_COUNT, "Пушок", 4, "Кот"));
        animals.add(new AnimalModel(++ANIMAL_COUNT, "Свистун", 5, "Попугай"));

    }


    @Override
    public List<AnimalModel> index() {
        return animals;
    }

    @Override
    public AnimalModel show(int id) {
        return animals.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(AnimalModel entity) {
        entity.setId(++ANIMAL_COUNT);
        animals.add(entity);
    }

    @Override
    public void update(int id, AnimalModel entity) {
        AnimalModel updateAnimal = show(id);
        updateAnimal.setName(entity.getName());
        updateAnimal.setAge(entity.getAge());
        updateAnimal.setType(entity.getType());
    }

    @Override
    public void delete(int id) {
        animals.removeIf(p -> p.getId() == id);
    }
}
