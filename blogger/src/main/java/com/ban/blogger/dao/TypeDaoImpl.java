package com.ban.blogger.dao;

import com.ban.blogger.model.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.ban.blogger.mapper.TypeMapper;


@Repository
public class TypeDaoImpl implements TypeDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Type getTypeById(Long id) {
        String sql = String.format("select * from t_type where id = '%s'", id);
        RowMapper mapper = new TypeMapper();
        try {
            Type type = (Type) jdbcTemplate.queryForObject(sql, mapper);
            return type;
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    @Override
    public Type updateTypeByNameAndId(String name, String id) {
        String sql = String.format("update t_type set name = '%s' where id = '%s'", name, id);
        String sqlAfterUpdate = String.format("select * from t_type where id = '%s'", id);
        RowMapper mapper = new TypeMapper();
        try {
            jdbcTemplate.update(sql);
            Type type = (Type) jdbcTemplate.queryForObject(sqlAfterUpdate, mapper);
            System.out.println("update type in dao impl is : " + type);
            return type;
        } catch (Exception e) {
            System.err.println(sql + " is not updated");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public Type insertTypeByName(String name) {
        String sql = String.format("insert into t_type set name = '%s'", name);
        String sqlAfterUpdate = String.format("select * from t_type where name = '%s'", name);
        RowMapper mapper = new TypeMapper();
        try {
            jdbcTemplate.update(sql);
            Type type = (Type) jdbcTemplate.queryForObject(sqlAfterUpdate, mapper);
            System.out.println("insert type in dao impl is : " + type);
            return type;
        } catch (Exception e) {
            System.out.println(sql + " is not updated");
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteTypeById(Long id) {
        String sql = String.format("delete from t_type where id = '%s'", id);
        jdbcTemplate.update(sql);
    }
}



