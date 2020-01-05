package com.ban.blogger.controller;

import com.ban.blogger.model.Type;
import com.ban.blogger.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/getById")
    public String getType(){
        Type type = typeService.getType((long)1);
        System.out.println(type);
        return "type service gets called. ";
    }

    //重要 动态返回 Id
    @GetMapping("/getById/{id}")
    public String getType(@PathVariable long id){
        Type type = typeService.getType(id);
        System.out.println(type);
        return "type service gets called. ";
    }

    @GetMapping("/addType/{value}")
    public String addType(@PathVariable String value){
        typeService.addType(value);
        return value;
    }

    @GetMapping("/updateType/{value}/{id}")
    public Type updateType(@PathVariable String value, @PathVariable String id){
        Type type = typeService.updateType(value, id);
        System.out.println(value);
        System.out.println(id);

        return type;
    }

    @GetMapping("/deleteType")
    public String deleteType(){
        typeService.deleteType((long)1);
        return "Delete successfully";
    }

    //REST
//    postmen 去 测   browser只能接 get



}
