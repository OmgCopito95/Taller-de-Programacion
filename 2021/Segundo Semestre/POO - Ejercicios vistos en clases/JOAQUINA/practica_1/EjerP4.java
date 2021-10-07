/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JOAQUINA.practica_1;

import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

public class EjerP4 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        /*Escriba un programa que defina una matriz de enteros de tamaño 10x10.
        Inicialice la matriz con números aleatorios entre 0 y 200.
        Luego realice las siguientes operaciones:
        - Mostrar el contenido de la matriz en consola.
        - Calcular e informar la suma de todos los elementos almacenados entre las
        filas 2 y 9 y las columnas 0 y 3
        - Generar un vector de 10 posiciones donde cada posición i contiene la suma
        de los elementos de la columna i de la matriz.
        - Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
        encontrarse indique su ubicación (fila y columna) en caso contrario
        imprima “No se encontró el elemento”.
        NOTA: Dispone de un esqueleto para este programa en Ej04Matrices.java*/
        int filas = 10, cols = 10, i, j;
        int[][] matrizEnteros;

        matrizEnteros = new int[filas][cols];

        for (i = 0; i < filas; i++) {        //llena la matriz con numeros random
            for (j = 0; j < cols; j++) {
                matrizEnteros[i][j] = GeneradorAleatorio.generarInt(10);
            }
        }

        for (i = 0; i < filas; i++) {         //muestra el contenido de la matriz
            for (j = 0; j < cols; j++) {
                System.out.println("contnido en la fila " + i + " columna " + j + ":   " + matrizEnteros[i][j]);
            }
        }

        int suma = 0;                    //suma los elementos de las columnas indicadas
        for (i = 2; i < filas; i++) {
            for (j = 0; j < 4; j++) {
                suma = suma + matrizEnteros[i][j];
            }
        }
        System.out.println("La suma de los elementos lmacenados entre las filas 2 y 9 y las columnas 0 y 3 es de : " + suma);

        int[] vectorSuma;         //genera un vector de 10 posiciones donde cada posición i contiene la suma de la columna i de la matriz 
        int k;
        vectorSuma = new int[10];
        for (k = 0; k < 10; k++) {
            int sumaCol = 0;
            for (j = 0; j < cols; j++) {
                sumaCol = sumaCol + matrizEnteros[k][j];
            }
            System.out.println("Suma de columna " + sumaCol);

            vectorSuma[k] = sumaCol;
        }

        boolean indicador = false; 
        int posi = 0, posj = 0;                                            // no me sale el ultimo punto.
        System.out.println("Ingrese un numero");
        int numE = Lector.leerInt();
        
        i = 0;
        j = 0;
        while (matrizEnteros[i][j] != numE) {       //REVISAR
            if (i < filas) {
                if (j < cols) {
                    if (numE == matrizEnteros[i][j]) {
                        indicador = true;
                        posi = i;
                        posj = j;
                    }
                    j++;
                } else {
                    j = 0;
                    i++;
                }
            }
        }
        if (indicador) {
            System.out.println("El valor entero " + numE + " se encuentra en la matriz en la fila " + posi + " columna " + posj);
        } else {
            System.out.println("El valor no se encuentra en la matriz");
        }

    }

}

//5. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
//   y en caso contrario imprima "No se encontró el elemento". 

