package CARO_SANTA_MARIA.practica_1;
import PaqueteLectura.Lector;
import PaqueteLectura.GeneradorAleatorio;

/*
Escriba un programa que defina una matriz de enteros de tamaño 10x10.
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
*/

public class Ej04Matrices {

    public static void main(String[] args) {
    //1. definir la matriz de enteros de tamaño 10x10 e iniciarla con números aleatorios entre 0 y 200 
    int [][] matriz = new int[10][10];
    for (int i = 0; i <= 9; i++) {
        for (int j = 0; j <= 9; j++) {
            matriz[i][j] = GeneradorAleatorio.generarInt(201);
        }
    }
    //2. mostrar el contenido de la matriz en consola
     for (int i = 0; i <= 9; i++) {
        for (int j = 0; j <= 9; j++) {
            System.out.println("Fila " + i + " Col " + j + ": " + matriz[i][j]);
        }
    }
    //3. calcular e informar la suma de todos los elementos almacenados entre las filas 2 y 9 y las columnas 0 y 3
    int suma = 0;
    for (int i = 2; i <= 9; i++) {
        for (int j = 0; j <= 3; j++) {
            suma = suma + matriz[i][j];
        }
    }
    System.out.println("La suma de los elementos entre las filas 2 y 9 y las columnas 0 y 3: " + suma);
    //4. generar un vector de 10 posiciones donde cada posición i contiene la suma de la columna i de la matriz 
    int [] sumaCol = new int[10];
    for (int i = 0; i <= 9; i++) {
        sumaCol[i] = 0;
    }
    for (int i = 0; i <= 9; i++) {
        for (int j = 0; j <= 9; j++) {
            sumaCol[i] = sumaCol[i] + matriz[j][i];
        }
    }
    //5. lea un valor entero e indique si se encuentra o no en la matriz. En caso de encontrarse indique su ubicación (fila y columna)
    //   y en caso contrario imprima "No se encontró el elemento".
        System.out.print("Ingrese un número para buscar en la matriz: ");
        int num = Lector.leerInt();
        boolean encontre = false;           //DEBERIA CORTAR CUANDO ENCUENTRA EL DATO
        for (int i = 0; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                if (matriz[i][j] == num) {
                    encontre = true;
                    System.out.println("En la fila " + i + ", col " + j + " se encuentra " + num);
                }
            }
        }
        if (encontre == false) {
            System.out.println("No se encontró el elemento");
        }
    }
}
