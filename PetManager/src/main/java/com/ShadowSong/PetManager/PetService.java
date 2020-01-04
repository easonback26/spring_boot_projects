package com.ShadowSong.PetManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetService {
    @Autowired
    private PetRepository repo;

    public List<Pet> listAll(){
        return repo.findAll();
    }

    public void save(Pet pet){
        repo.save(pet);
    }

    public Pet get(Long id){
        return repo.findById(id).get();
    }

    public void delete(Long id){
        repo.deleteById(id);
    }
}
