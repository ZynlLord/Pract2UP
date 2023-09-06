package com.example.prac2up.models;

public class CarModel {
    private int _id;

    private String _name;

    private double _cost;

    private int _power;


    public CarModel() {
    }

    public CarModel(int id, String name, double cost, int power) {
        _id = id;
        _name = name;
        _cost = cost;
        _power = power;
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

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }

    public int getPower() {
        return _power;
    }

    public void setPower(int power) {
        this._power = power;
    }
}
