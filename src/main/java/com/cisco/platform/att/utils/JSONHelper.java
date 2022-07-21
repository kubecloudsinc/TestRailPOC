package com.cisco.platform.att.utils;

import com.cisco.platform.att.model.TestRun;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.Map;

public class JSONHelper {
    public static TestRun getTestRunFromJson(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, TestRun.class);
    }
    public static String getJsonFromObject(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String post =  mapper.writeValueAsString(obj);
        return post;
    }
    public static Map<String, Object> getJsonMapFromObject(Object obj) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(mapper.writeValueAsString(obj), Map.class);
        return map;
    }
}
