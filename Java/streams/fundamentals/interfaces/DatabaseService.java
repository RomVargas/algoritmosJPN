package com.debuggeando_ideas.fundamentals.interfaces;

import java.util.List;

public interface DatabaseService  {
    String getById(Long id);
    List<String> getAllRecords();
}
