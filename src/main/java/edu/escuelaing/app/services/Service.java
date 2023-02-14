package edu.escuelaing.app.services;

/**
 * Interfaz de un servicio de la aplicacion
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public interface Service {
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
