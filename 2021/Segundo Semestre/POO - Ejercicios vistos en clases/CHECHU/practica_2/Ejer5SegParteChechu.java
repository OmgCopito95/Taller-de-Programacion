/*
5- Realice un programa que cargue un vector con 10 strings leídos desde teclado. El vector
generado tiene un mensaje escondido que se forma a partir de la primera letra de cada
string. Muestre el mensaje escondido en consola.
NOTA: La primera letra de un string se obtiene enviándole el mensaje charAt(0) al objeto
string. Probar con: humo oso lejos ala menos usado nene de ocho ! Debería imprimir:
holamundo!

 */
package CHECHU.practica_2;

import PaqueteLectura.Lector; //importo paquete de lectura para leer

public class Ejer5SegParteChechu {

    public static final int DIMF = 10; // DIMF es una CONSTANTE para la dimension fisica

    public static void main(String[] args) {

        String[] vector = new String[DIMF]; // declaro el vector que contendra valores de String, String con mayúscula en S

        for (int i = 0; i < DIMF; i++) { //cargo el vector desde 0 hasta la DIMF, 0-9
            vector[i] = new String(); //reservo espacio para el objeto String
            System.out.print("INGRESE UN STRING: ");
            vector[i] = Lector.leerString();//voy cargando el string en cada posición x c/ vuelta del for
        }// del for
        System.out.println("________________________");
        System.out.print("MENSAJE OCULTO:");
        for (int i = 0; i < DIMF; i++) { //me muevo en el vector desde 0 hasta la DIMF, 0-9
            System.out.print(vector[i].charAt(0)); // obtengo la primera letra de un string enviándole el mensaje charAt(0) al objetostring.
        }//del for

    } //del main

}// de la clase
