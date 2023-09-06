package com.example.prac2up.models;


public class BookModel {
    private int _id;

    private String _name;

    private String _author;

    private String _out_date;


    public BookModel() {
    }

    public BookModel(int id, String name, String author, String out_date) {
        _id = id;
        _name = name;
        _author = author;
        _out_date = out_date;
    }

    public int getId() {
        return _id;
    }

    public void setId(int id) {
        this._id = id;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        this._name = name;
    }

    public String getAuthor() {
        return _author;
    }

    public void setAuthor(String author) {
        this._author = author;
    }

    public String getOut_date() {
        return _out_date;
    }

    public void setOut_date(String out_date) {
        this._out_date = out_date;
    }
}
