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
public class coroSemicircular extends Coro{
    private Corista [] coristas;//que significa que sea final?
    private int dimL;
   
    
    public coroSemicircular(String nomDirector, int cantCor){
        super(nomDirector);
        setCantCoristas(cantCor);
        this.coristas = new Corista [this.getCantCoristas()];
        this.dimL =0;
    }
    public coroSemicircular(){
        
    }

    public Corista[] getCoristas() {
        return coristas;
    }

    public void setCoristas(Corista[] coristas) {
        this.coristas = coristas;
    }

    public int getDimL() {
        return dimL;
    }
  

    private void setDimL(int dimL) {
        this.dimL = dimL;
    }
   public boolean estaLleno(){
        boolean aux = false;
        if (this.dimL == this.getCantCoristas()){
            aux = true;
        }
        return aux;
    }

    @Override
    public void agregarCorista(){
        Corista unCorista = new Corista();
        if (this.dimL<this.getCantCoristas()){
            this.coristas[this.dimL++] = unCorista;
        }   
    }
    @Override
     public boolean bienFormado(){
         boolean aux=false;
         int min = -1;
         int i=0;
         if(this.estaLleno()){//dice se supone asique no hay q preguntar
             while (min <= coristas[i].getTonoFundamental()) {
                 min = coristas[i].getTonoFundamental();
                 i++;
             }
             if(i == this.getCantCoristas()){
                 aux=true;
             }
         }
         return aux;
     }
     
    @Override
     public String datosCoristas(){
         String aux = "";
         for (int i = 0; i < this.getCantCoristas(); i++) {
             aux+="el nombre del corista es "+this.coristas[i].getNombreCorista()+" su dni es "+this.coristas[i].getDniCorista()+" su edad "+this.coristas[i].getEdadCorista()+"su tono es "+this.coristas[i].getTonoFundamental();
         }
         return aux;
     }
     
    @Override
     public String toString(){
         String aux="";
       
         aux =super.toString()+this.datosCoristas();
         return aux;
     }
    
}
