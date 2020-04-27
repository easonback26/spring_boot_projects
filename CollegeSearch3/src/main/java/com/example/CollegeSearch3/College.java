package com.example.CollegeSearch3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class College {

    //Sample API link we will be using:https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=2,3&fields=id,school.name,2017.student.size&per_page=100&zip=44106&distance=10mi&api_key=uadsOJiCZ4hjWrwya0Rps1qYkpkmr0SyVjePFwNt

    @JsonProperty("id")
    private Long id;

    @JsonProperty("2017.student.size")
    private Long size;
    //private Long year;

    @JsonProperty("school.name")
    private String name;

//    public College(Long id, Long size, String name){
//        this.id = id;
//        this.size = size;
//        //this.year = year;
//        this.name = name;
//    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSize() {
        return size;
    }

    public void setSize(Long size) {
        this.size = size;
    }

//    public Long getYear() {
//        return year;
//    }

//    public void setYear(Long year) {
//        this.year = year;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "College{" +
                "id=" + id +
                ", size=" + size +
                //", year=" + year +
                ", name='" + name + '\'' +
                '}';
    }
}
