# Prueba Tecnica
Para correr localmnete se debe clonar el repositorio, abrir con el editor preferido y correr la instalacion de dependencias para luego correr la clase principal. Para ejecutar los test se puede correr mvn clean install o en el editor de preferencia ejecutar el archivo DemoApplicationTest.java ubicado en la carpeta tests
Este proyecto fue creado para dar solucion a la prueba tecnica alojada en el siguiente enlace http://test-env.eba-cr5ydvta.us-east-2.elasticbeanstalk.com/api/calculo
el cual tambien cuenta con un front alojado en la siguiente direccion https://javatechfront-git-main-jdosorio.vercel.app/ y del cual el repositorio se enuentra en https://github.com/jdosorio/javatechfront

Tiene configurado el endpoint /api/calculo el cual acepta peticiones get y post y puede usarse mediante clientes como postman con el siguiente objeto 
{
    "paramN": 187,
    "paramX": 10,
    "paramY": 5
}


