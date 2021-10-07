
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AGUSTIN.practica_1;
import PaqueteLectura.Lector;

/**
 *
 * @author Peirano-PC
 */
            // CONSIGNA // 


/*
Se dispone de una clase Persona (ya implementada en la carpeta tema2). Un objeto
persona puede crearse sin valores iniciales o enviando en el mensaje de creación el
nombre, DNI y edad (en ese orden). Un objeto persona responde a los siguientes mensajes:

Realice un programa que cree un objeto persona con datos leídos desde teclado. Luego
muestre en consola la representación de ese objeto en formato String. 
*/


public class Ejercicio1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p = new Persona();     
                      
                
        System.out.println("Ingrese el nombre de la persona: ");
        p.setNombre(Lector.leerString());
        System.out.println("Ingrese el DNI de la persona");
        p.setDNI (Lector.leerInt());
        System.out.println("Ingrese la edad de la persona");
        p.setEdad(Lector.leerInt());
        
        System.out.println(p.toString());
    }
    
}