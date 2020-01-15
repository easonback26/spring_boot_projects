package com.ban.blogger.dao;

import com.ban.blogger.model.Type;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;


@Transactional
@Repository
public interface TypeDao {
    Type getTypeById(Long id);

    Type updateTypeByNameAndId(String name, String id);

    Type insertTypeByName(String name);

    List<Map<String, Object>> getAllType();


    void deleteTypeById(Long id);
}
