/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package examenes;

/**
 * 
 * @author Sammy Guergachi <sguergachi at gmail.com>
 */
public class Sector {
    
    private double costoHora;
    private Coche [] cocheSector;
    private int dim;

    public Sector() {
        //this.costoHora = costoHora;
        this.cocheSector=new Coche[20];
        this.dim=0;
        for(int i=0;i<20;i++)
            this.cocheSector[i]=null;
    }
    
  
    

    public int ingresarCoche(Coche c){
        int aux;
        this.cocheSector[dim]=c;
        aux=this.dim++;
        this.dim++;
        return aux;    
    }

    
    
    

}
