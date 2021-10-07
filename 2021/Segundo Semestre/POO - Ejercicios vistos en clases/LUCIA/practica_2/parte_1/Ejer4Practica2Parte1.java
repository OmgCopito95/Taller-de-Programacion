/* Realizar un programa principal que instancie un círculo,
le cargue información leída de teclado e informe en consola el perímetro y el área.
 */
package LUCIA.practica_2.parte_1;

import BRENDA.practica_2.Circulo;
import PaqueteLectura.Lector;

public class Ejer4Practica2Parte1 {

    public static void main(String[] args) {
        
        double area;
        
        String colorRelleno= new String();
        
        String colorLinea= new String();
        
        System.out.print("Ingrese el radio del circulo: ");
        area= Lector.leerDouble();
        System.out.print("Ingrese el color de relleno del circulo: ");
        colorRelleno= Lector.leerString();
        System.out.print("Ingrese el color de linea del circulo: ");
        colorLinea= Lector.leerString();
        Circulo c= new Circulo (area,colorRelleno,colorLinea);
        
        System.out.println("El area del circulo es: "+c.calcularArea()+". El perimetro: "+c.calcularPerimetro()+" y el color de Relleno y de linea del circulo es "+c.getColorRelleno()+" y "+c.getColorLinea());
    }
    
}
