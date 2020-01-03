package com.sincere.candy.service;

import com.sincere.candy.dao.PetDao;
import com.sincere.candy.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    @Autowired
    private PetDao petDao;

    @Override
    public List<Pet> getAllPets() {
        return petDao.getAllPetsFromDB();
    }

    @Override
    public List<Pet> getAllOwners() {
        return petDao.getAllOnwersFromDB();
    }

    @Override
    public List<Pet> executeAndShowAll(String sql) {
        return petDao.executeAndShowAll(sql);
    }


}
