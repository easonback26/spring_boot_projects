package com.example.CollegeSearch2;

//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//
//@Entity


public class College {

    private Long id;
    private Long size;
    private Long year;
    private String name;

    public College(Long id, Long size, Long year, String name){
        this.id = id;
        this.size = size;
        this.year = year;
        this.name = name;
    }


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

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

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
                ", year=" + year +
                ", name='" + name + '\'' +
                '}';
    }
}
