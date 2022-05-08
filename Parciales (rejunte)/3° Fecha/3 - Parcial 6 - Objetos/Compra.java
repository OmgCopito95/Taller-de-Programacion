package parcial6;

public abstract class Compra {
    private int numeroCompra;
    private Producto vProducto[];
    
    private int dimF;
    private int dimL;
    
    public Compra(int unNumeroCompra , int cantProductos){
        this.setNumeroCompra(unNumeroCompra);
        this.dimF = cantProductos;
        this.dimL = 0;
        
        vProducto = new Producto[dimF];
        for (int i=0;i<dimF;i++){
            vProducto[i] = null;
        }
    }
    
    public void agregarCompra(Producto p){
        vProducto[dimL] = p;
        dimL++;
    }
    
    public abstract double obtenerPrecioAPagar();

    public String toString(){
        String aux = "Productos: ";
        
        for (int i=0; i<this.dimL;i++){
            aux += vProducto[i].toString();
        }
        
        return "Nro: " + this.getNumeroCompra() + ", " + aux +
               ", Precio a pagar: " + this.obtenerPrecioAPagar() +
               ", ";
    }
    
    
    
    public double devolverPrecioMinorista(int pos){
        return vProducto[pos].getPrecioMinorista();
    }
    
    public double devolverPrecioMayorista(int pos){
        return vProducto[pos].getPrecioMayorista();
    }

    public int getNumeroCompra() {
        return numeroCompra;
    }

    public void setNumeroCompra(int numeroCompra) {
        this.numeroCompra = numeroCompra;
    }

    public int getDimL() {
        return dimL;
    }

    public void setDimL(int dimL) {
        this.dimL = dimL;
    }
    
    
}
