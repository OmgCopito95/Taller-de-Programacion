/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BENJAMIN.practica_2;

/**
 *
 * @author Vanesa
 */
import PaqueteLectura.Lector;

public class practica2Eje5parte2 {

    public static void main(String[] args) {

        String patente, destino, horaSalida;

        Flota flota = new Flota();

        System.out.print("ingrese una patente: ");
        patente = Lector.leerString();

        while (!flota.estaCompleta() && !patente.equals("ZZZ000") ) {
            System.out.print("destino: ");
            destino = Lector.leerString();
            System.out.print("hora de salida: ");
            horaSalida = Lector.leerString();
            Micro micro = new Micro(patente, destino, horaSalida, 0, 20);
            flota.cargarMicro(micro);
            System.out.println("   ");
            System.out.print("ingrese una patente: ");
            patente = Lector.leerString();
        }
        System.out.print("ingrese patente a buscar: ");
        patente = Lector.leerString();
        if (flota.buscarMicroPorPatente(patente) != null) {
            System.out.println("el micro con patente " + patente + " se encuentra en la flota de micros.");
        } else {
            System.out.println("el micro no se encuentra en la flota");
        }

        System.out.print(" ingrese destino a buscar: ");
        destino = Lector.leerString();
        if (flota.buscarMicroPorDestino(destino) != null) {
            System.out.println("el micro con destino a " + destino + " se encuentra en la flota de micros.");
        } else {
            System.out.println("el micro con destino a " + destino + " no fue encontrado ");
        }
        System.out.print("eliga patente de micro que desee eliminar de la flota: ");
        patente = Lector.leerString();

        if (flota.eliminarMicro(patente)) {
            System.out.println("el micro con patente " + patente + " se pudo eliminar de la flota");
                   }
        else {System.out.println("el micro con la patente "+patente+" no se encuentra en la flota");}
       
         if (flota.buscarMicroPorPatente(patente)== null) {                    
                             System.out.print("el micro no se encuentra en la flota");                               
            }             

        
        System.out.println(" ----------- ");

    }

}
