package com.example.prac2up.repository;

import java.util.List;

public interface Repo_CRUD<T> {
    List<T> index();

    T show(int id);

    void save(T entity);

    void update(int id, T entity);

    void delete(int id);
}
