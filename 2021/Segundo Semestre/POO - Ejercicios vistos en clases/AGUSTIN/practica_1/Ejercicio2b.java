/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGUSTIN.practica_1;

import PaqueteLectura.Lector;

/**
 *
 * @author Peirano-PC
 */
public class Ejercicio2b {

    /**
     * Escriba un programa que imprima en consola el factorial de todos los
     * números entre 1 y 9. ¿Qué modificación debe hacer para imprimir el
     * factorial de los números impares solamente?
     */
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Ingrese la cantidad de numeros para factoriar");
        int CantNum = Lector.leerInt();

        for (int i = 1; i <= CantNum; i++) {
            if (i % 2 != 0) { //o sumando en el for de a dos
                int aux = 1;
                for (int j = 1; j <= i; j++) {
                    aux = aux * j;
                }
                System.out.println("El factorial es: " + aux);
            }
        }

    }

}
