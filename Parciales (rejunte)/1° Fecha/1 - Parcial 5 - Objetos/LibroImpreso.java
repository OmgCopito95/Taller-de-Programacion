package parcial5;

public class LibroImpreso extends Libro{
    private boolean tapaDura;
    
    public LibroImpreso(String unTitulo , double unPrecioBase , boolean unaTapa){
        super(unTitulo,unPrecioBase);
        this.setTapaDura(unaTapa);
    }
    
    public double calcularPrecioFinal(){
        double total = super.getPrecioBase();
        
        if (this.getTapaDura() == true){
            total += 500;
        }
        
        return total;
    }
    
    public boolean getTapaDura() {
        return tapaDura;
    }

    public void setTapaDura(boolean tapaDura) {
        this.tapaDura = tapaDura;
    }
    
    
}
