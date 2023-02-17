package edu.escuelaing.app.services;

/**
 * Servicio sencillo en donde podemos agregar texto a una cadena inicial
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class BlogService implements Service{
    private static BlogService instance = null;

    String message = "Blog Service:";

    /**
     * Patron singleton para que el blog sea el mismo para todos los que quieran acceder
     * @return
     */
    public static BlogService getInstance() {
        if (instance == null) {
            instance = new BlogService();
        }
        return instance;
    }

    @Override
    public String getBody() {
        return message;
    }

    @Override
    public String getHeader() {
        return "HTTP/1.1 200 OK\r\n"
        + "Access-Control-Allow-Origin: *\r\n"
        + "Content-Type:text/plain \r\n"
        + "\r\n";
    }

    /**
     * Nos permite agregar un mensaje al final de la cadena principal
     * @param message mensaje a añadir
     */
    public void addToMessage(String message){
        this.message += message;
    }
    
}
