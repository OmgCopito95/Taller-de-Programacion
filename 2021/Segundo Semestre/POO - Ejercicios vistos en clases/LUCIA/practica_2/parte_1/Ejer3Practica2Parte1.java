/* Realizar un programa principal que instancie un entrenador,
cargándole datos leídos desde teclado. Pruebe el correcto funcionamiento de cada método implementado.
 */
package LUCIA.practica_2.parte_1;

import BRENDA.practica_2.Entrenador;
import PaqueteLectura.Lector;

public class Ejer3Practica2Parte1 {

    public static void main(String[] args) {
        
        String nombre = new String();
        
        int sueldo;
        
        int cantGanados;
        
        //CARGO AL ENTRENADOR
        System.out.print("Ingrese el nombre del entrenador: ");
        nombre= Lector.leerString();
        System.out.print("Ingrese el sueldo basico: $");
        sueldo= Lector.leerInt();
        System.out.print("Ingrese la cantidad de campeonatos ganados: ");
        cantGanados= Lector.leerInt();
        Entrenador e= new Entrenador(nombre,sueldo,cantGanados);
        
        System.out.println("El sueldo a cobrar del entrenaodr "+e.getNombre()+" es de $"+e.calcularSueldoACobrar(sueldo));
        
    }
    
}