package com.sincere.candy.dao;

import com.sincere.candy.model.Pet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class PetDaoImpl implements PetDao{

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public List<Pet> getAllPetsFromDB() {
        String sql = String.format("select * from pet");
        List list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public List<Pet> getAllOnwersFromDB() {
        String sql = "select owner from pet";
        List list = jdbcTemplate.queryForList(sql);
        return list;
    }

    @Override
    public List<Pet> executeAndShowAll(String sql) {

        //Grab first string
        String arr[] = sql.split(" ", 2);
        String firstWord = arr[0];

        //Check if the first string is select
        if (firstWord.equals("select")) {
            List list = jdbcTemplate.queryForList(sql);

            return list;
        }
        else{ // if firstWord is not select, then execute and the show all.
            jdbcTemplate.execute(sql);

            //Show All
            sql = String.format("select * from pet");
            List list = jdbcTemplate.queryForList(sql);

            return list;
        }

    }


}
