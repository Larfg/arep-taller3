package edu.escuelaing.app.mySpark;

import java.util.HashMap;

/**
 * Clase que implementa response para tener una respuesta facil de obtener de un get satisfactorio
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class CreatedResponse extends Response{

    public CreatedResponse() {
        super("Creado exitosamente","Created","201", new HashMap<>());      
    }

}