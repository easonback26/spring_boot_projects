package com.sincere.candy.controller;

import com.sincere.candy.model.Pet;
import com.sincere.candy.service.PetService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

//非常重要!!!!:  RestController 和 Controller 的区别
//如果要return单个data(String/json), 用RestController. return一个file 或者template用Controller.
@RestController
@CrossOrigin
@Api(description = "textController")
public class TestController {

    @Autowired
    private PetService petService;

    @GetMapping("index")
    @ApiOperation(value = "simple return string")


    public List<Pet> index(HttpServletRequest request){
//        List<Pet> allPets = petService.getAllOwners();
//        System.out.println(allPets);
//        String userName = request.getParameter("userName");
//        String operation = request.getParam eter("operation");

        String sql = request.getParameter("SQL");
        List<Pet> allPets = petService.executeAndShowAll(sql);
        for (Object pet : allPets){
            System.out.println(pet);
        }
        System.out.println("----------------------------------------------------------------------------");


        //System.out.println(allPets);

        //return "index";
        return allPets;
    }

}