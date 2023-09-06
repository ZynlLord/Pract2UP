package com.example.prac2up.controller;


import com.example.prac2up.dao.BookDao;
import com.example.prac2up.models.AnimalModel;
import com.example.prac2up.models.BookModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookDao _bookDao;

    public BookController(BookDao bookDao) { _bookDao = bookDao; }

    @GetMapping()
    public String index(Model model) {
        model.addAttribute("books", _bookDao.index());
        return "books/index";
    }

    @GetMapping("/{id}")
    public String show(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", _bookDao.show(id));
        return "books/show";
    }

    @GetMapping("/new")
    public String newBook(@ModelAttribute("book") BookModel bookModel) {
        return "books/new";
    }

    @PostMapping()
    public String create(@ModelAttribute("book") BookModel bookModel) {
        _bookDao.save(bookModel);
        return "redirect:/books";
    }

    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") int id) {
        model.addAttribute("book", _bookDao.show(id));
        return "books/edit";
    }

    @PatchMapping("/{id}")
    public String create(@ModelAttribute BookModel bookModel, @PathVariable("id") int id) {
        _bookDao.update(id, bookModel);
        return "redirect:/books";
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") int id) {
        _bookDao.delete(id);
        return "redirect:/books";
    }

}
