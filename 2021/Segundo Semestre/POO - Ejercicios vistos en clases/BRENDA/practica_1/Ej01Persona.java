/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRENDA.practica_1;

import BRENDA.practica_1.Persona;
import PaqueteLectura.Lector;

/*Realice un programa que cree un objeto persona con datos leídos desde teclado. Luego
muestre en consola la representación de ese objeto en formato String
 */
public class Ej01Persona {

    public static void main(String[] args) {

        System.out.println("Ingrese su nombre: ");
        String nombre = Lector.leerString();
        System.out.println("Ingrese su dni: ");
        int dni = Lector.leerInt();
        System.out.println("Ingrese su edad: ");
        int edad = Lector.leerInt();

        Persona persona = new Persona(nombre, dni, edad);  // se podria hacer lo mismo invocando al constructor vacio de Persona y utilizando los metodos setters.

        System.out.println(persona);
    }
}
