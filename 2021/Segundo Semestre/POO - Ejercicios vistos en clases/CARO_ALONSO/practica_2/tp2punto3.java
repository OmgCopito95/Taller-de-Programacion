/*
Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio.

NOTA: Dispone de un esqueleto para este programa en Ej03Jugadores.java

 */
package CARO_ALONSO.practica_2;

import PaqueteLectura.GeneradorAleatorio;

public class tp2punto3 {

    public static void main(String[] args) {

        GeneradorAleatorio.iniciar();// iniciador de generador aleatorio

        final int dimf = 15;

        double[] vector = new double[dimf];

        for (int i = 0; i < dimf; i++) {  // iniicalizo el vector en cero 
            vector[i] = 0;
        }

        for (int i = 0; i < dimf; i++) {  // iniicalizo el vector en cero 
            vector[i] = GeneradorAleatorio.generarDouble(3); // carga de alturas
        }

        double contador = 0;
        for (int i = 0; i < dimf; i++) {  // contador total de alturas 
            contador = contador + vector[i];
        }

        double promedio = (contador / dimf);
        System.out.println("altura promedio :" + String.format("%.2f", promedio));

        int contador_mayor_promedio = 0;
        for (int i = 0; i < dimf; i++) {  // contador total de alturas 
            if (vector[i] > promedio) {
                contador_mayor_promedio++;
            }
        }

        System.out.println("cantidad de personas con altura mayor al promedio: " + contador_mayor_promedio);

    }

}
