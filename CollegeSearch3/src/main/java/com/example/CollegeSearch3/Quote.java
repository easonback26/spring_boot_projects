package com.example.CollegeSearch3;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Quote {

    @JsonProperty("metadata")
    private MetaData metaData;

    @JsonProperty("results")
    private College[] colleges;

    public Quote() {
    }

    public MetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(MetaData metaData) {
        this.metaData = metaData;
    }

    public College[] getColleges() {
        return colleges;
    }

    public void setColleges(College[] colleges) {
        this.colleges = colleges;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "metaData=" + metaData +
                ", colleges=" + Arrays.toString(colleges) +
                '}';
    }
}
