package OMAR.practica_2.ejercicio5;


import PaqueteLectura.*;

public class Main {

    public static void main(String[] args) {

        Flota f = new Flota();
        
        Micro m;
        String patente;
        String destino;
        String horaSalida;
        
        System.out.print("Ingrese una patente: ");
        patente = Lector.leerString();
        while ( (!f.getEstaCompleta()) && (!patente.equals("ZZZ000")) ) {
            
            System.out.print("Ingrese el destino: ");
            destino = Lector.leerString();
            
            System.out.print("Ingrese la hora de salida: ");
            horaSalida = Lector.leerString();
            
            m = new Micro(patente, destino, horaSalida);
            
            f.agregarAFlota(m);
            
            System.out.println("");
            System.out.print("Ingrese una patente: ");
            patente = Lector.leerString();
        }
        
        System.out.println("");
        
        System.out.print("Ingrese la patente del micro a eliminar: ");
        String eliminarMicroPatente = Lector.leerString();
        if (f.eliminarMicro(eliminarMicroPatente)) {
            System.out.println("Se eliminó el micro con patente " + eliminarMicroPatente + " de la flota");
        } else {
            System.out.println("NO se encuentra el micro con la patente " + eliminarMicroPatente + " en la flota");
        }
        
        System.out.println("");
        
        if (f.buscarMicroPatente(eliminarMicroPatente) == null) {
            System.out.println("El micro con patente " + eliminarMicroPatente + " ha sido eliminado o no se ha ingresado un micro con esa patente");
        }
        
        System.out.println("");
        
        System.out.print("Ingrese el destino del micro: ");
        String destinoMicroPatente = Lector.leerString();
        if (f.buscarMicroDestino(destinoMicroPatente) != null) {
            System.out.println("El micro que viaja a " + destinoMicroPatente + " tiene la patente " + f);
        }
    }

}
