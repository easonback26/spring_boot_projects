package com.example.CollegeSearch2;

public class Search {

    private String zip;
    private String distance;
    private String degree;
    private String year;



    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Search{" +
                "zip=" + zip +
                ", distance=" + distance +
                ", degree='" + degree + '\'' +
                ", year=" + year +
                '}';
    }
}
