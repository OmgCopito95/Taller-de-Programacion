/* Genere un programa que instancie una persona y un trabajador con datos leídos de teclado
y muestre la representación de cada uno en consola.
 */
package LUCIA.practica_3.ejercicio3;

import PaqueteLectura.Lector;

public class Ejer3Practica3 {
   
    public static void main(String[] args) {
        
        String nombre;
        
        int DNI;
        
        int edad;
        
        String tarea;
        
        System.out.print("Ingrese el nombre de la persona: ");
        nombre= Lector.leerString();
        System.out.print("Ingrese DNI: ");
        DNI= Lector.leerInt();
        System.out.print("Ingrese edad: ");
        edad= Lector.leerInt();
        
        Persona p= new Persona(nombre,DNI,edad);
        System.out.println(p.toString());
        System.out.println("");
        
        System.out.print("Ingrese la tarea que desempeña: ");
        tarea= Lector.leerString();
        Trabajador t= new Trabajador(nombre,DNI,edad,tarea);
        System.out.println(t.toString());
    }
    
}
