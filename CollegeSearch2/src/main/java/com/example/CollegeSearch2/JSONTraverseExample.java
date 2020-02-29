package com.example.CollegeSearch2;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JSONTraverseExample {

    private static String jsonString = "";
    private static String returnString = "";

    public JSONTraverseExample(String s)
    {
        jsonString = s;
    }
    public static void main(String[] args) throws IOException, ParseException {
        // parsing file "JSONExample.json"
        Object obj = new JSONParser().parse(jsonString);

        // typecasting obj to JSONObject
        JSONObject jo = (JSONObject) obj;

//        JSONParser parser = new JSONParser();
//        JSONObject json = (JSONObject) parser. parse(jsonString);

        //JSONObject jo = new JSONObject(o);

        handleValue(obj);
    }

    public String startTraverse() throws IOException, ParseException
    {
        Object obj = new JSONParser().parse(jsonString);

        handleValue(obj);

        return returnString;
    }

     static void handleValue(Object value) {
        if (value instanceof JSONObject) {
            handleJSONObject((JSONObject) value);
        } else if (value instanceof JSONArray) {
            handleJSONArray((JSONArray) value);
        } else {
            System.out.print("value: ");
            System.out.println(value);

            returnString = returnString + "value: " + value + "\n";
        }
    }

    private static void handleJSONObject(JSONObject jsonObject) {
        jsonObject.keySet().forEach(key -> {
            Object value = jsonObject.get(key);
            System.out.print("key: ");
            System.out.println(key);
            returnString = returnString + "key: " + key + "\n";
            handleValue(value);
        });
    }

    private static void handleJSONArray(JSONArray jsonArray)
    {
        jsonArray.iterator().forEachRemaining(JSONTraverseExample::handleValue);
    }


}