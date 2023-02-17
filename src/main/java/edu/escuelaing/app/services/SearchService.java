package edu.escuelaing.app.services;

/**
 * Cliente de busqueda de archivos dentro del disco duro
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class SearchService implements Service{

    public String getHeader(){
        return Service.HTML_HEADER;
    }

    public String getBody(){
        FileReader fileReader = new FileReader("/file/src/main/webapp/searchPage.html");
        return fileReader.getBody();
    }
    
}
