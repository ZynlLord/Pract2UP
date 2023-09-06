package com.example.prac2up.controller;


import com.example.prac2up.dao.CarDao;
import com.example.prac2up.dao.DisplayDao;
import com.example.prac2up.models.CarModel;
import com.example.prac2up.models.DisplayModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/displays")
public class DisplayController {

    private final DisplayDao _displayDao;

    public DisplayController(DisplayDao displayDao) { _displayDao = displayDao; }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("displays", _displayDao.index());
        return "displays/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("display", _displayDao.show(id));
        return "displays/show";
    }

    @GetMapping("/new")
    public String newDisplay(@ModelAttribute("display") DisplayModel displayModel) {
        return "displays/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("display") DisplayModel displayModel) {
        _displayDao.save(displayModel);
        return "redirect:/displays";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("display", _displayDao.show(id));
        return "displays/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute DisplayModel displayModel, @PathVariable("id") int id) {
        _displayDao.update(id, displayModel);
        return "redirect:/displays";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _displayDao.delete(id);
        return "redirect:/displays";
    }
}
