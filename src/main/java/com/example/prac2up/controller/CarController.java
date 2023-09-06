package com.example.prac2up.controller;


import com.example.prac2up.dao.BookDao;
import com.example.prac2up.dao.CarDao;
import com.example.prac2up.models.BookModel;
import com.example.prac2up.models.CarModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarDao _carDao;

    public CarController(CarDao carDao) { _carDao = carDao; }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("cars", _carDao.index());
        return "cars/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("car", _carDao.show(id));
        return "cars/show";
    }

    @GetMapping("/new")
    public String newCar(@ModelAttribute("car") CarModel carModel) {
        return "cars/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("car") CarModel carModel) {
        _carDao.save(carModel);
        return "redirect:/cars";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("car", _carDao.show(id));
        return "cars/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute CarModel carModel, @PathVariable("id") int id) {
        _carDao.update(id, carModel);
        return "redirect:/cars";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _carDao.delete(id);
        return "redirect:/cars";
    }
}
