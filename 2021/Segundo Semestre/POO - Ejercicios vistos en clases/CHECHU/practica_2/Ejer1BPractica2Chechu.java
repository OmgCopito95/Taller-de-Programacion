/*
B- Realizar un programa principal que instancie un triángulo, le cargue información leída
desde teclado e informe en consola el perímetro y el área. 
 */
package CHECHU.practica_2;

import BRENDA.practica_2.Triangulo;
import PaqueteLectura.Lector;

public class Ejer1BPractica2Chechu {

    public static void main(String[] args) {
        Triangulo triang = new Triangulo(); // CONSTRUCTOR NULO

       // CONSTRUCTOR COMPLETO
        System.out.println("INGRESE LADO 1:");
        triang.setLadoUno(Lector.leerDouble());
        System.out.println("INGRESE LADO 2:");
        triang.setLadoDos(Lector.leerDouble());
        System.out.println("INGRESE LADO 3:");
        triang.setLadoTres(Lector.leerDouble());
        System.out.println("INSERTAR COLOR DE RELLENO:");
        triang.setRelleno(uncolorRelleno);
        System.out.println("INSERTAR COLOR DE LÍNEA:");
        triang.setLinea(uncolorLinea);
        System.out.println("_____________________");
        System.out.println("EL ÁREA DEL TRIÁNGULO ES: " + triang.calcularArea());
        System.out.println("EL PERÍMETRO DEL TRIÁNGULO ES: " + triang.calcularPermitero());
    }// del main

}//del class
