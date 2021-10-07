/*Realizar un programa principal que instancie un entrenador, cargándole datos leídos
desde teclado. Pruebe el correcto funcionamiento de cada método implementado.
 */
package CHECHU.practica_2;

import BRENDA.practica_2.Entrenador;
import PaqueteLectura.Lector; //Importo el paquete de lectura

public class Ejer3BPractica2Chechu {

    public static void main(String[] args) {
        Entrenador elProfe = new Entrenador();

        //CARGO LOS DATOS DEL ENTRENADOR POR TECLADO
        System.out.print("NOMBRE DEL ENTRENADOR:");
        elProfe.setNombre(Lector.leerString());
        System.out.print("SUELDITO BÁSICO: ");
        elProfe.setSueldoBasico(Lector.leerDouble());
        System.out.print("CAMPEONATOS GANADOS: ");
        elProfe.setCampeonatosGanados(Lector.leerInt());

        System.out.println("SUELDO A COBRAR : $ " + elProfe.calcularSueldoACobrar());
    }//del MAIN 

}//del CLASS
