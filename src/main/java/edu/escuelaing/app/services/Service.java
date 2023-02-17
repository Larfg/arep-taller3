package edu.escuelaing.app.services;

/**
 * Interfaz de un servicio de la aplicacion
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public interface Service {
    public static final String HTML_HEADER = "HTTP/1.1 200 OK\r\n"
    + "Access-Control-Allow-Origin: *\r\n"
    + "Content-Type:text/html \r\n"
    + "\r\n";
    /**
     * Retorna el encabezado de una petición HTTP
     * @return Encabezado del HTTP
     */
    public String getHeader();

    /**
     * Retorna el cuerpo de una petición HTTP
     * @return Cuerpo de la petición HTTP
     */
    public String getBody();
}
