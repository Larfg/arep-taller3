package edu.escuelaing.app.mySpark;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String body = "";
    String raw = "";
    String method = "";
    String uri = "";
    Map<String, String> headers = new HashMap<String, String>();

    

    public Request(String body, String method, String uri, Map<String, String> headers) {
        this.body = body;
        this.method = method;
        this.uri = uri;
        this.headers = headers;
    }

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
                this.headers.put(header.split(":")[1], body);
            }
        }
    }

    public String getHeader(String key) {
        return headers.get(key);
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
