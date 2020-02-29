package com.example.CollegeSearch2;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;

import com.google.gson.Gson;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.json.JsonParser;
import org.springframework.boot.json.JsonParserFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
//import sun.misc.IOUtils;

@Controller
@Api("AppController")
public class AppController {

    @ApiOperation(value = "Search Form to get started")
    @GetMapping("/searching")
    public String searchingForm(Model model) {
        model.addAttribute("searching", new Search());
        return "searching";
    }

    @ApiOperation(value = "Search Result with PostMapping")
    @PostMapping("/searching")
    public String searchingSubmit(Model model, @ModelAttribute Search search) throws Exception{

        String zip = search.getZip();
        String distance =search.getDistance();
        String year = search.getYear();
        String degree = search.getDegree();

        //Grab all the results.
        String url = "https://api.data.gov/ed/collegescorecard/v1/schools.json?school.degrees_awarded.predominant=" + degree + "&fields=id,school.name," + year + ".student.size&per_page=100&zip=" + zip + "&distance=" + distance + "&api_key=uadsOJiCZ4hjWrwya0Rps1qYkpkmr0SyVjePFwNt";
        RestTemplate restTemplate = new RestTemplate();
        JsonParser springParser = JsonParserFactory.getJsonParser();
        String resp = restTemplate.getForObject(url, String.class);
        Map<String, Object> map = springParser.parseMap(resp);

        //Create ArrayList to store all results.  Create TreeMap to sort all Results by student size.
        ArrayList la = (ArrayList)map.get("results");
        TreeMap<Long, String> tm = new TreeMap<Long, String>();
        List<College> listCollege = new ArrayList<College>();

        // Parse and sort the results by using a TreeMap
        for(Object obj: la)
        {
            //System.out.println(obj.toString());

            Gson gs = new Gson();
            String jsonString = gs.toJson(obj);

            // parsing file
            Object objc = new JSONParser().parse(jsonString);

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) objc;

            // put size as key, json as value into the TreeMap
            Long size = (Long) jo.get(year + ".student.size");
            tm.put(size, jsonString);
        }

        String str = "";
        // iteration over TreeMap.entrySet()
        for (Map.Entry<Long, String> entry : tm.entrySet())
        {

            str = str + entry.getValue();

            // parsing String
            Object obj = new JSONParser().parse(entry.getValue());

            // typecasting obj to JSONObject
            JSONObject jo = (JSONObject) obj;


            // getting firstName and lastName
            Long size = (Long) jo.get(year + ".student.size");
            Long id = (Long) jo.get("id");
            String name = (String) jo.get("school.name");
            Long yearLong = Long.parseLong(year);

            College col = new College(id, size, yearLong, name);
            listCollege.add(col);
        }

        for (College col :listCollege)
        {
            System.out.println(col);
        }

//        Gson gso = new Gson();
//        System.out.println(gso.toJson(str));

        System.out.println(str);

        model.addAttribute("listColleges", listCollege);
        //return returnString;

        return "result";
    }


}