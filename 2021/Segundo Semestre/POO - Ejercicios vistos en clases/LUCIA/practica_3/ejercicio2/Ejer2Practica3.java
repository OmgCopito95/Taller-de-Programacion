/* Escriba un programa principal que instancie un jugador y un entrenador 
con datos leídos desde teclado. Pruebe el correcto funcionamiento de cada método implementado.
 */
package LUCIA.practica_3.ejercicio2;
import PaqueteLectura.Lector;

public class Ejer2Practica3 {

    public static void main(String[] args) {
        
       String nombre= new String();
        
        int sueldo;
        
        int campeonatos; 
        
        System.out.print("Ingrese nombre del entrenador ");                     //ENTRENADOR
        nombre= Lector.leerString();
        System.out.print("Ingrese el sueldo basico del entrenador $");
        sueldo= Lector.leerInt();
        System.out.print("Ingrese cantidad de campeonatos ganados: ");
        campeonatos= Lector.leerInt();
        Entrenador e= new Entrenador(nombre,sueldo,campeonatos);        
        System.out.println(e.toString());
        System.out.println("");
        
        int partidosJugados;
        
        int cantGoles;
        
        System.out.print("Ingrese nombre del jugador ");                        //JUGADOR
        nombre= Lector.leerString();
        System.out.print("Ingrese el sueldo basico del jugador $");
        sueldo= Lector.leerInt();
        System.out.print("Ingrese cantidad de partidos jugados: ");
        partidosJugados= Lector.leerInt();
        System.out.println("Ingrese cantidad de goles: ");
        cantGoles= Lector.leerInt();
        Jugador j= new Jugador(nombre,sueldo,partidosJugados,cantGoles);
        System.out.println(j.toString());    
    }    
}
