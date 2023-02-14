package edu.escuelaing.app.mySpark;

import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.app.services.Service;

public class mySpark {
    static Map<String, RequestResponse> gets = new HashMap<String, RequestResponse>();

    interface RequestResponse{
        Object process(Request request, Response response);
    }

    public static void get(String path,  RequestResponse requestResponse){
        if (!gets.containsKey(path)){
            gets.put(path, requestResponse);
        }
    }
    
}
