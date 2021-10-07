/* Realizar un programa principal que instancie un triángulo, le cargue información leída
desde teclado e informe en consola el perímetro y el área
*/

package LUCIA.practica_2.parte_1;

import BRENDA.practica_2.Triangulo;
import PaqueteLectura.Lector;

public class Ejer1Practica2Parte1 {

    public static void main(String[] args) {
        double ladoUno;
        
        double ladoDos;
        
        double ladoTres;
        
        String colorRelleno = new String();
        
        String colorLinea= new String();
        
        System.out.println("Ingrese el valor de un lado UNO de un triangulo: ");
        ladoUno= Lector.leerDouble();
        System.out.println("Ingrese el valor de un lado DOS de un triangulo: ");
        ladoDos= Lector.leerDouble();
        System.out.println("Ingrese el valor de un lado TRES de un triangulo: ");
        ladoTres= Lector.leerDouble();
        System.out.println("Ingrese el color de relleno del triangulo: ");
        colorRelleno= Lector.leerString();
        System.out.println("Ingrese el color de la linea del triangulo: ");
        colorLinea= Lector.leerString();
        Triangulo tri= new Triangulo (ladoUno,ladoDos,ladoTres,colorLinea,colorRelleno);
        
       /* System.out.println("Area: "+tri.calcularArea()+" Perimetro: "+tri.calcularPerimetro());
        System.out.println("Color relleno: "+tri.getColorR()+" Color Linea: "+tri.getColorL());*/
       
       System.out.println(tri.toString());
    }
    
}
