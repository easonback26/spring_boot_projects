package com.ban.blogger.controller;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.internal.$Gson$Types;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;

@RestController
public class IndexController {

    @GetMapping
    public String index(){
        return "my String";
    }


//    @GetMapping("/index2")
//    public String index2(){
//        return "my String 2";
//    }
//
//    @GetMapping("/indexList")
//    public ArrayList<String> indexList(){
//        ArrayList<String> gfg = new ArrayList<String>();
//
//        // Initialize an ArrayList with add()
//        gfg.add("Geeks");
//        gfg.add("for");
//        gfg.add("Geeks");
//
//        return gfg;
//    }
//
//    @GetMapping("/indexHashMap")
//    public HashMap<Integer, String> indexHashMap(){
//        HashMap<Integer, String> hm = new HashMap<Integer, String>();
//        hm.put(1, "A");
//        hm.put(2, "B");
//        hm.put(3, "C");
//        return hm;
//    }
//
//    @GetMapping("/indexGson")
//    public Object indexGson(){
//        Gson gson = new Gson();
//        String[] strings = {"abc", "def", "ghi"};
//
//        return gson.toJson(strings);
//    }
//
//    @GetMapping("/indexJsonObject")
//    public String indexJsonObject(){
//        JsonObject jsonObject = new JsonObject();
//
//        JsonObject level2 = new JsonObject();
//        level2.add("key1", new JsonObject());
//        level2.add("key2", new JsonObject());
//
//        jsonObject.add("key", level2);
//
//        return jsonObject.toString();
//    }

}
