# Taller 3: Microframeworks WEB 

## Diseño y descripción del diseño:   

Para este taller modificamos el servidor del taller 2, para que, en vez de invocar servicios con la uri, podemos invocar servicios por métodos HTTP, como lo son post y get. Otro objetivo del taller simular la biblioteca SPARK, biblioteca que nos permite mapear solicitudes con funciones lambdas, es decir mapear a una solicitud HTTP el comportamiento que queramos. 
En el desarrollo se modificó el laboratorio anterior para que pueda funcionar con el nuevo sistema, además se cambió la búsqueda de archivos, para que no sean en todo el disco local, sino que sea dentro del path relativo del proyecto. 
Todo el taller se realizó sin ningún framework, utilizando las librerías de java.   
Los elementos HTML ya no se encuentran grabados en el código, sino están como archivos estáticos dentro del proyecto. 

### Extensibilidad   

Para asegurar la extensibilidad se utilizó un sistema de mapeo en donde fácilmente a partir de una función, a una petición se le puede asignar el comportamiento que se quiera por medio de una función lambda. 

### Uso de patrones   

Utilizamos un patrón **SINGLETON** para asegurarnos de que solo exista una instancia del servidor y del blog servicie, y usamos un patrón **ABSTRACT FACTORY** a la hora de manejar nuestros servicios.   

### Modularidad   

Al tener un microframework que nos permite inyectar fácilmente comportamientos de una request, satisfacemos la modularidad.   

## Prerrequisitos:   

Debe tener java, Maven, Postman para el manejo de solicitudes, y un navegador web, preferiblemente Firefox.  


## Instalación:   

Clone el repositorio.  

## Realizando pruebas:   

Para probar el funcionamiento del servidor podemos acceder directamente al localhost:35000 desde nuestro navegador, principalmente al path /apps/, en donde se ven los distintos servicios a los cuales podemos acceder desde el navegador cambiando la URI, igualmente estos servicios son, página principal (http://localhost:35000/apps/), página de búsqueda de archivos estáticos (http://localhost:35000/apps/search) y por último página de blog (http://localhost:35000/apps/blog). Esta es una forma vistosa de probar las solicitudes get, ya que el navegador realiza está solicitud siempre que se realiza una búsqueda. 
Si desea ser más específico puede utilizar postman, a todas las uris listadas anteriormente se les puede realizar un get, retornando los elementos de las páginas web, lo más importante de utilizar postman es la posibilidad de mandar texto por un post al servicio de blog, los invitamos a intentarlo y comprobar que se actualiza visitando nuevamente el servicio de blog en el navegador. 

## Despliegue:   

- Para poder iniciar el servidor se puede iniciar por Maven, con el siguiente comando "mvn compile exec:java" o puede iniciarlo directamente con la clase ejecutiva del proyecto.   
- Para probar los servicios pruebe el siguiente enlace después de ejecutar el servidor (http://localhost:35000/apps/).  

## Construido con:   

[Maven](https://maven.apache.org/) - Dependency Management     

## Autores:   

- Luis Felipe Andres Giraldo Rodriguez 
