/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BENJAMIN.practica_2;

/**
 *
 * @author Vanesa
 */
public class Flota {

    private Micro[] micro = new Micro[15];
    private int cantidadMicros=0;

    public Flota() {
    }//constructor nulo.

    public int getCantidadMicros() {
        return cantidadMicros;
    }

    public void setCantidadMicros(int cantidadMicros) {
        this.cantidadMicros = cantidadMicros;
    }

    //i. devolver si la flota está completa (es decir, si tiene 15 micros o no)
    public boolean estaCompleta() {

        return this.getCantidadMicros() == 15;

    }

    //---------------------------------------------
    //ii. agregar a la flota un micro recibido como parámetro.  
    public void cargarMicro(Micro m) {
     
        this.micro[this.cantidadMicros]=m;
        this.cantidadMicros++;
     
    }
    //iii. eliminar de la flota el micro con patente igual a una recibida como parámetro, y -
//     retornar si la operación fue exitosa.    
    //------------------------------------------------------------------ 

    public boolean eliminarMicro(String patente) {      //HACER CORRIMIENTO DE DATOS
        int i = 0;

        while (i < this.cantidadMicros) {        
         if (patente.equals(this.micro[i].getPatente())) {
            this.micro[i] = null;
            this.cantidadMicros--;
            return true;            
         }
         i++;
        }
          return false;
        }    
    /*iv. buscar en la flota un micro con patente igual a una recibida como parámetro y
retornarlo (en caso de no existir dicho micro, retornar null).*/
    
   public Micro buscarMicroPorPatente (String patente){
  int i = 0;
  
        while (i < this.cantidadMicros) {        
         if (patente.equals(this.micro[i].getPatente())) {            
            return  this.micro[i];              //USAR VARIABLE BOOLEANA PARA CORTAR EL BUCLE
         }
         i++;
        }
          return null;
        }    
   /*v. buscar en la flota un micro con destino igual a uno recibido como parámetro y
retornarlo (en caso de no existir dicho micro, retornar null). */
   
   public Micro buscarMicroPorDestino(String destino) {
        int i = 0;

        while (i < this.cantidadMicros) {        
         if (destino.equals(this.micro[i].getDestino())) {
            fin = true 
            //return this.micro[i];            
         }
         i++;
        }
          //return null;
        }    
   
     if (encontre)
       return this.micro[i]
     else
       return null
   
   }
    
 



