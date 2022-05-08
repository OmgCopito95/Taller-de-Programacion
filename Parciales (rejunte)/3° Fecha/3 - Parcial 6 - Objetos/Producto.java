package parcial6;

public class Producto {
    private int codigo;
    private double precioMayorista;
    private double precioMinorista;
    
    public Producto(int unCodigo , double unPrecioMayorista , double unPrecioMinorista){
        this.setCodigo(unCodigo);
        this.setPrecioMayorista(unPrecioMayorista);
        this.setPrecioMinorista(unPrecioMinorista);
    }
    
    public String toString(){
        String aux = " ";
        
        aux = "Codigo: " + this.getCodigo() +
              " Precio Mayorista: " + this.getPrecioMayorista() +
              " Precio Minorista: " + this.getPrecioMinorista() + " ";
        
        return aux;
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public double getPrecioMayorista() {
        return precioMayorista;
    }

    public void setPrecioMayorista(double precioMayorista) {
        this.precioMayorista = precioMayorista;
    }

    public double getPrecioMinorista() {
        return precioMinorista;
    }

    public void setPrecioMinorista(double precioMinorista) {
        this.precioMinorista = precioMinorista;
    }
    
    
}
