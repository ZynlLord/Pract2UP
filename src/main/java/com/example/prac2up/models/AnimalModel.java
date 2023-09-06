package com.example.prac2up.models;

public class AnimalModel {
    private int _id;

    private String _name;

    private int _age;

    public AnimalModel(){}

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

    public int getAge() {
        return _age;
    }

    public void setAge(int age) {
        this._age = age;
    }

    public String getType() {
        return _type;
    }

    public void setType(String type) {
        this._type = type;
    }

    public AnimalModel(int id, String name, int age, String type) {
        _id = id;
        _name = name;
        _age = age;
        _type = type;
    }

    private String _type;


}
