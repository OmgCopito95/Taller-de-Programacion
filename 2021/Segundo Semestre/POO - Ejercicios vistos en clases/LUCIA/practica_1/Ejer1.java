package LUCIA.practica_1;

import PaqueteLectura.Lector;

public class Ejer1 {

    public static void main(String[] args) {
        System.out.println("Ingrese un  numero para hacer factorial");

        int num = Lector.leerInt();

        int i;

        int aux = 1;

        for (i = 1; i <= num; i++) {
            aux = aux * i;
        }

        System.out.println("El factorial de " + num + " es: " + aux);
    }

}
