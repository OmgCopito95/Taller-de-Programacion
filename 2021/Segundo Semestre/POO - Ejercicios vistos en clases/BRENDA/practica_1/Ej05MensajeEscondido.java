package BRENDA.practica_1;

import PaqueteLectura.Lector;

/*Realice un programa que cargue un vector con 10 strings leídos desde teclado. El vector
generado tiene un mensaje escondido que se forma a partir de la primera letra de cada
string. Muestre el mensaje escondido en consola.
 */
public class Ej05MensajeEscondido {

    public static void main(String[] args) {
        final int dimF = 10;
        String[] mensaje = new String[dimF];

        for (int i = 0; i < dimF; i++) {
            System.out.println("Ingrese String: ");
            mensaje[i] = Lector.leerString();
        }

        System.out.print("El mensaje escondido es: ");
        for (int i = 0; i < dimF; i++) {
            System.out.print(mensaje[i].charAt(0));
        }
    }
}
