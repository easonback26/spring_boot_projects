package com.ban.blogger.service;

import com.ban.blogger.model.Type;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Map;

public interface TypeService {
    //Page listType(Pageable pageable);

    Type getType(Long id);

    Type updateType(String name,String id);

    Type addType(String name);

    List<Map<String, Object>> getAllType();

    void deleteType(Long id);
}