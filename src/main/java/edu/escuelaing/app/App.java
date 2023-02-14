package edu.escuelaing.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.app.services.SearchService;
import edu.escuelaing.app.services.Service;
import edu.escuelaing.app.services.WebService;

/**
 * Clase main de nuestro servidor de servicios web.
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public class App {
    static HttpServer httpServer = HttpServer.getInstance();
    static Map<String,Service> services = new HashMap();
    public static void main(String[] args) throws IOException {
        services.put("", new WebService());
        services.put("search", new SearchService());
        httpServer.run(args,services);
    }
}
