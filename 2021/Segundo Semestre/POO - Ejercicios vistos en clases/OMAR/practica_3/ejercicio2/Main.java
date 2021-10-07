package OMAR.practica_3.ejercicio2;


import PaqueteLectura.*;

public class Main {

    public static void main(String[] args) {

        Empleado jugador = new Jugador("Messi", 35000, 3, 5);
        
        System.out.println(jugador);
        System.out.println("Sueldo a cobrar del jugador: " + jugador.calcularSueldoACobrar());
        
        System.out.println("");
        
        Empleado entrenador = new Entrenador("Sabella", 43500, 5);
        System.out.println(entrenador);
        System.out.println("Sueldo a cobrar del entrenador: " + entrenador.calcularSueldoACobrar());
    }

}
