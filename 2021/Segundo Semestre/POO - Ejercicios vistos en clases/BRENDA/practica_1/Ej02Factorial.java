/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRENDA.practica_1;

/* Escriba un programa que imprima en consola el factorial de todos los números
entre 1 y 9. ¿Qué modificación debe hacer para imprimir el factorial de los
números impares solamente?
 */
public class Ej02Factorial {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        final int max = 9;
        int num;

        System.out.println("Factorial de todos los numeros entre 1 y 9:");
        
                   
        for (num = 1; num <= max; num++) {
            int factorial = 1; // inicializo factorial en 1 con cada vuelta del for
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
            System.out.println(num + "! = " + factorial);
        }

        // Modificacion para impares
        System.out.println("Factorial de todos los impares entre 1 y 9:");
        for (num = 1; num <= max; num = num + 2) {
            int factorial = 1; // inicializo factorial en 1 con cada vuelta del for
            for (int i = 1; i <= num; i++) {
                factorial = factorial * i;
            }
            System.out.println(num + "! = " + factorial);
        }
    }
}
