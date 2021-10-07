/*
Escriba un programa que lea las alturas de los 15 jugadores de un equipo de
básquet y las almacene en un vector. Luego informe:
- la altura promedio
- la cantidad de jugadores con altura por encima del promedio */
package LUCIA.practica_1;

import PaqueteLectura.Lector;

public class Ejer3 {

    public static void main(String[] args) {

        int i;

        double[] vectorAltura = new double[4];

        double suma = 0;

        double promedio;

        int jugador = 1;

        int cantMayor = 0;

        //======  Agrego en un vector las alturas y sumo el total ======//
        for (i = 0; i < 4; i++) {
            System.out.println("Ingrese la altura del jugador numero " + jugador);
            jugador++;
            double num = Lector.leerDouble();
            vectorAltura[i] = num;
            suma = suma + num; //vectorAltura [i];
            //  System.out.println("SUMA "+ suma);              
        }

        //======  PROMEDIO DE ALTURA ======//
        promedio = suma / 4.0;
        System.out.println("La altura promedio es de " + promedio);

        //======  ALTURAS MAYORES AL PROMEDIO ======//
        for (i = 0; i < 4; i++) {
            //System.out.println("en la posicion "+ i +","+ vectorAltura [i]); 
            if (vectorAltura[i] > promedio) {
                cantMayor = cantMayor + 1;
            }
            System.out.println("La cantidad de jugadores con mayor atura al promedio es de " + cantMayor);  //SE DEBE IMPRIMIR AFUERA!
        }
    }
}
