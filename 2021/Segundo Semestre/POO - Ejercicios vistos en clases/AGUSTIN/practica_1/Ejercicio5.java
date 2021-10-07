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

/* 
5- Un edificio de oficinas está conformado por 8 pisos y 4 oficinas por piso. Realice
un programa que permita informar la cantidad de personas que concurrieron a
cada oficina de cada piso. Para esto, simule la llegada de personas al edificio de la
siguiente manera: a cada persona se le pide el nro. de piso y nro. de oficina a la cual
quiere concurrir. La llegada de personas finaliza al indicar un nro. de piso 9. Al
finalizar la llegada de personas, informe lo pedido. 
 */
public class Ejercicio5 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        //Crear Vector e Inicializar en 0//
        int[][] edificio = new int[8][4];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 4; j++) {
                //edificio[i][j]=0;
            }
        }

        //Insertar Gente en Pisos y Oficinas//        
        int sumarGente = 0;

        System.out.println("Inserte numero de Piso: ");
        int soliPiso = Lector.leerInt();
        while (soliPiso < 9) {          //ojo con el corte de control y los indices de la matriz!
            System.out.println("Inserte numero de Oficina: ");
            int soliOfi = Lector.leerInt();
            edificio[soliPiso][soliOfi] = edificio[soliPiso][soliOfi] + 1;
            System.out.println("Inserte numero de Piso: ");
            soliPiso = Lector.leerInt();
        }

        for (int i = 0; i < 8; i++) {           //puede que no este toda la matriz llena!
            for (int j = 0; j < 4; j++) {
                System.out.println("Para la oficina " + j + " del piso " + i + " hubo " + edificio[i][j] + " de personas");
            }
        }
    }
}
