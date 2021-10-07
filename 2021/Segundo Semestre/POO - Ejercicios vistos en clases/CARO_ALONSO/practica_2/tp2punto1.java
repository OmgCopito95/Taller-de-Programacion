/*
Escriba un programa que imprima en consola el factorial de un número N
(ingresado por teclado, N > 0). Ejemplo: para N=5 debería imprimir 5! = 120
 */

package CARO_ALONSO.practica_2;

import PaqueteLectura.Lector;

public class tp2punto1 {

    public static void main(String[] args) {

        System.out.println("ingrese un numero : ");

        int num = Lector.leerInt();
        int numero_imprimir = num;
        int factorial = 1;

        while (num != 0) {      //PODRIA USAR UN FOR
            factorial = factorial * num;
            num = num - 1;
        }
        System.out.println("el numero factorial de " + numero_imprimir + " es : " + factorial);
    }
}
