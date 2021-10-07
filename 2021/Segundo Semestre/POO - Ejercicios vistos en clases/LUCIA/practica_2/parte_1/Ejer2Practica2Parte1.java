/*Genere un programa principal que cree una balanza e inicie una compra. 
Lea información desde teclado correspondiente a los ítems comprados (peso en kg y precio por kg) 
hasta que se ingresa uno con peso 0. Registre cada producto en la balanza.
Al finalizar, informe el resumen de la compra.
 */
package LUCIA.practica_2.parte_1;

import CHECHU.practica_2.Balanza;
import PaqueteLectura.Lector;

public class Ejer2Practica2Parte1 {

  
    public static void main(String[] args) {
        
        double peso;
        
        double precio;
        
        double monto;
        
        int cantItem;
        
        Balanza bal= new Balanza();  //Creo objeto de una compra
        bal.iniciarCompra();        
        System.out.print("Ingrese el peso en kg del producto: ");
        peso= Lector.leerDouble();
        while(peso != 0){
            System.out.print("Ingrese el precio por kg: $");
            precio= Lector.leerDouble();
            bal.registrarProducto(peso, precio);
            System.out.print("Ingrese el peso en kg del producto: ");
            peso= Lector.leerDouble();            
        }
        //Termine la compra
        System.out.println(bal.devolverResumenDeCompra());               
    }    
}
