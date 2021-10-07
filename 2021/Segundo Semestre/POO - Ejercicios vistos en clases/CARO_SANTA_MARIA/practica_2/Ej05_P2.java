package CARO_SANTA_MARIA.practica_2;
import PaqueteLectura.Lector;

/*
5- Realice un programa que cargue un vector con 10 strings leídos desde teclado. El vector
generado tiene un mensaje escondido que se forma a partir de la primera letra de cada
string. Muestre el mensaje escondido en consola.
NOTA: La primera letra de un string se obtiene enviándole el mensaje charAt(0) al objeto
string. Probar con: humo oso lejos ala menos usado nene de ocho ! Debería imprimir:
holamundo!
 */
public class Ej05_P2 {
    public static void main (String [] args) {
        String [] vector = new String[10];
        for (int i = 0; i < 10; i++) {
            System.out.print("Ingrese una palabra: ");
            vector[i] = Lector.leerString();
        }
        for (int i = 0; i < 10; i++) {
            System.out.print(vector[i].charAt(0));
        }
    }
}
