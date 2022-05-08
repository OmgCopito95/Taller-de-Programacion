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
public class SectorDescubierto extends Sector{

    
    private double costoHora;
    
    public SectorDescubierto(double costoHora) {
        super();
        this.costoHora=costoHora;
    }

    public double getCostoHora() {
        return costoHora;
    }
    
    
    
        public int ingresarCocheDescubierto(Coche c){      
        return super.ingresarCoche(c);
            
    }
    
    
    



    


    
    
    
    
}
