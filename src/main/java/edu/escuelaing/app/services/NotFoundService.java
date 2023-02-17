package edu.escuelaing.app.services;

/**
 * Servicio de pagina de busqueda no encontrada
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class NotFoundService implements Service{
    public String getHeader(){
        return "HTTP/1.1 404 Not Found" + 
        "\r\n"
        + "Content-Type:text/html \r\n"
        + "\r\n";
    }
    public String getBody(){
        FileReader fileReader = new FileReader("/file/src/main/webapp/notFound.html");
        return fileReader.getBody();
    }
    
}
