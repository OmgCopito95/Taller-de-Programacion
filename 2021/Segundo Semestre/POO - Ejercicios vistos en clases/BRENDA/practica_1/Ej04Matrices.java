/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRENDA.practica_1;

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

/* Escriba un programa que defina una matriz de enteros de tamaño 10x10.
Inicialice la matriz con números aleatorios entre 0 y 200.
Luego realice las siguientes operaciones:
- Mostrar el contenido de la matriz en consola.
- Calcular e informar la suma de todos los elementos almacenados entre las
filas 2 y 9 y las columnas 0 y 3
- Generar un vector de 10 posiciones donde cada posición i contiene la suma
de los elementos de la columna i de la matriz.
- Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento”. */
public class Ej04Matrices {

    public static void main(String[] args) {

        //1. definir la matriz de enteros de tamaño 10x10 e iniciarla con números aleatorios entre 0 y 200
        final int dimF = 10;
        int[][] numeros = new int[dimF][dimF];

        GeneradorAleatorio.iniciar();

        for (int i = 0; i < dimF; i++) {
            for (int j = 0; j < dimF; j++) {
                numeros[i][j] = GeneradorAleatorio.generarInt(200);
            }
        }

        //2. mostrar el contenido de la matriz en consola
        for (int i = 0; i < dimF; i++) {
            for (int j = 0; j < dimF; j++) {
                System.out.println("Fila " + i + ", Columna " + j + ": " + numeros[i][j]);
            }
        }

        //3. calcular e informar la suma de todos los elementos almacenados entre las filas 2 y 9 y las columnas 0 y 3
        int suma = 0;

        for (int i = 2; i < dimF; i++) {
            for (int j = 0; j <= 3; j++) {
                suma +=numeros[i][j];
            }
        }
        System.out.println("La suma de todos los elementos almacenados entre las filas 2 y 9 y las columnas 0 y 3 es: " + suma);

        //4. generar un vector de 10 posiciones donde cada posición i contiene la suma de la columna i de la matriz 
        int[] sumaColumnas = new int[dimF];

        for (int j = 0; j < dimF; j++) {
            int sumaColumna = 0;
            for (int i = 0; i < dimF; i++) {
                sumaColumna +=numeros[i][j];
            }
            sumaColumnas[j] = sumaColumna;
            System.out.println("La suma de la columna " + j + " es: " + sumaColumna);
        }

        //5. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
        //   y en caso contrario imprima "No se encontró el elemento".
        System.out.println("Ingrese el numero que desea buscar en la matriz: ");
        int buscado = Lector.leerInt();
        boolean encontre = false;

        for (int i = 0; i < dimF && !encontre; i++) {           //USAR UN WHILE Y NO UN FOR CON CORTE
            for (int j = 0; j < dimF && !encontre; j++) {
                if (numeros[i][j] == buscado) {
                    System.out.println("El numero " + buscado + " se encuentra en la fila " + i + ", columna " + j);
                    encontre = true;
                }
            }
        }
        if (!encontre) {
            System.out.println("No se encontro el elemento.");
        }
    }
}
