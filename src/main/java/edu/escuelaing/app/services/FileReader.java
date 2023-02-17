package edu.escuelaing.app.services;

import java.io.IOException;
import java.nio.file.*;

/**
 * Servicio de lectura de archivos del disco duro
 * 
 * @author Luis Felipe Giraldo Rodriguez
 * @version 3.0
 */
public class FileReader implements Service {
    //private static String HOME = System.getProperty("user.home");
    private static String HOME = ".";
    String type;
    String file;

    /**
     * Constructor en donde a partir de un path se lee los archivos del disco duro
     * del servidor
     * 
     * @param path path que desamos leer un archivo o directorio
     */
    public FileReader(String path) {
        String[] pathList = path.split("/");
        if (pathList.length < 3) {
            type = "html";
            Path filePath = Paths.get(HOME);
            String fileNames = "Directorios y archivos disponibles:<br>";
            /**
             * En este try listamos todos los archivos dentro de un directorio para
             * mostrarlos
             */
            try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(filePath)) {
                for (Path files : directoryStream) {
                    if (!Files.isHidden(files)) {
                        fileNames += "\r\n" + files.toString().replaceFirst(HOME, "") + "<br>";
                    }
                }
            } catch (IOException ex) {
            }
            file = fileNames;
        } else {
            path = path.replace("/file", HOME);
            Path filePath = Paths.get(path);
            if (!Files.exists(filePath)) {
                type = "html";
                file = "no existe el archivo o directorio";
            } else {
                if (Files.isDirectory(filePath)) {
                    type = "html";
                    String fileNames = "Directorios y archivos disponibles:<br>";
                    /**
                     * En este try listamos todos los archivos dentro de un directorio para
                     * mostrarlos
                     */
                    try (DirectoryStream<Path> directoryStream = Files.newDirectoryStream(filePath)) {
                        for (Path files : directoryStream) {
                            if (!Files.isHidden(files)) {
                                fileNames += "\r\n" + files.toString().replaceFirst(HOME, "") + "<br>";
                            }
                        }
                    } catch (IOException ex) {
                    }
                    if (fileNames.equals("Directorios y archivos disponibles:<br>")) {
                        fileNames = "Directorio vacio.";
                    }
                    file = fileNames;
                } else if (Files.isRegularFile(filePath)) {
                    type = filePath.toString().split("\\.")[1];
                    /**
                     * En este try leemos un archivo como lista de bytes y lo guardamos como string
                     */
                    try {
                        byte[] bs = Files.readAllBytes(filePath);
                        file = new String(bs);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public String getHeader() {
        switch (type) {
            case "html": {
                return Service.HTML_HEADER;
            }
            case "js": {
                return "HTTP/1.1 200 OK\r\n"
                        + "Access-Control-Allow-Origin: *\r\n"
                        + "Content-Type:text/javascript \r\n"
                        + "\r\n";
            }
            case "jpeg": {
                return "HTTP/1.1 200 OK\r\n"
                        + "Access-Control-Allow-Origin: *\r\n"
                        + "Content-Type:image/jpeg \r\n"
                        + "\r\n";
            }
            case "png": {
                return "HTTP/1.1 200 OK\r\n"
                        + "Access-Control-Allow-Origin: *\r\n"
                        + "Content-Type:image/png \r\n"
                        + "\r\n";
            }
            case "css": {
                return "HTTP/1.1 200 OK\r\n"
                        + "Access-Control-Allow-Origin: *\r\n"
                        + "Content-Type:text/css \r\n"
                        + "\r\n";
            }
            default: {
                return "HTTP/1.1 200 OK\r\n"
                        + "Access-Control-Allow-Origin: *\r\n"
                        + "Content-Type:text/html \r\n"
                        + "\r\n";
            }
        }
    }

    public String getBody() {
        return file;
    }

}
