package parcial6;

public class CompraMinorista extends Compra {
    private boolean jubilado;
    
    public CompraMinorista(int unNumeroCompra , int cantProductos , boolean esJubilado){
        super(unNumeroCompra,cantProductos);
        this.setJubilado(esJubilado);
    }
    
    public double obtenerPrecioAPagar(){
        double total = 0;
        
        for (int i=0; i<super.getDimL();i++){
            total += super.devolverPrecioMinorista(i);
        }
        
        if (this.getJubilado() == true){
            total = (total - (total * 0.1));
        }
        
        return total;
    }
    
    public String toString(){
        String aux = "Compra minorista: ";
        
        aux += super.toString() + "Es jubilado: " + this.getJubilado();
        
        return aux;
    }

    public boolean getJubilado() {
        return jubilado;
    }

    public void setJubilado(boolean jubilado) {
        this.jubilado = jubilado;
    }
    
    
}
