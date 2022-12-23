package com.mishura.repository;

import com.mishura.model.Car;
import com.mishura.model.Color;

//    CRUD
//    Create (Save, Insert)
//    Read (getById, getAll)
//    Update
//    Delete

public interface GenericInterface <G extends Car>{

    void save(final G object);

    void insert(int index, G object);

    G[] getAll();

    G getByIG(final String id) ;

    void delete(final String id);

    void updateColor(final String id, final Color color);
}


