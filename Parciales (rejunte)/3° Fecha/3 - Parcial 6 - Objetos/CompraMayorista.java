package parcial6;

public class CompraMayorista extends Compra {
    private int cuit;
    
    public CompraMayorista(int unNumeroCompra , int cantProductos , int unCuit){
        super(unNumeroCompra,cantProductos);
        this.setCuit(unCuit);
    }

    public double obtenerPrecioAPagar(){
        double total = 0;
        
        for (int i=0; i<super.getDimL();i++){
            total += super.devolverPrecioMayorista(i);
        }
        
        total = (total - (total * 0.21));
        
        return total;
    }
    
    public String toString(){
        String aux = "Compra mayorista: ";
        
        aux += super.toString() + "CUIT: " + this.cuit;
        
        return aux;
    }
    
    
    public int getCuit() {
        return cuit;
    }

    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    
    
}
