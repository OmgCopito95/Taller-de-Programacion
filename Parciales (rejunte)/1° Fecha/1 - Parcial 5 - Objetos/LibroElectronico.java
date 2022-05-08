package parcial5;

public class LibroElectronico extends Libro{
    private String formato;
    private double tamaño;
    
    public LibroElectronico(String unTitulo , double unPrecioBase , String unFormato , double unTamaño){
        super(unTitulo,unPrecioBase);
        this.setFormato(unFormato);
        this.setTamaño(unTamaño);
    }
    
    public double calcularPrecioFinal(){
        return (super.getPrecioBase() + (2.5*tamaño));
    }
    
    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }
    
    
    
    
}
