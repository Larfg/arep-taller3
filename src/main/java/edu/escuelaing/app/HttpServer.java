package edu.escuelaing.app;

import java.net.*;
import java.io.*;
import java.util.Map;

import edu.escuelaing.app.mySpark.Request;
import edu.escuelaing.app.mySpark.Response;
import edu.escuelaing.app.mySpark.CreatedResponse;
import edu.escuelaing.app.mySpark.MySpark;
import edu.escuelaing.app.services.FileReader;
import edu.escuelaing.app.services.NotFoundService;
import edu.escuelaing.app.services.Service;

/**
 * Servidor ws que nos permite enviar y recibir elementos por ws
 * 
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public final class HttpServer {
    private static HttpServer instance;

    /**
     * Retorna la instancia del servidor, en caso de que no exista lo crea
     * 
     * @return instancia del servidor
     */
    public static HttpServer getInstance() {
        if (instance == null) {
            instance = new HttpServer();
        }
        return instance;
    }

    /**
     * Metodo principal que nos inicia un servidor socket http, que procesa solicitudes post y get
     * 
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

            //Proceso de lectura de los datos header y body de una solicitud
            String headerLine = "";
            while ((inputLine = in.readLine()) != null) {
                if (inputLine.length() == 0) {
                    break;
                }
                headerLine += inputLine + "\r\n";
            }
            StringBuilder body = new StringBuilder();
            while (in.ready()) {
                body.append((char) in.read());
            }

            //Proceso de procesamiento de las solicitudes post y get
            Request request = new Request(headerLine, body.toString());
            if (request.toString().length() > 3) {
                Service service = new NotFoundService();
                String uri = request.getUri();
                if (Boolean.TRUE.equals(MySpark.isMapped(uri))) {
                    Object response = null;
                    if (request.getMethod().equals("GET")) {
                        response = MySpark.getGet(uri, request, null);
                    } else {
                        response = MySpark.getPost(uri, request, null);
                    }
                    if (response instanceof Service) {
                        service = (Service) response;
                    } else if (response instanceof Response) {
                        service = ((Response) response).responseToService();
                    }
                }
                if (uri.contains("/file/")) {
                    service = new FileReader(uri);
                }
                outputLine = service.getHeader() + service.getBody();
                out.println(outputLine);
            }
            out.close();
            in.close();
            clientSocket.close();

        }
        serverSocket.close();
        System.out.println("Servidor apagado.");
    }
}