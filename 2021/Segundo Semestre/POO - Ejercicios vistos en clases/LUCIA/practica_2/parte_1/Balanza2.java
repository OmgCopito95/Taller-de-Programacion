/* Modifique el ejercicio 2-A. Ahora la balanza debe poder generar un resumen 
de compra más completo. Para eso agregue a la balanza la característica
resumen (String). Modifique los métodos:

A) iniciarCompra para que además inicie el resumen en el String vacío.

B) registrarProducto para que reciba un objeto Producto (que se caracteriza por peso en kg 
y descripción) y su precio por kg. La operación debe 
realizar las actualizaciones en monto /cantidad de ítems y adicionar al resumen (string)
la descripción y el monto pagado por este producto.

C) devolverResumenDeCompra() para que retorne un String del 
siguiente estilo: “Naranja 100 pesos – Banana 40 pesos – Lechuga 50 pesos – Total a pagar 190 
pesos por la compra de 3 productos” . La sección subrayada es el contenido de resumen. 
 */

package LUCIA.practica_2.parte_1;

public class Balanza2 {
   
    private double monto;
    private int cantItem;
    private String resumen;
    
    public Balanza2 (){   //CONSTRUCTOR NULO
        
    }
    
    public Balanza2 (double monto, int cantItem, String resumen){   //CONSTRUCTOR
        this.monto= monto;
        this.cantItem= cantItem;
        this.resumen= resumen;
    }
       
    public void iniciarCompra (){                 //INCISO A
        this.monto= 0;
        this.cantItem=0;  
        this.resumen= "";
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
    
    public void setResumen(String resumen){
        this.resumen= resumen;
    }
    
    public String getResumen(){
        return resumen;
    }
    
    public void registrarProducto (Producto p, double precio){  //INCISO B
        this.monto= (p.getPesoEnKg() * precio); //LO MISMO QUE EN EL OTRO, TENES QUE SUMARSELO SINO LO ESTAS REEMPLAZANDO
        this.cantItem++;
        resumen += p.getDescripcion()+" $"+this.getMonto()+" ";  //EN REALIDAD ACA MONTO TENDRIA LA SUMA TOTAL, VOS TENES QUE MOSTRAR EL COSTO DEL PRODUCTO (LA MULTI)          
    }
    
    public double devolverMontoAPagar(){
        return this.getMonto();
    }
    
    public String devolverResumenDeCompra(){
      return(this.getResumen()+" Total a pagar $"+this.getMonto());
    }
}


