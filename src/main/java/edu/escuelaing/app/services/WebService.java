package edu.escuelaing.app.services;

/**
 * Servicio que nos devuelve una página de inicio
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public class WebService implements Service{

    
    public String getHeader(){
        return "HTTP/1.1 200 OK\r\n"
        + "Access-Control-Allow-Origin: *\r\n"
        + "Content-Type:text/html \r\n"
        + "\r\n";
    }

    public String getBody(){
        FileReader fileReader = new FileReader("/file/src/main/webapp/index.html");
        return fileReader.getBody();
    }
}
