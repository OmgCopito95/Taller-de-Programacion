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
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    /*
    Realice un programa que cargue un vector con 10 strings leídos desde teclado. El vector
    generado tiene un mensaje escondido que se forma a partir de la primera letra de cada
    string. Muestre el mensaje escondido en consola
     */
    public static void main(String[] args) {

        String[] vector = new String[10];
        for (int i = 0; i < 10; i++) {
            vector[i] = Lector.leerString();
        }

        for (int j = 0; j < 10; j++) {
            System.out.println(vector[j].charAt(0));

        }

    }

}
