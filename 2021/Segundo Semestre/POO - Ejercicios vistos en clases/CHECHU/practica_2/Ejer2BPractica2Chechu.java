/*B - Genere un programa principal que cree una balanza e inicie una compra. Lea
información desde teclado correspondiente a los ítems comprados (peso en kg y precio
por kg) hasta que se ingresa uno con peso 0. Registre cada producto en la balanza. Al
finalizar, informe el resumen de la compra. 
 */
package CHECHU.practica_2; //ACARREA ERROR DEL CLASS y está modificado por el 5

import BRENDA.practica_2.Producto;
import PaqueteLectura.Lector; //Importo el paquete de lectura

public class Ejer2BPractica2Chechu {

    public static void main(String[] args) {
    Producto producto = new Producto(); //   CONSTRUCTOR NULO
    
    Balanza balanza0 = new Balanza (); //   CONSTRUCTOR NULO
    balanza0.iniciarCompra();//inicializo los valores de la balanza
        
    //INICIAR COMPRA
     double peso;
        System.out.println("Peso en kg: ");
        peso = Lector.leerDouble();
    
     while (peso != 0) { //mientras tenga peso cargo la descripción del producto
            producto.setPesoEnKg(peso);
            System.out.println("Descripcion: ");
            producto.setDescripcion(Lector.leerString());
            System.out.println("Precio por kg: ");
            balanza0.registrarProducto(producto, (Lector.leerDouble())); //realizo las actualizaciones en el estado de la balanza
            System.out.println("Peso en kg: ");
            peso = Lector.leerDouble();//vuelvo a ver si hay otro producto
        }
     System.out.println("RESUMEN DE COMPRA");
     System.out.println(balanza0.devolverResumenDeCompra());
    }//del MAIN
    
}//del CLASS
