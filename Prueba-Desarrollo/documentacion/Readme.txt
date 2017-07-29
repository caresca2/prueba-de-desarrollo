Autor: Carlos Felipe Restrepo Russi
cédula: 1020760785

El siguiente proyecto es la prueba de desarrollo, en la cual se utilizó java JDK 1.6 y eclipse para su desarrollo, la aplicación cuenta con una sola clase llamada Principal, la cual es la clase encargada de realizar todas las operaciones, en ella se encuentra el método main para poder ejecutar la aplicación.

Al ejecutar la aplicación lo primero que se mostrará, es un mensaje de inicio de programa y el mensaje para ingresar el número de filas que se quieren para la matriz, para este método se comprueba que sea un dato válido, hasta que no se dé un dato de tipo numérico, no se avanzará. Luego de ingresas las filas de la matriz se ingresan las columnas con el mismo procedimiento que el de las filas.

Introduzca numero de filas:
10
Introduzca numero de columnas:
10

Después de ingresar los datos de la matriz, se inicia el mensaje para realizar los comandos de movimiento del programa, para mover el vehículo basta con poner el número de casillas que se va a mover junto con la dirección <numeroDeCasillas,orientación> (ejemplo: 1,E, correrá una casilla hacia el Este),una vez realizado el comando, verificando que esté bien escrito y que no traspase los límites de la matriz, la consola de comandos muestra donde queda el vehículo ubicado en la matriz junto con el comando utilizado; si no se puede realizar el movimiento por mala escritura del comando o si sale de los limites lanza un error e indica donde quedó el vehículo ubicado en la matriz. 

Ej

Introduzca comando:
1,E
el vehiculo se encuentra en la posicion:1,0
despues de aplicar el comando:1,E


La ventana de comandos también realiza comandos unidos por “;” (ejemplo 1,E;1,S, correrá una casilla hacia el este y luego otra hacia el norte) una vez realizado esto, el programa los realiza uno por uno, con esto si por ejemplo el vehiculo se puede mover la primera parte de la instrucción pero no la segunda, el vehiculo solo realizara los movimientos hasta donde se permita

Ej
Introduzca comando:
1,E;1,S
el vehiculo se encuentra en la posicion:1,0
despues de aplicar el comando:1,E
Se ha detenido el avance por  salir de los limites o el comando es invalido
el vehiculo se encuentra en la posicion:1,0
despues de aplicar el comando:1,S

Introduzca comando:

El programa también realiza otras operaciones útiles por ejemplo si se escribe el comando MATRIZ imprime la matriz para dibujar la matriz y la posición del vehículo denotada en la matriz como “ve”

Ejemplo 

Introduzca comando:
MATRIZ
0,9 1,9 2,9 3,9 4,9 5,9 6,9 7,9 8,9 9,9 
0,8 1,8 2,8 3,8 4,8 5,8 6,8 7,8 8,8 9,8 
0,7 1,7 2,7 3,7 4,7 5,7 6,7 7,7 8,7 9,7 
0,6 1,6 2,6 3,6 4,6 5,6 6,6 7,6 8,6 9,6 
0,5 1,5 2,5 3,5 4,5 5,5 6,5 7,5 8,5 9,5 
0,4 1,4 2,4 3,4 4,4 5,4 6,4 7,4 8,4 9,4 
0,3 1,3 2,3 3,3 4,3 5,3 6,3 7,3 8,3 9,3 
0,2 1,2 2,2 3,2 4,2 5,2 6,2 7,2 8,2 9,2 
0,1 1,1 2,1 3,1 4,1 5,1 6,1 7,1 8,1 9,1 
0,0 ve  2,0 3,0 4,0 5,0 6,0 7,0 8,0 9,0

Para terminar la ejecución del programa se debe escribir el comando TERMINAR. Lo cual devuelve un mensaje con respuesta de que el programa ha finalizado con éxito 
