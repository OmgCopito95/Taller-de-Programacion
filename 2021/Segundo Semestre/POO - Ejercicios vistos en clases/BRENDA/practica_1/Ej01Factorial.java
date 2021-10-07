/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRENDA.practica_1;

import PaqueteLectura.Lector;

/* Escriba un programa que imprima en consola el factorial de un número N
(ingresado por teclado, N > 0). Ejemplo: para N=5 debería imprimir 5! = 120
 */
public class Ej01Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        System.out.println("Ingrese un numero mayor a 0: ");
        int numero = Lector.leerInt();  // pido numero por consola

        int factorial = 1; // inicializo factorial en 1

        if (numero > 0) {
            for (int i = 1; i <= numero; i++) {
                factorial = factorial * i;
            }
            System.out.println(numero + "! = " + factorial);
            
        } else {
            System.out.println("Usted ingreso un numero fuera de los limites solicitados");
        }
    }
}
