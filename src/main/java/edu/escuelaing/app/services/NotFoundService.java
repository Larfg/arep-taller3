package edu.escuelaing.app.services;

/**
 * Servicio de pagina de busqueda no encontrada
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public class NotFoundService implements Service{
    public String getHeader(){
        return "HTTP/1.1 404 Not Found" + 
        "\r\n"
        + "Content-Type:text/html \r\n"
        + "\r\n";
    }
    public String getBody(){
        return "<html>"+
        "<body>"+
        ""+
        "<h1>Pagina no encontrada!</h1>"+
        ""+
        "<img src=\"https://media.giphy.com/media/3o7aCTPPm4OHfRLSH6/giphy.gif\" alt=\"Computer man\">"+
        ""+
        "</body>"+
        "</html>"; 
    }
    
}
