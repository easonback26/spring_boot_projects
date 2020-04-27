package com.example.CollegeSearch3;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@RestController
public class AppController {

    private static final String template = "Hello, %s!";

    @GetMapping("/greeting")
    public String greeting(){

        Quote response= new RestTemplate().getForObject(
                "https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3&fields=id,school.name,2017.student.size&per_page=100&zip=44106&distance=10mi&api_key=uadsOJiCZ4hjWrwya0Rps1qYkpkmr0SyVjePFwNt", Quote.class);

        //System.out.println(response);
//        EmployeeList response = restTemplate.getForObject(
//                "http://localhost:8080/employees",
//                EmployeeList.class);
        //List<College> colleges = response.getColleges();

//        System.out.println(colleges.size());
//
//        for (College ele : colleges)
//        {
//            System.out.println(ele.toString());
//        }
        return response.toString();
    }
}
