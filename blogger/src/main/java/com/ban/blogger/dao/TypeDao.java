package com.ban.blogger.dao;

import com.ban.blogger.model.Type;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Transactional
@Repository
public interface TypeDao {
    Type getTypeById(Long id);

    Type updateTypeByNameAndId(String name, String id);

    Type insertTypeByName(String name);

    void deleteTypeById(Long id);
}
