package com.sincere.candy.dao;

import com.sincere.candy.model.Pet;
import java.util.List;

public interface PetDao {
    List<Pet> getAllPetsFromDB();

    List<Pet> getAllOnwersFromDB();

    List<Pet> executeAndShowAll(String sql);
}
