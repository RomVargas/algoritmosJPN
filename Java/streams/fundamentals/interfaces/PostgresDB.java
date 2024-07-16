package com.debuggeando_ideas.fundamentals.interfaces;

import java.util.List;

public class PostgresDB implements DatabaseService{
    @Override
    public String getById(Long id) {
        return "Getting data from id: " + id;
    }

    @Override
    public List<String> getAllRecords() {
        return List.of("Hola mundo desde Postgress");
    }
}
