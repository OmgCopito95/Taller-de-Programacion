/* Definir una clase para representar balanzas comerciales (para ser utilizadas en
verdulerías, carnicerías, etc). Una balanza comercial sólo mantiene el monto y la cantidad
de items correspondientes a la compra actual (es decir, no almacena los ítems de la
compra). La balanza debe responder a los siguientes mensajes:

A)  iniciarCompra(): inicializa el monto y cantidad de ítems de la compra actual.
B) registrarProducto(pesoEnKg, precioPorKg): recibe el peso en kg del ítem comprado y
su precio por kg, debiendo realizar las actualizaciones en el estado de la balanza.
C) devolverMontoAPagar(): retorna el monto de la compra actual.
D) devolverResumenDeCompra(): retorna un String del siguiente estilo “Total a pagar X
por la compra de Y productos” , donde X es el monto e Y es la cantidad de ítems de la
compra

*/
package LUCIA.practica_2.parte_1;

public class Balanza {
    private double monto;
    private int cantItem;
    
    public Balanza (){   //CONSTRUCTOR NULO
        
    }
    
    public Balanza (double monto, int cantItem){   //CONSTRUCTOR
        this.monto= monto;
        this.cantItem= cantItem;        
    }
       
    public void iniciarCompra (){                 //INCISO A
        this.monto= 0;
        this.cantItem=0;        
    }
    
    public void setMonto (double monto){          //SETTERS Y GETTERS
        this.monto=  monto;
    }
    
    public double getMonto(){
        return monto;
    }
    
    public void setItem (int cantItem){
        this.cantItem= cantItem;
    }
    
    public int getcantItem (){
        return cantItem;
    }
    
    public void registrarProducto (double pesoEnKg, double precioPorKg){  //INCISO B
        this.monto= (pesoEnKg * precioPorKg);   //CUANDO HACES LA CUENTA, SE LO TENES QUE SUMAR A MONTO, ACA ESTAS REEMPLAZANDO +=
        this.cantItem++;
    }
    
    public double devolverMontoAPagar(){
        return this.getMonto();
    }
    
    public String devolverResumenDeCompra(){
      return("Total a pagar $"+this.getMonto()+" por la compra de "+this.getcantItem()+" items");
    }
}
