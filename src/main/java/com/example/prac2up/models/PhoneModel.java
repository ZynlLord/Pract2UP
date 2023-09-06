package com.example.prac2up.models;

public class PhoneModel {

    private int _id;

    private String _name;

    private String _system;

    private double _cost;


    public PhoneModel(){}
    public PhoneModel(int id, String name, String system, double cost) {
        _id = id;
        _name = name;
        _system = system;
        _cost = cost;
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

    public String getSystem() {
        return _system;
    }

    public void setSystem(String system) {
        this._system = system;
    }

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }
}
