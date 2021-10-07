/*
Escriba un programa que defina una matriz de enteros de tamaño 10x10.
Inicialice la matriz con números aleatorios entre 0 y 200.

Luego realice las siguientes operaciones:

1)Mostrar el contenido de la matriz en consola.
2)Calcular e informar la suma de todos los elementos almacenados entre las filas 2 y 9 y las columnas 0 y 3.
3)Generar un vector de 10 posiciones donde cada posición i contiene la suma de los elementos de la columna i de la matriz.
4)Lea un valor entero e indique si se encuentra o no en la matriz. En caso de
encontrarse indique su ubicación (fila y columna) en caso contrario imprima “No se encontró el elemento”.

 */
package CARO_ALONSO.practica_2;

import PaqueteLectura.GeneradorAleatorio;

public class tp2punto4 {

    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();

        final int dimf = 10;
        final int F = 10;
        final int C = 10;

        int vector[] = new int[dimf];
        int matriz[][] = new int[F][C];

        for (int i = 0; i < dimf; i++) { // inicializacion vector cero
            vector[i] = 0;
        }

        
        for (int i = 0; i < F; i++) { // inicializacion matriz cero
            for (int j = 0; j < C; j++) {
                matriz[i][j] = 0;
            }
        }

        
        for (int i = 0; i < F; i++) { // cargo datos al vector
            for (int j = 0; j < C; j++) {
                matriz[i][j] = GeneradorAleatorio.generarInt(201); //0 a 200.
            }
        }
        

        System.out.println("---- Elementos de la matriz: -----"); // punto 1
        System.out.println(" ");
        for (int i = 0; i < F; i++) {
            for (int j = 0; j < C; j++) {
                System.out.println("Elemento de la fila " + i + " columna " + j + ": " + matriz[i][j]);
            }
        }
        System.out.println(" ");
        System.out.println("---------------------------------------");

        
        int suma=0; //punto 2
        for (int i = 2; i < F; i++) {  
            for (int j = 0; j < 4; j++) {
                  suma = suma + matriz[i][j];               
            }
        }
        System.out.println("suma del contenido de todos los elementos con fila entre 2 y 9, y columnas entre 0 y 3 : " + suma);
        System.out.println("---------------------------------------------------------");
        
        
        for (int i = 0; i < C; i++) { //punto 3
            int suma_por_columa=0;
            for (int j = 0; j < F; j++) {
              suma_por_columa=suma_por_columa + matriz[i][j];
            }
            vector[i]=suma_por_columa;
        }
        
       
        int num=GeneradorAleatorio.generarInt(201); // 0 a 200  punto 4
        boolean cumple=false;
        int pos_f=0;
        int pos_c;
        while (cumple==false && pos_f < F) {            
          pos_c=0;  
          while (cumple==false && pos_c < C) {            
              if (matriz[pos_f][pos_c] == num) {
                 cumple=true;
                 System.out.println("el numero ingresado se encontro en la fila: " + pos_f + " y columna: "+ pos_c); 
              }
            pos_c++;
          }    
          pos_f ++;
        }
        if (cumple==false) {
            System.out.println("No se encontro el numero :"+ num +" en la matriz"); 
            System.out.println("---------------------------------------");
        }             
        
    }

}
