/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGUSTIN.practica_1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/**
 *
 * @author Peirano-PC
 */
public class Ejercicio4 {

    /**
     * @param args the command line arguments
     */
    /*
    4- Escriba un programa que defina una matriz de enteros de tamaño 10x10.
        Inicialice la matriz con números aleatorios entre 0 y 200.
        Luego realice las siguientes operaciones:
          - Mostrar el contenido de la matriz en consola.
            - Calcular e informar la suma de todos los elementos almacenados entre las
                filas 2 y 9 y las columnas 0 y 3
            - Generar un vector de 10 posiciones donde cada posición i contiene la suma
                de los elementos de la columna i de la matriz.
            - Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
                encontrarse indique su ubicación (fila y columna) en caso contrario
                imprima “No se encontró el elemento”
    
     */
    public static void main(String[] args) {

        //CREAR Y GENERAR MATRIZ//
        int[][] matrix = new int[10][10];
        int i, j; // i & j son las casillas del vector
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                matrix[i][j] = GeneradorAleatorio.generarInt(200);
            }
        }

        // IMPRIMIR MATRIZ//
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {
                System.out.println("Para la posicion: " + i + " y " + j + " " + matrix[i][j]);
            }
        }

        // SUMAR MATRIZ // 
        int suma = 0;

        for (i = 2; i <= 9; i++) {
            for (j = 0; j <= 3; j++) {
                suma = suma + matrix[i][j];
            }
        }
        System.out.println("La suma total entre las filas 2 a 9 y columnas 0 a 3 es de: " + suma);

        // Guardar en Vector // 
        int Vec[] = new int[10];
        int suma2;
        for (i = 0; i < 10; i++) {
            suma2 = 0;
            for (j = 0; j < 10; j++) {
                suma2 = suma2 + matrix[j][i];
            }
            Vec[i] = suma2;
        }
        for (int v = 0; v < 10; v++) {
            System.out.println(Vec[v]);
        }

        //BUSCAR VALOR EN MATRIZ//
        System.out.println("Elija el numero a buscar en la Matriz: ");
        int busca = Lector.leerInt();
        boolean encontro = false;
        int p = -1;
        int q = -1;
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 10; j++) {      //cuando se encuentra el valor deberia cortar!
                if (matrix[i][j] == busca) {
                    encontro = true;
                    p = i;
                    q = j;
                }
            }
        }
        if (encontro) {
            System.out.println("Se encontro el numero " + busca + " en la posicion: " + p + " " + q);
        } else {
            System.out.println("No se encontró el elemento");
        }
    }
}
