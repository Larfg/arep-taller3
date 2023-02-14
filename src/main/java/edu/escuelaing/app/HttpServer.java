package edu.escuelaing.app;

import java.net.*;
import java.io.*;
import java.util.Map;

import edu.escuelaing.app.services.FileReader;
import edu.escuelaing.app.services.NotFoundService;
import edu.escuelaing.app.services.Service;

/**
 * Servidor ws que nos permite enviar y recibir elementos por ws
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public final class HttpServer {
    private static HttpServer instance;
    
    /**
     * Retorna la instancia del servidor, en caso de que no exista lo crea
     * @return instancia del servidor
     */
    public static HttpServer getInstance() {
        if (instance == null) {
            instance = new HttpServer();
        }
        return instance;
    }

    /**
     * Metodo principal que nos inicia un servidor socket http, junto a unos servicios determinados
     * @param args
     * @param services mapa de servicios que vamos a utilizar
     * @throws IOException
     */
    public void run(String[] args, Map<String, Service> services) throws IOException {
        System.out.println("Servidor funcionando ...");
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(35000);

        } catch (IOException e) {
            System.err.println("Could not listen on port: 35000.");
            System.exit(1);
        }
        boolean running = true;
        while (running) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.err.println("Accept failed.");
                System.exit(1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine, outputLine;
            String path = "";
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.startsWith("GET")) {
                    path = inputLine.split(" ")[1];
                }
                if (!in.ready()) {
                    break;
                }
            }
            Service servicio = new NotFoundService();
            if (services.keySet().contains(path.replace("/", ""))){
                servicio = services.get(path.replace("/", ""));
            }
            else if (path.contains("/file/")){
                servicio = new FileReader(path);
            }
            outputLine = servicio.getHeader() + servicio.getBody();
            out.println(outputLine);
            out.close();
            in.close();
            clientSocket.close();
        }
        serverSocket.close();
        System.out.println("Servidor apagado.");
    }
}