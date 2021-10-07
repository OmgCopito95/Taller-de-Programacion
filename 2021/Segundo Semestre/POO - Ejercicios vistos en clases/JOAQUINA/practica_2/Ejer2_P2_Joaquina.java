
package JOAQUINA.practica_2;
import PaqueteLectura.Lector;
/**
 * Genere un programa que cree una flota vacía. Cargue micros (sin pasajeros) a la flota
con información leída desde teclado (hasta que se ingresa la patente “ZZZ000” o hasta
completar la flota). Luego lea una patente y elimine de la flota el micro con esa patente;
busque el micro con dicha patente para comprobar que ya no está en la flota. Para
finalizar, lea un destino e informe la patente del micro que va a dicho destino.

 */
public class Ejer2_P2_Joaquina {

    public static void main(String[] args) {
        String patente,destino, hora;
        Flota_Joa flota = new Flota_Joa();
        
        System.out.println("Ingrese una patente");
        patente = Lector.leerString();
        while((!flota.flotaCompleta())&&(!patente.equals("ZZZ000"))){
            System.out.println("Ingrese un destino");
            destino = Lector.leerString();
            System.out.println("Ingrese una hora");
            hora = Lector.leerString();
            Micro_Joa micro = new Micro_Joa(patente,destino,hora);
            flota.agregar(micro);
            System.out.println("Ingrese una patente");
            patente = Lector.leerString();
        }
        System.out.println("--Ingrese una patente--");
        patente = Lector.leerString();
        flota.eliminar(patente);
        System.out.println(flota.buscarPatente(patente));
        System.out.println("--Ingrese un destino--");
        destino = Lector.leerString();
        System.out.println(flota.buscarDestino(destino).getPatente());            
    }
    
}
