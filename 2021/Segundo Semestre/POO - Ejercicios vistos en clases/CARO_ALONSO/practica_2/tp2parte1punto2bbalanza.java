/*
2b) Genere un programa principal que cree una balanza e inicie una compra
Lea información desde teclado correspondiente a los ítems comprados
(peso en kg y precio por kg) hasta que se ingresa uno con peso 0.
Registre cada producto en la balanza. Al finalizar, informe el resumen de la compra.

 */
package CARO_ALONSO.practica_2;

import PaqueteLectura.Lector;

public class tp2parte1punto2bbalanza {

    public static void main(String[] args) {
        
        int cantidad;
        double precio_x_kg; 
        int corte;
        
        System.out.println("ingrese peso por kilo de producto :");
        double peso_x_kg = Lector.leerDouble();
                
        while (peso_x_kg != 0){  
            
            Balanza Ba = new Balanza();
            System.out.println("ingrese cantidad de productos :");
            cantidad = Lector.leerInt(); // cantidad de productos de la compra.
            Ba.iniciar_compra(cantidad);  // inicializo la compra       //NO HAY QUE PASARLE LA CANTIDAD
            
        
            corte = 0;
            
            while ((peso_x_kg != 0) && (corte < cantidad)) {   // mientas no entre un producto con peso cero y la cantidad de productos no se termine.
                System.out.println("ingrese $ precio por kilo de producto :");
                precio_x_kg = Lector.leerDouble(); // precio por kilo de prodcuto 
                Ba.registrar_producto(peso_x_kg, precio_x_kg);  // sumo a al monto el producto;
                corte++;
                System.out.println("ingrese peso por kilo de producto :");
                peso_x_kg = Lector.leerDouble();    // peso por kilo de producto.         
                
            }
               
            System.out.println("-------------------------");
            System.out.println(Ba.toString());       
            System.out.println(" ");
        }
        

    }
}