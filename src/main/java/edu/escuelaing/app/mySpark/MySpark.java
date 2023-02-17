package edu.escuelaing.app.mySpark;

import java.util.HashMap;
import java.util.Map;

/**
 * Clase que nos permite mapear solicitudes get y post con comportamientos definidos por una función lambda
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class MySpark {
    static Map<String, RequestResponse> gets = new HashMap<String, RequestResponse>();
    static Map<String, RequestResponse> posts = new HashMap<String, RequestResponse>();

    /**
     * Interfaz funcional que nos da da la estructura de un porcesamiento entre un request y un response
     */
    public interface RequestResponse{
        Object process(Request request, Response response);
    }

    /**
     * Nos permite asignar a un path, un requestResponse definido para el metodo get
     * @param path Path en donde vamos a guardar el requestResponse
     * @param requestResponse funcion lambda que determina el funcionamiento de la request
     */
    public static void get(String path,  RequestResponse requestResponse){
        if (!gets.containsKey(path)){
            gets.put(path, requestResponse);
        }
    }

    /**
     * Nos permite llamar un get de un path, dandole una request, una response retornando un process definido
     * @param path Path deel cual deseamos buscar
     * @param request Request a procesar
     * @param response Response a procesar
     * @return Respuesta del procesado
     */
    public static Object getGet(String path, Request request, Response response){
        return gets.get(path).process(request, response);
    }

    /**
     * Nos permite asignar a un path, un requestResponse definido para el metodo post
     * @param path Path en donde vamos a guardar el requestResponse
     * @param requestResponse funcion lambda que determina el funcionamiento de la request
     */
    public static void post(String path, RequestResponse requestResponse){
        if (!posts.containsKey(path)){
            posts.put(path, requestResponse);
        }
    }

    /**
     * Nos permite llamar un post de un path, dandole una request, una response retornando un process definido
     * @param path Path deel cual deseamos buscar
     * @param request Request a procesar
     * @param response Response a procesar
     * @return Respuesta del procesado
     */
    public static Object getPost(String path, Request request, Response response){
        return posts.get(path).process(request, response);
    }

    /**
     * Función para identificar si a un path hay un elemento asignado
     * @param path Path que deseamos consultar
     * @return True si hay un path guardado, de lo contraro false
     */
    public static Boolean isMapped(String path){
        return gets.containsKey(path) || posts.containsKey(path);
    }
    
}
