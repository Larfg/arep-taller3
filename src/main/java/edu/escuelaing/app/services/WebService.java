package edu.escuelaing.app.services;

/**
 * Servicio que nos devuelve una página de inicio
 * @author Luis Felipe Giraldo Rodriguez
 * @version 1.0
 */
public class WebService implements Service{

    
    public String getHeader(){
        return "HTTP/1.1 200 OK\r\n"
        + "Access-Control-Allow-Origin: *\r\n"
        + "Content-Type:text/html \r\n"
        + "\r\n";
    }

    public String getBody(){
        return "<autor>Luis Felipe Giraldo</autor>"+
        "        "+
        "        <meta charset=\"utf-8\" />"+
        "        <title>HTML</title>"+
        "        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\" />"+
        "        <style>"+
        "            * {"+
        "        box-sizing: border-box;"+
        "        }"+
        "        body {"+
        "        font-family: Arial, Helvetica, sans-serif;"+
        "        background-color: cornsilk;"+
        "        }"+
        "        .header {"+
        "        background-color: rgb(34, 129, 158);"+
        "        padding: 5px;"+
        "        text-align: center;"+
        "        font-size: 20px;"+
        "        color: white;"+
        "        border: 2px solid black;"+
        "        border-radius: 5px;"+
        "        }"+
        "        .container {"+
        "        margin-top: 15px;"+
        "        }"+
        "        </style>"+
        "        </head>"+
        "        <body>"+
        "            <div class=\"header\">"+
        "            <h3>PAGINA PRINCIPAL</h3>"+
        "            </div>"+ "<p>Paths disponibles: /apps/search/</p>"+
        "        </body>"+
        "        </html>";
    }
}
