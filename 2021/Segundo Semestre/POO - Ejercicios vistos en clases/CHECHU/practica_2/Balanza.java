/*
2- A – Definir una clase para representar balanzas comerciales (para ser utilizadas en
verdulerías, carnicerías, etc). Una balanza comercial sólo mantiene el monto y la cantidad
de items correspondientes a la compra actual (es decir, no almacena los ítems de la
compra). La balanza debe responder a los siguientes mensajes:
▪ iniciarCompra(): inicializa el monto y cantidad de ítems de la compra actual.
▪ registrarProducto(pesoEnKg, precioPorKg): recibe el peso en kg del ítem comprado y
su precio por kg, debiendo realizar las actualizaciones en el estado de la balanza.
▪ devolverMontoAPagar(): retorna el monto de la compra actual.
▪ devolverResumenDeCompra(): retorna un String del siguiente estilo “Total a pagar X
por la compra de Y productos” , donde X es el monto e Y es la cantidad de ítems de la
compra. 
 */
package CHECHU.practica_2;
//REVISAR PORFI
public class Balanza {
    private double monto;
    private int cantItems;
    private String resumen;
    
    //constructor nulo
    public Balanza (){
    }
    //constructor con parámetros formales
    public Balanza(double monto, int cantItems, String resumen) {
        this.monto = monto;
        this.cantItems = cantItems;
        this.resumen= resumen;
    }
    

    //USAR LOS THIS
     public void iniciarCompra() {// iniciarCompra(): inicializa el monto y cantidad de ítems de la compra actual.
        monto = 0;
        cantItems = 0;
        resumen = "";
    }
    public void registrarProducto(Producto unProducto, double precioPorKg) { /*(pesoEnKg, precioPorKg): recibe el peso en kg del ítem comprado y
                                        su precio por kg, debiendo realizar las actualizaciones en el estado de la balanza.*/
        monto += unProducto.getPesoEnKg() * precioPorKg;
        cantItems++;
        resumen += unProducto.getDescripcion() + " " + (unProducto.getPesoEnKg() * precioPorKg) + " pesos" + " - ";
    }
    
    //NO DEBE SER VOID
     public void devolverMontoAPagar() { //devolverMontoAPagar(): retorna el monto de la compra actual.
        return monto;
    }
     
    public void devolverResumenDeCompra(){/*devolverResumenDeCompra(): retorna un String del siguiente estilo “Total a pagar X
                                por la compra de Y productos” , donde X es el monto e Y es la cantidad de ítems de la
                                compra. 
                                 */
        System.out.println(this.resumen + "Total a pagar $"+ this.devolverMontoAPagar() + " por la compra de " + this.cantItems + " productos.");
   }
    
}// del public class
