package com.example.prac2up.controller;

import com.example.prac2up.dao.*;
import com.example.prac2up.models.AnimalModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animals")
public class AnimalController {

    private final AnimalDao _animalDao;

    public AnimalController(AnimalDao animalDao) {
        _animalDao = animalDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("animals", _animalDao.index());
        return "animals/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("animal", _animalDao.show(id));
        return "animals/show";
    }

    @GetMapping("/new")
    public String newAnimal(@ModelAttribute("animal") AnimalModel animal) {
        return "animals/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("animal") AnimalModel animal) {
        _animalDao.save(animal);
        return "redirect:/animals";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("animal", _animalDao.show(id));
        return "animals/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute AnimalModel animalModel, @PathVariable("id") int id) {
        _animalDao.update(id, animalModel);
        return "redirect:/animals";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _animalDao.delete(id);
        return "redirect:/animals";
    }


}
