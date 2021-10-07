/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BRENDA.practica_1;

import BRENDA.practica_1.Persona;

/**
 *
 * @author vsanz
 */
public class Ej03QueImprimeB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Persona p1; 
        Persona p2;
        p1 = new Persona();
        p1.setNombre("Pablo Sotile");
        p1.setDNI(11200413);
        p1.setEdad(40);
        p2 = new Persona();
        p2.setNombre("Julio Toledo");
        p2.setDNI(22433516);
        p2.setEdad(51);
        p1 = p2;
        p1.setEdad( p1.getEdad() + 1 );
        System.out.println(p2.toString()); //imprime Mi nombre es Julio Toledo, mi DNI es 22433516 y tengo 52 años.
        System.out.println(p1.toString()); //imprime lo mismo que la linea anterior
        System.out.println( (p1 == p2) ); //imprime true
    }
    
}
