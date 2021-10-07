/* Genere un programa principal que cree una balanza e inicie una compra. 
Lea información desde teclado correspondiente a los ítems comprados 
(peso en kg y precio por kg) hasta que se ingresa uno con peso 0. Registre cada producto 
en la balanza. Al finalizar, informe el resumen de la compra.
 */
package LUCIA.practica_2.parte_1;

import BRENDA.practica_2.Producto;
import BRENDA.practica_2.Balanza2;
import PaqueteLectura.Lector;

public class Ejer5Practica2Parte1 {

    public static void main(String[] args) {
         double peso;
        
        double precio;
        
        double monto;
        
        int cantItem;
        
        String descripcion= new String();
        
        Balanza2 bal= new Balanza2();  //Creo una compra
        bal.iniciarCompra();        
        
        System.out.print("Ingrese el peso en kg del producto: ");
        peso= Lector.leerDouble();
        while(peso != 0){
            System.out.print("Ingrese la descripcion del producto: ");
            descripcion= Lector.leerString();
            Producto p= new Producto(peso,descripcion);            
            System.out.print("Ingrese el precio por kg: $");
            precio= Lector.leerDouble();
            bal.registrarProducto(p, precio);
            System.out.print("Ingrese el peso en kg del producto: ");
            peso= Lector.leerDouble();            
        }
        //Termine la compra
        System.out.println(bal.devolverResumenDeCompra());               
    }    
}

    
    

