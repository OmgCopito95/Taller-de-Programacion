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

public class Practica2parte2Eje4 {

    public static void main(String[] args) {

        int asiento;

        System.out.print("eliga asiento (1..20): ");
        asiento = Lector.leerInt();
        Micro micro = new Micro("ABC123", "Mar del plata", "5:00", 0, 20);
        while (asiento != -1 && !micro.microLleno()) {
            if (micro.asientoEsValido(asiento - 1)) {
                if (micro.devolverEstado(asiento - 1)) {
                    System.out.println("el asiento se encuentra ocupado. el asiento "
                            + (micro.devolverAsiento() + 1) + " se encuentra libre. ");
                } else {
                    micro.ocuparAsiento(asiento - 1);
                    System.out.println("la operacion se ha realizado con exito");
                    System.out.println("asientos ocupados: " + micro.devolverAsientosOcupados());
                    System.out.println("  ");
                }
            } else {
                System.out.println(" el asiento no es valido ");
            }
            System.out.println(" ");
            System.out.print("eliga asiento (1..20): ");
            asiento = Lector.leerInt();
        }
        System.out.println(" ");
        System.out.println("la cantidad de asientos ocupados es: " + micro.getAsientosOcupados());
        System.out.println("---------------'  el programa finalizo '--------------------");
    }

}
