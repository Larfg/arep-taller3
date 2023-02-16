package edu.escuelaing.app;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import edu.escuelaing.app.mySpark.CreatedResponse;
import edu.escuelaing.app.mySpark.MySpark;
import edu.escuelaing.app.services.BlogService;
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
        MySpark.get("/apps/",  (req,res) -> {
            Service service = new WebService();
            return service;
        });
        MySpark.get("/apps/search",(req,res) -> {
            Service service = new SearchService();
            return service;
        });
        MySpark.get("/apps/blog",(req,res)->{
            Service service = BlogService.getInstance();
            return service;
        });
        MySpark.post("/apps/blog", (req,res) ->{
            BlogService service = BlogService.getInstance();
            service.addToMessage(req.getBody());
            System.out.println(service.getBody());
            return new CreatedResponse();
        } );
        httpServer.run(args,services);
    }
}
