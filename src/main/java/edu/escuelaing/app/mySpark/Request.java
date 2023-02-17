package edu.escuelaing.app.mySpark;

import java.util.HashMap;
import java.util.Map;

/**
 * Estructura de una HTTP Request en forma de clase
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class Request {
    String body = "";
    String raw = "";
    String method = "";
    String uri = "";
    Map<String, String> headers = new HashMap<String, String>();

    /**
     * Constructor en donde podemos meter individualmente los elementos del request
     * @param body Cuerpo del request
     * @param method Metodo get post put delete del request
     * @param uri Uri del request
     * @param headers Encabezados del request
     */
    public Request(String body, String method, String uri, Map<String, String> headers) {
        this.body = body;
        this.method = method;
        this.uri = uri;
        this.headers = headers;
    }

    /**
     * Constructor en donde podemos meter headers y body en ves de elementos individuales
     * @param headers Encabezados del request
     * @param body Cuerpo del request
     */
    public Request(String headers, String body) {
        raw = headers + "\r\n" + body;
        String[] headersList = headers.split("\r\n");
        if (headersList.length > 0) {
            method = headersList[0].split(" ")[0];
            if (headersList[0].split(" ").length > 1) {
                uri = headersList[0].split(" ")[1];
            }
        }
        for (String header : headersList) {
            if (header.contains(":")) {
                this.headers.put(header.split(":")[0], header.split(":")[1]);
            }
        }
        this.body = body;
    }

    /**
     * Función que nos permite leer el header que querramos
     * @param key Header que queremos leer
     * @return Contenido del header
     */
    public String getHeader(String key) {
        if (this.headers.containsKey(key)) {
            return headers.get(key);
        }
        return "Header no definido";
    }

    public String getUri() {
        return uri;
    }

    public String getMethod() {
        return method;
    }

    @Override
    public String toString() {
        return raw;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getRaw() {
        return raw;
    }

    public void setRaw(String raw) {
        this.raw = raw;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    

}
