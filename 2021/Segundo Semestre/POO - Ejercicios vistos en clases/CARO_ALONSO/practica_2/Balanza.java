/*
2- A – Definir una clase para representar balanzas comerciales (para ser utilizadas en verdulerías, carnicerías, etc).
Una balanza comercial sólo mantiene el monto y la cantidad de items correspondientes a la compra actual
(es decir, no almacena los ítems de la compra).
La balanza debe responder a los siguientes mensajes:

1) iniciarCompra(): inicializa el monto y cantidad de ítems de la compra actual.

2)RegistrarProducto(pesoEnKg, precioPorKg): recibe el peso en kg del ítem comprado y su precio por kg, 
debiendo realizar las actualizaciones en el estado de la balanza.

3)devolverMontoAPagar(): retorna el monto de la compra actual.

4)devolverResumenDeCompra(): retorna un String del siguiente estilo  
“Total a pagar X por la compra de Y productos” ,
donde X es el monto e Y es la cantidad de ítemsde la compra.

 */
package CARO_ALONSO.practica_2;

public class Balanza {

//--- atributos--------//    
    
    private double monto;
    private int cant_producto;
    private Triangulo matriz [][]; 

//--------  constructores -------//      
    
    public Balanza() {
    }

//------ metodos---------- //
    
    public void iniciar_compra() {
        this.monto = 0;
        this.cant_producto = 0;
        
    }

    public void registrar_producto(double peso_kg, double precio_kg) {
        this.monto += (peso_kg * precio_kg);
        this.cant_producto++;
    }

    public double devolverMontoAPagar() {
        return monto;
    }

    @Override
    public String toString() {
        return " Total a pagar $ " + String.format("%.2f",this.devolverMontoAPagar()) + "por la compra de " + cant_producto + " productos";

    } //USAR SETTERS Y GETTERS

}




public double calcularSueldo()
   if
      return this.getSueldoBasico() + 5000;
    else
      return this.getSueldoBasico() + 30000;
      if
        return this.getSueldoBasico() + bonus;

    

