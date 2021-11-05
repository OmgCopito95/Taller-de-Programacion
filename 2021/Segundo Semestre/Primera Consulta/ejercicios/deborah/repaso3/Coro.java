/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso3;

/**
 *
 * @author debod
 */
public abstract class Coro {
    private String nombreCoro;
    private Director director;
     private int cantCoristas;
   
//los coros deberían crearse sin ningún corista, pero sí sabiendo cuantos coristas va a tener el coro.
    
    
    public Coro(String nomDirector){
        this.director = new Director(nomDirector);
        
    }
    public Coro(){
        
    }

    public String getNombreCoro() {
        return nombreCoro;
    }

    public void setNombreCoro(String nombreCoro) {
        this.nombreCoro = nombreCoro;
    }

    public  int getCantCoristas() {
        return this.cantCoristas;
    }
     public void setCantCoristas(int cantCoristas){
         this.cantCoristas= cantCoristas;
     }
     
    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }
    public abstract void agregarCorista();
   //si pienso un if/else para casos MUY distintos, HACER DOS CLASES
    public abstract boolean estaLleno();
    
    public abstract boolean bienFormado();
    
    public abstract String datosCoristas();
    
    public String toString(){
      String aux="";
      aux="El nombre del coro es "+this.getNombreCoro()+
              " el director es "+this.getDirector();//asi o llamo a cada get de la clase director?
      return aux;       
    }
}
        
           
      
    
            
