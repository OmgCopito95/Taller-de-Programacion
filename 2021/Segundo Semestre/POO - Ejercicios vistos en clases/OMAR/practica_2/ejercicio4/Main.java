package OMAR.practica_2.ejercicio4;


import PaqueteLectura.*;

public class Main {

    public static void main(String[] args) {

        Micro m = new Micro("ABC123", "Mar del Plata", "5:00");
        int nAsiento;

        System.out.print("Ingrese el numero de un asiento: ");
        nAsiento = Lector.leerInt();
        while ( (nAsiento != -1) && (!m.getMicroLleno()) ) {
            if (m.getRango(nAsiento)) {
                if (m.getEstadoAsiento(nAsiento)) {
                    m.ocuparAsiento(nAsiento);
                    System.out.println("El asiento está libre, puede sentarse");
                } else {
                    System.out.println("El asiento que eligió está ocupado, el asiento " + m.getPrimerAsientoLibre() + " está libre para usarse");
                }
            } else {
                System.out.println("El asiento está fuera de rango, no existe. Ingrese otro número de asiento");
            }

            System.out.println("");
            System.out.print("Ingrese el numero de un asiento: ");
            nAsiento = Lector.leerInt();
        }

        System.out.println("Hay " + m.getCantAsientosOcupados() + " asientos ocupados");
    }

}
