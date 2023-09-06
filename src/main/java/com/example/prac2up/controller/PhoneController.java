package com.example.prac2up.controller;


import com.example.prac2up.dao.DisplayDao;
import com.example.prac2up.dao.PhoneDao;
import com.example.prac2up.models.DisplayModel;
import com.example.prac2up.models.PhoneModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/phones")
public class PhoneController {


    private final PhoneDao _phoneDao;

    public PhoneController(PhoneDao phoneDao) {
        _phoneDao = phoneDao;
    }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("phones", _phoneDao.index());
        return "phones/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("phone", _phoneDao.show(id));
        return "phones/show";
    }

    @GetMapping("/new")
    public String newDisplay(@ModelAttribute("phone") PhoneModel phoneModel) {
        return "phones/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("phone") PhoneModel phoneModel) {
        _phoneDao.save(phoneModel);
        return "redirect:/phones";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("phone", _phoneDao.show(id));
        return "phones/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute PhoneModel phoneModel, @PathVariable("id") int id) {
        _phoneDao.update(id, phoneModel);
        return "redirect:/phones";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _phoneDao.delete(id);
        return "redirect:/phones";
    }
}
