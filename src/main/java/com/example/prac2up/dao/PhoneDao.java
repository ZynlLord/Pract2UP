package com.example.prac2up.dao;

import com.example.prac2up.models.PhoneModel;
import com.example.prac2up.repository.Repo_CRUD;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PhoneDao implements Repo_CRUD<PhoneModel> {
    private static int PHONE_COUNT;

    private List<PhoneModel> phones;

    {
        phones = new ArrayList<>();

        phones.add(new PhoneModel(++PHONE_COUNT, "Huawei P30 Pro", "Android", 25000.00));
        phones.add(new PhoneModel(++PHONE_COUNT, "Iphone 11", "IOS", 48000.00));
        phones.add(new PhoneModel(++PHONE_COUNT, "Iphone 6S", "IOS", 18000.00));
    }


    @Override
    public List<PhoneModel> index() {
        return phones;
    }

    @Override
    public PhoneModel show(int id) {
        return phones.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }

    @Override
    public void save(PhoneModel entity) {
        entity.setId(++PHONE_COUNT);
        phones.add(entity);
    }

    @Override
    public void update(int id, PhoneModel entity) {
        PhoneModel updatePhone = show(id);
        updatePhone.setName(entity.getName());
        updatePhone.setCost(entity.getCost());
        updatePhone.setSystem(entity.getSystem());
    }

    @Override
    public void delete(int id) {
        phones.removeIf(p -> p.getId() == id);
    }
}
