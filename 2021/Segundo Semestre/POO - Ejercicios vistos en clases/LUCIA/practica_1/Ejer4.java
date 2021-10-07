package LUCIA.practica_1;

/* Escriba un programa que defina una matriz de enteros de tamaño 10x10.
Inicialice la matriz con números aleatorios entre 0 y 200.
Luego realice las siguientes operaciones:

A) Mostrar el contenido de la matriz en consola.

B) Calcular e informar la suma de todos los elementos almacenados entre las
filas 2 y 9 y las columnas 0 y 3

C) Generar un vector de 10 posiciones donde cada posición i contiene la suma
de los elementos de la columna i de la matriz.

D) Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario
imprima “No se encontró el elemento” */

import PaqueteLectura.GeneradorAleatorio;
import PaqueteLectura.Lector;

public class Ejer4 {

    public static void main(String[] args) {
        int i;

        int j;

        boolean encontre = false;

        int dimF = 10;

        int dimC = 10;

        int[][] matriz = new int[dimF][dimC];

        int[] vector = new int[10];

        int sumar = 0;

        for (i = 0; i < 10; i++) {      //fila
            for (j = 0; j < 10; j++) {  //columna
                int num = GeneradorAleatorio.generarInt(200);
                matriz[i][j] = num;
            }
        }

        //=========== INCISO A ===========//
        for (i = 0; i < 10; i++) {          //fila
            for (j = 0; j < 10; j++) {     //columna
                System.out.print(matriz[i][j]);
                System.out.print(" ");
            }
            System.out.println("");
        }
        
        //=========== INCISO B ===========// 
        int suma=0;
        
        for (i=0; i<2; i++){  //fila
            for(j=0; j<4; j++){  //columna
                suma= suma + matriz[i][j];
            }            
        }
        for(i=2; i<10; i++){     //fila 2 a 9
            for(j=0; j<10; j++){  //columna --> para imprimir toda la fila de 2 a 9
                suma= suma + matriz[i][j];
            }
        }
        System.out.println("Ls suma de los elementos de las filas 2 y 9 Y columnas 0 y 3 es: "+suma);
                
        
        //=========== INCISO C ===========// 
        for (i=0; i<10; i++){     //INICIALIZO EL VECTOR
             vector[i]= 0;
            }
        
        for (i = 0; i < 10; i++) {        //fila
            for (j = 0; j < 10; j++) {   //columna
                vector[i] = vector[i] + matriz[j][i];                 
            }
            //System.out.println("la suma de la columna "+i+" es "+vector[i]);
        }
    
        //=========== INCISO D ===========// 
        i = 0;

        System.out.println("Ingrese un numero");
        int num = Lector.leerInt();
        while ((i < 10) && (!encontre)) {   //fila
            j = 0;  //inicializa en 0 la columna
            while ((j < 10) && (!encontre)) {   //columna
                if (num == matriz[i][j]) {
                    System.out.println("Se encontro el numero buscado en la posicion [" + i + "][" + j + "]");
                    encontre = true;
                }
                j++;   //agrega en uno la columna
            }
            i++;      //agrega en uno la fila
        }
        if (!encontre) {
            System.out.println("No existe el valor en la matriz");
        }

    }
}
