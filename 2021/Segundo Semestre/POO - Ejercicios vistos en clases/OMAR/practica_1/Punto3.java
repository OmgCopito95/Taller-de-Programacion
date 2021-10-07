package OMAR.practica_1; 
import PaqueteLectura.GeneradorAleatorio;

public class Punto3 {

    public static void main(String[] args) {

        int [] jugadores = new int[15];
        int nRandom, cantJugadores = 0;;
        double sumaAlturas = 0, alturaPromedio = 0;
        GeneradorAleatorio.iniciar();
        
        for (int i = 0; i < jugadores.length; i++) {
            
            nRandom = GeneradorAleatorio.generarInt(10);
            System.out.println("ALTURA DEL JUGADOR " + i + ": " + nRandom);
            jugadores[i] = nRandom;
            sumaAlturas += nRandom;
        }
        System.out.println("");

        System.out.println("SUMA TOTAL DE LAS ALTURAS: " + sumaAlturas);
        alturaPromedio = sumaAlturas / jugadores.length;
        System.out.println("ALTURA PROMEDIO: " + alturaPromedio);
        
        System.out.println("");
              
        System.out.println("JUGADORES CON ALTURA POR ENCIMA DEL PROMEDIO, ENTRE ELLOS ESTÁN");
        for (int i = 0; i < jugadores.length; i++) {
            if (jugadores[i] > alturaPromedio) {
                System.out.println("JUGADOR " + i + " CON ALTURA " + jugadores[i]);
                cantJugadores += + 1;
            }
        }
        
        System.out.println("");
        System.out.println("TOTAL DE JUGADORES CON ALTURA POR ENCIMA DEL PROMEDIO: " + cantJugadores);
    }
}
