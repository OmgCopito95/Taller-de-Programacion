/* Escriba un programa que instancie un triángulo, un círculo y un cuadrado, 
con información leída desde teclado. Luego muestre en consola el área y perímetro 
de cada uno y su representación en String.
 */
package LUCIA.practica_3.ejercicio1;

import LUCIA.practica_3.Circulo;
import PaqueteLectura.Lector;

public class Ejer1Practica3 {

    public static void main(String[] args) {
        
        double lado1,lado2,lado3;
        
        double radio;
        
        String colorR= new String();
        
        String colorL= new String();
        
        
        //============== TRIANGULO ==============//
        System.out.println("--- TRIANGULO ---");
        System.out.println("Ingrese lado UNO");
        lado1= Lector.leerDouble();
        System.out.println("Ingrese lado DOS");
        lado2= Lector.leerDouble();
        System.out.println("Ingrese lado TRES");
        lado3= Lector.leerDouble();
        System.out.println("Ingrese color Relleno");
        colorR= Lector.leerString();
        System.out.println("Ingrese color Linea");
        colorL= Lector.leerString();
              
        Triangulo t= new Triangulo(lado1,lado2,lado3,colorR,colorL);   //Objeto
        System.out.println(t.toString());                             //toString
        System.out.println("");
        
        //============== CIRCULO ==============//
        System.out.println("--- CIRCULO ---");
        System.out.println("Ingrese radio");
        radio= Lector.leerDouble();
        System.out.println("Ingrese color Relleno");
        colorR= Lector.leerString();
        System.out.println("Ingrese color Linea");
        colorL= Lector.leerString();
        
        Circulo ci= new Circulo(radio,colorR,colorL);    //Objeto
        System.out.println(ci.toString());              //toString
        System.out.println("");
        
        //============== CUADRADO ==============//
        System.out.println("--- CUADRADO ---");
        System.out.println("Ingrese lado");
        lado1= Lector.leerDouble();
        System.out.println("Ingrese color Relleno");
        colorR= Lector.leerString();
        System.out.println("Ingrese color Linea");
        colorL= Lector.leerString();
        
        Cuadrado cu= new Cuadrado (lado1,colorR,colorL);   //Objeto
        System.out.println(cu.toString());                //toString
        System.out.println("");
        
    }
    
}
