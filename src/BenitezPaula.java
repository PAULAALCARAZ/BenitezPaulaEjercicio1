import java.util.Scanner;

public class BenitezPaula {
    public static void main (String [] args){
        Scanner sc= new Scanner(System.in);

        int [][] matriz; //declaramos la matriz para el juego.
        int numFilas; //declaramos variable para las filas que el usuario ira inserir
        int numColumnas; //declaramos la variable para las colummnas que el usuario ira inserir.
        int x, y; //variable coordenadas


        boolean salir = false;  //declaramos boolean.

        System.out.println("Hola! bienvenido al juego del Bomber Man \n" + "comencemos!");


        //ahora hacemos un bucle para pedir el numero de filas y validar que sea correcto.
        while (true) {
            System.out.print("Introduce el número de filas (recuerda que debe ser entero positivo): ");

            if (sc.hasNextInt()) { // aqui Verificamos si la entrada es un número entero la sintaxis "hasNextInt" que devuelve true si existe un siguiente elemento.

                numFilas = sc.nextInt(); //aqui leemos el numero introducido.

                if (numFilas > 0) {
                    break; // aqui sale del bucle si el número es válido

                } else { //de otra forma, error.

                    System.out.println("Error! Recuerda que el número debe ser mayor que 0.");
                }
            } else {

                System.out.println("Error!. Por favor, ingresa un número entero y positivo.");
                sc.next(); // leemos el nuevo el valor introducido.
            }
        }

        //ahora repetimos el bucle para las columnas.

        while (true) {
            System.out.print("Introduce el número de columnas (recuerda que debe ser entero positivo): ");

            if (sc.hasNextInt()) { // Verificamos si la entrada es un número entero (usando hasNextInt)

                numColumnas = sc.nextInt(); //aqui leemos el numero introducido.

                if (numColumnas > 0) {
                    break; // Salimos del bucle si el número es válido

                } else { //otra entrada, error.

                    System.out.println("Error! Recuerda que el número debe ser mayor que 0.");
                }
            } else {

                System.out.println("Error!. Por favor, ingresa un número entero y positivo.");
                sc.next(); // leemos el nuevo el valor introducido.
            }
        }

        //ahora vamos a crear la matriz rellenando las casillas con numeros aleatorios de 1 a 9.

        matriz = new int[numFilas][numColumnas]; //inicializamos la matriz que declaramos al inicio y determinamos su valor.

        for (int i =0; i < numFilas; i++){
            for (int j=0; j<numColumnas;j++){  //aqui hacemos contadores para recorrer fila y colummna.
                matriz[i][j]= (int) (Math.random() * 9) + 1;  //aqui determinamos el rango, que este entre 1 y 9.
            }
        }

        //para el menú del juego, unimos el "swich case" con el "while" para control de errores.

        while (!salir){ //mientras sea diferente de salir, repetimos.
            System.out.println("Elige una de estas opciones");
            System.out.println("[0] Salir");
            System.out.println("[1] Mostrar la Matriz");
            System.out.println("[2] Poner la bomba");
            int opcion = sc.nextInt(); //leemos el valor introducido, en este caso elegi que sea un entero en lugar de cadena de texto.

            switch (opcion) {
                case 0:
                    salir = true;
                    System.out.println("Haz elegido la opción Salir \n" + "Hasta luego!"); //la "\n" es para saltar a la linea de abajo
                    break;

                case 1:
                    for (int i = 0; i < numFilas; i++) {
                        for (int j = 0; j < numColumnas; j++) {
                            System.out.print(matriz[i][j] + " "); //apenas "print" para que no salte las lineas.
                        }
                        System.out.println();
                    }
                    break;

                case 2:

                    System.out.println("Para poner la bomba necesitaremos coordenadas X & Y (fila y colummna: ");

                    while (true) { //haremos un control de errores.
                        System.out.print("Introduce la coordenada de la fila (x): ");
                        if (sc.hasNextInt()) { // aqui verificamos si el valor introducido es un entero
                            x = sc.nextInt() - 1; // "-1" para ajustar el índice de la  matriz

                            if (x >= 0 && x < numFilas) {
                                break; // comprovamos si el valor está dentro del rango.
                            } else {
                                System.out.println("Error de Coordenada. El numero debe ser entre 1 y " + numFilas + ".");
                            }
                        } else {
                            System.out.println("Error. Por favor, introduce un número entero.");
                            sc.next(); // leemos la nueva entrada.
                        }
                    }

                    while (true) { //validamos coordenadas Y.
                        System.out.print("Introduce la coordenada de la columna (y): ");
                        if (sc.hasNextInt()) { // nuevamente verificamos si el valor introducido es un entero
                            y = sc.nextInt() - 1; // "-1" para ajustar el índice de la  matriz

                            if (y >= 0 && y < numColumnas) {
                                break; // comprovamos si el valor está dentro del rango.
                            } else {
                                System.out.println("Error de Coordenada. El numero debe ser entre 1 y " + numColumnas + ".");
                            }
                        } else {
                            System.out.println("Error. Por favor, introduce un número entero.");
                            sc.next(); // leemos la nueva entrada.
                        }
                    }

                    //ahora calcularemos el valor de la explosión.

                    int explosion = 0; //creamos e inicializamos variable.
                    for (int j = 0; j < numColumnas; j++) {
                        explosion += matriz[x][j]; //sumamos los valores de la fila y almacenamos en la variable.
                    }
                    for (int i = 0; i < numFilas; i++) {
                        explosion += matriz[i][y]; //sumamos valores de la columnna y almacenamos.
                    }
                    explosion -= matriz[x][y];

                    System.out.println("El valor de la explosión es: " + explosion);

                    //aqui convertiremos las casillas afectadas en 0.

                    for (int j= 0; j < numColumnas; j++) {
                        matriz[x][j] = 0;
                    }
                    for (int i=0; i< numFilas; i++){
                        matriz[i][y]= 0;
                    }

                    //por ultimo comprovamos que la matriz esté vacia.
                    boolean matrizVacia = true; //iniciamos variable.
                    for (int i=0; i< numFilas; i++){
                        for (int j=0; j<numColumnas; j++){
                            if (matriz[i][j] !=0){
                                matrizVacia= false;
                                break;
                            }
                        }
                        if (!matrizVacia)break;

                    }
                    if (matrizVacia){ //si la matriz está vacia termina el juego
                        System.out.println("La matriz está vacia, fin del juego.");
                        salir= true;

                    }
                    break;

                default:
                    System.out.println("Error! Por favor, elige una opcion correcta. ");
                    break;

            }

        }

    }
}