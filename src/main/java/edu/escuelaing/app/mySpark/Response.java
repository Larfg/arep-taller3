package edu.escuelaing.app.mySpark;

import java.util.Map;

import edu.escuelaing.app.services.Service;

public class Response {
    String body;
    String raw;
    String status;
    String code;
    Map<String, String> headers;

    public Response(String body, String status, String code, Map<String, String> headers) {
        this.body = body;
        this.status = status;
        this.code = code;
        this.headers = headers;
    }

    public Response(String headers, String body) {
        raw = headers + "\r\n" + body;
        String[] headersList = headers.split("\r\n");
        status = headersList[0].split(" ")[3];
        code = headersList[0].split(" ")[1];
        for (String header : headersList) {
            if (header.contains(":")) {
                this.headers.put(header.split(":")[1], body);
            }
        }
    }

    public Service responseToService() {
        return new Service() {
            public String getHeader() {
                String header = "";
                header += "HTTP/1.1 " + code + " " + status + "\r\n";
                if (headers != null) {
                    for (String key : headers.keySet()) {
                        header += key + ": " + headers.get(key) + "\r\n";
                    }
                }
                return header + "\r\n" + "" ;
            }
            public String getBody() {
                return body;
            }
        };
    }

    public String getHeader(String key) {
        return headers.get(key);
    }

    public String getCode() {
        return code;
    }

    public String getStatus() {
        return status;
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

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

}
