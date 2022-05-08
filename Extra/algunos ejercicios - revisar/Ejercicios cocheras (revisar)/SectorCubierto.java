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
public class SectorCubierto extends Sector{
    
    private double costoHora;

    public SectorCubierto(double costoHora) {
        super();
        this.costoHora=costoHora;
    }
    
    
        public int ingresarCochesCubierto(Coche c){      
        return super.ingresarCoche(c);
        }  

    
    
    
    
    

}
