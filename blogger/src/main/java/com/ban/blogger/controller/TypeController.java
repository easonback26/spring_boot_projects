package com.ban.blogger.controller;

import com.ban.blogger.model.Type;
import com.ban.blogger.service.TypeService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
public class TypeController {

    @Autowired
    private TypeService typeService;

    @GetMapping("/getById")
    public String getType(){
        Type type = typeService.getType((long)56);
        Gson gson = new Gson();
        String jsonString = gson.toJson(typeService.getType((long)56));

        Type tt = gson.fromJson(jsonString,Type.class);

        System.out.println(tt);
        return "type service gets called. ";
    }

    //重要 动态返回 Id
    @GetMapping("/getById/{id}")
    public String getType(@PathVariable long id){
        Type type = typeService.getType(id);
        System.out.println(type);
        return "type service gets called. ";
    }


    @GetMapping("/getAllType")
    public String getAllType(){
        Gson gson = new Gson();
        String jsonString = gson.toJson(typeService.getAllType());

        List jsonList = gson.fromJson(jsonString,List.class);
        for (Object el : jsonList) {
            jsonString = gson.toJson(el);
            Type type = gson.fromJson(jsonString,Type.class);
            System.out.println(type);
        }
//        typeList.forEach((el) -> {
//            System.out.println(el);
//        });

        //return typeService.getAllType();
        return gson.toJson(typeService.getAllType());
    }

    @PutMapping ("/addType/{value}")
    public String addType(@PathVariable String value){
        typeService.addType(value);

        Gson gson = new Gson();
        return gson.toJson(value);
    }

//    @PostMapping ("/addType")
//    public String addType(HttpServletRequest request){
//        String value = request.getParameter("value");
//        typeService.addType(value);
//        return value;
//    }

    @PostMapping ("/updateType/{value}/{id}")
    public String updateType(@PathVariable String value, @PathVariable String id){
        Type type = typeService.updateType(value, id);

        System.out.println(value);
        System.out.println(id);

        Gson gson = new Gson();
        return gson.toJson(type);
    }

    @DeleteMapping("/deleteType/{id}")
    public String deleteType(@PathVariable long id){
        typeService.deleteType(id);
        return "Delete successfully";
    }

    //REST
//    postmen 去 测   browser只能接 get



}
