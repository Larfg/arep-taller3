package edu.escuelaing.app.services;

/**
 * Servicio que nos devuelve una página de inicio
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public class WebService implements Service{

    
    public String getHeader(){
        return Service.HTML_HEADER;
    }

    public String getBody(){
        FileReader fileReader = new FileReader("/file/src/main/webapp/index.html");
        return fileReader.getBody();
    }
}
