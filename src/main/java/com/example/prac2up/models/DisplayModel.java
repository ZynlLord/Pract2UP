package com.example.prac2up.models;

public class DisplayModel {
    private int _id;

    private String _name;

    private String _firm;

    private double _cost;

    public DisplayModel(){}

    public DisplayModel(int id, String name, String firm, double cost) {
        _id = id;
        _name = name;
        _firm = firm;
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

    public String getFirm() {
        return _firm;
    }

    public void setFirm(String firm) {
        this._firm = firm;
    }

    public double getCost() {
        return _cost;
    }

    public void setCost(double cost) {
        this._cost = cost;
    }
}
