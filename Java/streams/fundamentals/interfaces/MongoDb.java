package com.debuggeando_ideas.fundamentals.interfaces;

import java.util.List;

public class MongoDb implements DatabaseService{
    @Override
    public String getById(Long id) {
        return "Gettiing data from Mongo with id: " + id;
    }

    @Override
    public List<String> getAllRecords() {
        return List.of("Hola Mundo");
    }
}
