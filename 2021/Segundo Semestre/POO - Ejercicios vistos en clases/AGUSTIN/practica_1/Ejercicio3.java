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
public class Ejercicio3 {

    /*Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
    básquet y las almacene en un vector. Luego informe:
    - la altura promedio
    - la cantidad de jugadores con altura por encima del promedio
     */
 /*
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] contador = new int[15];
        int DIMF = 15;
        double prom = 0;
        int PorEncimaDelProm = 0;
        for (int i = 1; i < DIMF; i++) {
            System.out.println("Escriba la altura del jugador");
            contador[i] = Lector.leerInt();
            prom = prom + contador[i];      //lo ideal seria no procesar mientras se hace la carga
        }
        prom = prom / DIMF;
        for (int j = 1; j < DIMF; j++) {
            if (contador[j] > prom) {
                PorEncimaDelProm++;
            }

        }
        System.out.println("El promedio es: " + prom);
        System.out.println("La cantidad de jugadores por encima del promedio es de: " + PorEncimaDelProm);
    }

}
