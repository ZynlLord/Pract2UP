package com.example.prac2up.dao;


import com.example.prac2up.models.BookModel;
import com.example.prac2up.repository.Repo_CRUD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookDao implements Repo_CRUD<BookModel> {


    private static int BOOK_COUNT;

    private List<BookModel> books;

    {
        books = new ArrayList<>();

        books.add(new BookModel(++BOOK_COUNT, "Гарри Поттер", "Джоан Роулинг", "2001"));
        books.add(new BookModel(++BOOK_COUNT, "Краткие ответы на большие вопросы", "Стивен Хокинг", "2017"));
        books.add(new BookModel(++BOOK_COUNT, "Демоны", "Ден Браун", "2010"));

    }



    @Override
    public List<BookModel> index() {
        return books;
    }

    @Override
    public BookModel show(int id) {
        return books.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(BookModel entity) {
        entity.setId(++BOOK_COUNT);
        books.add(entity);
    }

    @Override
    public void update(int id, BookModel entity) {
        BookModel updateBook = show(id);
        updateBook.setAuthor(entity.getAuthor());
        updateBook.setName(entity.getName());
        updateBook.setOut_date(entity.getOut_date());
    }

    @Override
    public void delete(int id) {
        books.removeIf( p -> p.getId() == id);
    }
}
