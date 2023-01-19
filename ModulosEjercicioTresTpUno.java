import java.util.Scanner;

public class ModulosEjercicioTresTpUno {

	// Este modulo permite al usuario elegir si quiere ingresar M x N o que sea
	// generado de forma aleatoria

	public static void Menu() {
		String valido = "S";
		while (valido == "S") {
			System.out.println("Seleccion de opciones:	");
			System.out.println("1- Ingresar filas y columnas de la Matriz");
			System.out.println("2- Matriz aleatoria");
			System.out.print("Elegir:  ");
			System.out.println();
			Scanner seleccion = new Scanner(System.in);
			Proceso(seleccion);
			Scanner seguir = new Scanner(System.in);
			System.out.println("Si desea continuar presione la letra S/s de lo contrario presione otra tecla");
			String seguirPrograma = seguir.nextLine();
			if (seguirPrograma.equalsIgnoreCase(valido)) {
				valido = "S";
			} else {
				valido = "N";
				System.out.println();
				System.out.println("FIN DEL PROGRAMA");
			}
			System.out.println("------------------------------------");

		}
	}

	// Este modulo, teniendo en cuenta la opción seleccionada en el menu, redirige
	// al usuario a los modulos correspondientes

	public static void Proceso(Scanner seleccion) {
		String elegida = seleccion.nextLine();
		if (ValidarNumero(elegida)) {
			int seleccionado = Integer.parseInt(elegida);
			if (seleccionado == 1)/* <--- Si el usuario selecciona la opción 1 */ {
				DimensionMatriz(seleccionado);
			} else if (seleccionado == 2)/* <--- Si el usuario selecciona la opción 2 */ {
				DimensionMatriz(seleccionado);
			} else {
				System.out.println("Seleccion no valida");
			}
		} else {
			System.out.println("Seleccion no valida");
		}

	}

	// Con este Modulo, verificamos si el valor ingresado es un número o no

	public static boolean ValidarNumero(String numero) {
		int numValidar;
		try {
			numValidar = Integer.parseInt(numero);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// Si el usuario selecciono la opcion Nro 1 en "Menu();", se usará este modulo
	// para pedir y verificar que M x N sea valido

	public static void DimensionMatriz(int seleccionado) {
		String filas/* <-- (input) */, columnas/* <-- (input2) */;
		int inicializarFilas = 0, inicializarColumnas = 0, filasFinales = 0, columnasFinales = 0;
		Scanner input = new Scanner(System.in);
		while (inicializarFilas == 0) {
			System.out.println();
			System.out.println("Ingresar numero de filas:	");
			filas = input.nextLine();
			if (ValidarNumero(filas)) {
				int filasElegidas = Integer.parseInt(filas);
				inicializarFilas = 1;
				if (filasElegidas <= 0) {
					System.out.println("La cantidad de filas es invalida");
					inicializarFilas = 0;
				} else {
					inicializarFilas = 1;
					filasFinales = filasElegidas;
				}
			} else {
				System.out.println("Valor ingresado, no valido");
				inicializarFilas = 0;
			}
		}
		Scanner input2 = new Scanner(System.in);
		while (inicializarColumnas == 0) {
			System.out.println();
			System.out.println("Ingresar numero de columnas:	");
			columnas = input2.nextLine();
			if (ValidarNumero(columnas)) {
				int columnasElegidas = Integer.parseInt(columnas);
				inicializarColumnas = 1;
				if (columnasElegidas <= 0) {
					System.out.println("La cantidad de columnas es invalida");
					inicializarColumnas = 0;
				} else {
					inicializarColumnas = 1;
					columnasFinales = columnasElegidas;
				}
			} else {
				System.out.println("Valor ingresado, no valido");
				inicializarColumnas = 0;
			}
		}
		ArgumentosDeLaMatriz(filasFinales, columnasFinales, seleccionado);
	}

	// Dependiendo de si el usuario quiere ingresar o crear de forma aleatorias los
	// elementos, hace la acción correspondiente

	public static void ArgumentosDeLaMatriz(int filasFinales, int columnasFinales, int seleccionado) {
		String matriz[][] = new String[filasFinales][columnasFinales];
		Scanner numero = new Scanner(System.in);
		if (seleccionado == 1) { /* <--- Si el usuario selecciona la opción 1 */
			for (int i = 0; i < filasFinales; i++) {
				for (int j = 0; j < columnasFinales; j++) {
					int inicializar = 0;
					System.out.println();
					while (inicializar == 0) {
						System.out.println("Fila: " + (i + 1) + ", Columna: " + (j + 1));
						String elementos = numero.nextLine();
						if (ValidarNumero(elementos)) {
							inicializar = 1;
							matriz[i][j] = elementos;
						} else {
							System.out.println("El valor ingresado, no es un numero");
							inicializar = 0;
						}
					}
				}
				System.out.println();
			}
		} else if (seleccionado == 2) { /* <--- Si el usuario selecciona la opción 2 */
			for (int i = 0; i < filasFinales; i++) {
				for (int j = 0; j < columnasFinales; j++) {
					int elementos = Random();
					String newElementos = Integer.toString(elementos);
					matriz[i][j] = newElementos;
				}

			}
		}
		// Muestra en consola la Matriz Creada
		System.out.println();
		System.out.println("Matriz Creada:	");
		for (int t = 0; t < filasFinales; t++) {
			for (int k = 0; k < columnasFinales; k++) {
				System.out.print(matriz[t][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
		Transpuesta(matriz, filasFinales, columnasFinales);
	}

	// Este Modulo se encarga de crear la Matriz Transpuesta luego de que se creara
	// la matriz

	public static void Transpuesta(String[][] matriz, int filasFinales, int columnasFinales) {
		String matrizTranspuesta[][] = new String[columnasFinales][filasFinales];
		for (int i = 0; i < columnasFinales; i++) {
			for (int j = 0; j < filasFinales; j++) {
				matrizTranspuesta[i][j] = matriz[j][i];
			}
		}
		// Muestra la Matriz Transpuesta
		System.out.println("Matriz Transpuesta:	");
		for (int t = 0; t < columnasFinales; t++) {
			for (int k = 0; k < filasFinales; k++) {
				System.out.print(matrizTranspuesta[t][k] + " ");
			}
			System.out.println();
		}
		System.out.println();
		SeleccionDeMatriz(matriz, matrizTranspuesta, filasFinales, columnasFinales);
	}

	// Este Modulo, por medio de un Menu permite al usuario elegir si quiere
	// trabajar con la Matriz Creada o la Matriz Transpuesta

	public static void SeleccionDeMatriz(String matriz[][], String matrizTranspuesta[][], int filasFinales,
			int columnasFinales) {
		int inicializar = 0;
		while (inicializar == 0) {
			System.out.println("Seleccionar Matriz a Trabajar:	");
			System.out.println("1- Trabajar con la Matriz creada");
			System.out.println("2- Trabajar con la Matriz Transpuesta");
			System.out.print("Elegir:  ");
			System.out.println();
			Scanner seleccionMatriz = new Scanner(System.in);
			if (ProcesoDeMatriz(seleccionMatriz, matriz, matrizTranspuesta, filasFinales, columnasFinales)) {
				inicializar = 1;
			} else {
				inicializar = 0;
			}
		}

	}

	// Teniendo en cuenta la opción seleccionada en SeleccionDeMatriz(..., ...,
	// etc...);
	// redirige al usuario a los modulos correspondientes

	public static boolean ProcesoDeMatriz(Scanner seleccionDeMatriz, String matriz[][], String matrizTranspuesta[][],
			int filasFinales, int columnasFinales) {
		String matrizElegida = seleccionDeMatriz.nextLine();
		System.out.println();
		if (ValidarNumero(matrizElegida)) {
			int seleccionado = Integer.parseInt(matrizElegida);
			if (seleccionado == 1) {
				SumarOMultiplicarMenu(matriz, filasFinales, columnasFinales, Integer.parseInt(matrizElegida));
				return true;
			} else if (seleccionado == 2) {
				SumarOMultiplicarMenu(matrizTranspuesta, filasFinales, columnasFinales,
						Integer.parseInt(matrizElegida));
				return true;
			} else {
				System.out.println("Seleccion no valida");
				return false;
			}
		} else {
			System.out.println("Seleccion no valida");
			return false;
		}

	}

	// Este Modulo por medio de un Menu, permite al usuario elegir si quiere sumar
	// los elementos de una columna o multiplicar los elementos de una fila

	public static void SumarOMultiplicarMenu(String MatrizSeleccionada[][], int filasFinales, int columnasFinales,
			int matrizElegida) {
		int inicializar = 0;
		while (inicializar == 0) {
			System.out.println(
					"Seleccionar si desea Sumar los elementos de una Columna o Multiplicar los elementos de una Fila:	");
			System.out.println("1- Suma de los elementos de una Columna");
			System.out.println("2- Multiplicacion de los elementos de una fila");
			System.out.print("Elegir:  ");
			System.out.println();
			Scanner seleccionSumaOMultiplicacion = new Scanner(System.in);
			if (ProcesoFinal(seleccionSumaOMultiplicacion, filasFinales, columnasFinales, MatrizSeleccionada,
					matrizElegida)) {
				inicializar = 1;
			} else {
				inicializar = 0;
			}
		}
	}

	// Teniendo en cuenta la opción seleccionada en SumarOMultiplicarMenu(..., ...,
	// etc...);
	// realiza los calculos correspondientes, teniendo en cuenta con que Matriz se
	// decidio trabajar

	public static boolean ProcesoFinal(Scanner seleccionSumaOMultiplicacion, int filasFinales, int columnasFinales,
			String MatrizSeleccionada[][], int matrizElegida) {
		String sumaOMultiplicacion = seleccionSumaOMultiplicacion.nextLine();
		if (ValidarNumero(sumaOMultiplicacion)) {
			int seleccionado = Integer.parseInt(sumaOMultiplicacion);
			if (seleccionado == 1) {
				int sumador = 0, inicializador = 0;
				Scanner columna = new Scanner(System.in);
				while (inicializador == 0) {
					System.out.println("Ingresar Columna a Sumar:	");
					String columnaSeleccionada = columna.nextLine();
					System.out.println();
					if (ValidarNumero(columnaSeleccionada)) {
						int columnaSeleccionadaInt = Integer.parseInt(columnaSeleccionada);
						if ((columnaSeleccionadaInt > 0 && columnaSeleccionadaInt <= columnasFinales)
								&& matrizElegida == 1) {
							inicializador = 1;
							for (int i = 0; i < filasFinales; i++) {
								sumador = sumador + Integer.parseInt(MatrizSeleccionada[i][columnaSeleccionadaInt - 1]);
							}
							System.out.println("El resultado de la Suma es: " + sumador);
							System.out.println();
						} else if ((columnaSeleccionadaInt > 0 && columnaSeleccionadaInt <= filasFinales)
								&& matrizElegida == 2) {
							inicializador = 1;
							for (int i = 0; i < columnasFinales; i++) {
								sumador = sumador + Integer.parseInt(MatrizSeleccionada[i][columnaSeleccionadaInt - 1]);
							}
							System.out.println("El resultado de la Suma es: " + sumador);
							System.out.println();
						} else {
							System.out.println("Columna seleccionada, no valida");

						}
					} else {
						System.out.println("Columna seleccionada, no valida");
					}
				}
				return true;
			} else if (seleccionado == 2) {
				int multiplicador = 1, inicializador = 0;
				Scanner fila = new Scanner(System.in);
				while (inicializador == 0) {
					System.out.println("Ingresar Fila a Multiplicar:	");
					String filaSeleccionada = fila.nextLine();
					System.out.println();
					if (ValidarNumero(filaSeleccionada)) {
						int filaSeleccionadaInt = Integer.parseInt(filaSeleccionada);
						if ((filaSeleccionadaInt > 0 && filaSeleccionadaInt <= filasFinales) && matrizElegida == 1) {
							inicializador = 1;
							for (int i = 0; i < columnasFinales; i++) {
								multiplicador = multiplicador
										* Integer.parseInt(MatrizSeleccionada[filaSeleccionadaInt - 1][i]);
							}
							System.out.println("El resultado de la Multiplicacion es: " + multiplicador);
							System.out.println();
						} else if ((filaSeleccionadaInt > 0 && filaSeleccionadaInt <= columnasFinales)
								&& matrizElegida == 2) {
							inicializador = 1;
							for (int i = 0; i < filasFinales; i++) {
								multiplicador = multiplicador
										* Integer.parseInt(MatrizSeleccionada[filaSeleccionadaInt - 1][i]);
							}
							System.out.println("El resultado de la Multiplicacion es: " + multiplicador);
							System.out.println();
						} else {
							System.out.println("Fila seleccionada, no valida");
						}
					} else {
						System.out.println("Fila seleccionada, no valida");
					}
				}
				return true;
			} else {
				System.out.println("Seleccion no valida");
				return false;
			}
		} else {
			System.out.println("Seleccion no valida");
			return false;
		}
	}

	// Este modulo se encarga de crear números random del 1 al 10
	// (Este limite se puso por motivos practicos, ya que permite al usuario ver
	// operaciones en consola de manera entendible y ordenada)

	public static int Random() {
		double aleatorio = (double) Math.random() * 10;
		int random = (int) aleatorio;
		if (random == 0) {
			return (random + 1);
		}
		return random;
	}

}
