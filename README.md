# Prueba Tecnica
Para correr localmente se debe clonar el repositorio, abrir con el editor preferido y correr la instalacion de dependencias para luego correr la clase principal. Para ejecutar los test se puede correr mvn clean install o en el editor de preferencia ejecutar el archivo DemoApplicationTest.java ubicado en la carpeta tests
Este proyecto fue creado para dar solucion a la prueba tecnica alojada en el siguiente enlace http://test-env.eba-cr5ydvta.us-east-2.elasticbeanstalk.com/api/calculo
el cual tambien cuenta con un front alojado en la siguiente direccion https://javatechfront-git-main-jdosorio.vercel.app/ y del cual el repositorio se enuentra en https://github.com/jdosorio/javatechfront

El proyecto se desplego en Aws ElasticBeanStalk mediante una pipeline https://github.com/jdosorio/javatech/actions 
Se integro sonarcloud https://sonarcloud.io/summary/overall?id=jdosorio_javatech con el fin de pasar el codigo por pruebas de coverage, seguridad y demas opciones, dichas opciones tambien estan en la pipeline de despliegue. En los actions se encuentran los artefactos que se generan al hacer push al proyecto asi como el codigo correspondiente para moverlo a aws.

Tiene configurado el endpoint /api/calculo el cual acepta peticiones get y post y puede usarse mediante clientes como postman con el siguiente objeto 
{
    "paramN": 187,
    "paramX": 10,
    "paramY": 5
}

<img width="1018" alt="Captura de pantalla 2023-06-16 a la(s) 2 12 43 p m" src="https://github.com/jdosorio/javatech/assets/11360510/8360971f-2230-4233-b2a0-df336c9b60f8">

<img width="1023" alt="Captura de pantalla 2023-06-16 a la(s) 2 13 01 p m" src="https://github.com/jdosorio/javatech/assets/11360510/b20bbd03-0ecd-4305-be16-02da2e8738f5">

<img width="1412" alt="Captura de pantalla 2023-06-16 a la(s) 2 13 23 p m" src="https://github.com/jdosorio/javatech/assets/11360510/32da1778-995d-4957-ad46-394d3b4a7080">



