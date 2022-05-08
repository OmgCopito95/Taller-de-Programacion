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
public class Cochera {
    
    private double precioCubierto;
    private double precioDescubierto;
    private SectorCubierto sectC;
    private SectorDescubierto sectD;
    

    public Cochera(double precioCubierto, double precioDescubierto) {
        this.precioCubierto = precioCubierto;
        this.precioDescubierto = precioDescubierto;
        this.sectC= new SectorCubierto(precioCubierto);
        this.sectD= new SectorDescubierto(precioDescubierto);
        
    }

    public double getPrecioCubierto() {
        return precioCubierto;
    }

    public double getPrecioDescubierto() {
        return precioDescubierto;
    }
    
    
    public String IngresarCocheCochera(Coche c){
        String aux="";
        return aux;
    }


    

    
    
    
    

}
