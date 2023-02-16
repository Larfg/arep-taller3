package edu.escuelaing.app.mySpark;

import java.util.HashMap;
import java.util.Map;

public class MySpark {
    static Map<String, RequestResponse> gets = new HashMap<String, RequestResponse>();
    static Map<String, RequestResponse> posts = new HashMap<String, RequestResponse>();

    public interface RequestResponse{
        Object process(Request request, Response response);
    }

    public static void get(String path,  RequestResponse requestResponse){
        if (!gets.containsKey(path)){
            gets.put(path, requestResponse);
        }
    }

    public static Object getGet(String path, Request request, Response response){
        return gets.get(path).process(request, response);
    }

    public static void post(String path, RequestResponse requestResponse){
        if (!posts.containsKey(path)){
            posts.put(path, requestResponse);
        }
    }

    public static Object getPost(String path, Request request, Response response){
        return posts.get(path).process(request, response);
    }

    public static Boolean isMapped(String path){
        return gets.containsKey(path) || posts.containsKey(path);
    }
    
}
