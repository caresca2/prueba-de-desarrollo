import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Principal {

	// ATRIBUTOS
	/* atributo que representa ls matriz */
	private String[][] matriz;
	
	/* Atributo que representa el numero de columnas de la matriz */
	private int numeroColumnas;
	
	/* Atributo que representa el numero de filas de la matriz */
	private int numeroFilas;
	
	/* Atributo que representa la fila en la que el vehiculo se encuentra en la matriz */
	private int posicionVehiculoFila;
	
	/* Atributo que representa la columna en la que el vehiculo se encuentra en la matriz */
	private int posicionVehiculoColumna;
	
	/* Atributo que representa si se ha insertado de manera correcta las filas*/
	private boolean numeroFilasCorrecto;
	
	/* Atributo que representa si se ha insertado de manera correcta las columnas*/
	private boolean numerocolumnasCorrecto;
	
	/* Atributo que representa si se sigue corriendo la consola de comandos*/
	private boolean corriendo;

	
	/* constructor*/
	public Principal() {
		corriendo = true;
		System.out.println("inicio de programa:");

		// se establece el numero de filas para la matriz

		numeroFilasCorrecto = true;
		while (numeroFilasCorrecto == true) {
			try {
				introducirNumeroFilas();
				numeroFilasCorrecto = false;
			} catch (Exception e) {
				System.out.println("porfavor introduzca de manera correcta el numero  filas");

			}
		}

		// se establece el numero de columnas para la matriz
		numerocolumnasCorrecto = true;
		while (numerocolumnasCorrecto == true) {
			try {
				introducirNumeroColumnas();
				numerocolumnasCorrecto = false;
			} catch (Exception e) {
				System.out.println("porfavor introduzca de manera correcta el numero  columnas");
			}
		}

		// se genera la matriz
		matriz = new String[numeroFilas][numeroColumnas];
		generarMatriz();

		// se crea el vehiculo con su posicion inicial;
		posicionVehiculoColumna = matriz.length - 1;
		posicionVehiculoFila = 0;

		// escuchar comando
		while (corriendo == true) {
			leerComando();
		}

	}

	
	/* Metodo main*/
	public static void main(String[] args) 
	{
		new Principal();
	}

	/* Metodo que imprime la matriz para ser visualizada en la consola*/
	public void printMatix() {

		// se ubica el vehiculo en la matriz
		matriz[posicionVehiculoFila][posicionVehiculoColumna] = "ve ";
		
		//se imprime la matriz
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[j][i] + " ");
			}
			System.out.println();
		}
		System.out.println();
		
		//se borra la matriz para una futura consulta
		generarMatriz();
	}

	/* Metodo que genera la matriz vacia con sus posiciones*/
	public void generarMatriz() {
		int max = matriz.length - 1;
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = "" + i + "," + max;
				max--;
			}
			max = matriz.length - 1;
		}

	}

	/* Metodo encargado de leer los comandos por consola*/
	public void leerComando() {
		String comandoCompleto = "";
		System.out.println("Introduzca comando:");
		try {
			BufferedReader entradacomando = new BufferedReader(new InputStreamReader(System.in));
			comandoCompleto = entradacomando.readLine();
		} catch (IOException e) {
		}
		if (comandoCompleto.equals("MATRIZ")) {
			printMatix();
		} else if (comandoCompleto.equals("TERMINAR")) {
			corriendo = false;
			System.out.println("El programa a finalizado con exito");
		} else {
			try {
				//separa los comandos 
				String[] comando = comandoCompleto.split(";");

				for (int i = 0; i < comando.length; i++) {
					String[] splitComando = comando[i].split(",");
					int numeroEspacios = Integer.parseInt(splitComando[0]);
					boolean comprobarMovimiento = comprobarMovimiento(splitComando[1], numeroEspacios);
					if (splitComando[1].equals("N") && comprobarMovimiento) {
						posicionVehiculoColumna = posicionVehiculoColumna - numeroEspacios;
					} else if (splitComando[1].equals("S") && comprobarMovimiento) {
						posicionVehiculoColumna = posicionVehiculoColumna + numeroEspacios;
					} else if (splitComando[1].equals("E") && comprobarMovimiento) {
						posicionVehiculoFila = posicionVehiculoFila + numeroEspacios;
					} else if (splitComando[1].equals("O") && comprobarMovimiento) {
						posicionVehiculoFila = posicionVehiculoFila - numeroEspacios;
					} else if (comprobarMovimiento(splitComando[1], numeroEspacios) == false) {
						System.out
								.println("Se ha detenido el avance por  salir de los limites o el comando es invalido");
						i = comando.length;
					}
					System.out.println("el vehiculo se encuentra en la posicion:"
							+ matriz[posicionVehiculoFila][posicionVehiculoColumna] + '\n'
							+ "despues de aplicar el comando:" + splitComando[0] + "," + splitComando[1]);

				}
			} catch (Exception e) {
				System.out.println("Comando invalido");
			}
		}
		System.out.println("");

	}

	/*Metodo que comprueba si un movimiento es realizado de manera correcta es decir si esta bien escrito o si cumple con los limites dados por la matriz*/
	public boolean comprobarMovimiento(String direccion, int numeroEspacios) {

		if (direccion.equals("N") && (posicionVehiculoColumna - numeroEspacios) > -1
				&& (posicionVehiculoColumna - numeroEspacios) < numeroColumnas) {
			return true;
		} else if (direccion.equals("S") && (posicionVehiculoColumna + numeroEspacios) > -1
				&& (posicionVehiculoColumna + numeroEspacios) < numeroColumnas) {
			return true;
		} else if (direccion.equals("E") && (posicionVehiculoFila + numeroEspacios) > -1
				&& ((posicionVehiculoFila + numeroEspacios) < numeroFilas)) {

			return true;
		} else if (direccion.equals("O") && (posicionVehiculoFila - numeroEspacios) > -1
				&& (posicionVehiculoFila - numeroEspacios) < numeroFilas) {
			return true;
		} else {
			return false;
		}

	}

	/*Metodo que permite introducir el numero de filas por consola*/
	public void introducirNumeroFilas() throws NumberFormatException, IOException {
		System.out.println("Introduzca numero de filas:");
		BufferedReader entradafilas = new BufferedReader(new InputStreamReader(System.in));
		numeroFilas = Integer.parseInt(entradafilas.readLine());

	}

	/*Metodo que permite introducir el numero de columnas por consola*/
	public void introducirNumeroColumnas() throws NumberFormatException, IOException {
		System.out.println("Introduzca numero de columnas:");
		BufferedReader entradacolumnas = new BufferedReader(new InputStreamReader(System.in));
		numeroColumnas = Integer.parseInt(entradacolumnas.readLine());
	}

}
