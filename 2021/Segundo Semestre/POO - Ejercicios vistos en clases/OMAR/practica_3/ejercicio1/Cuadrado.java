public class Cuadrado extends Figura{
    
    private double lado;
    
    public Cuadrado(String colorRelleno, String colorLinea, double lado) {
        super(colorRelleno, colorLinea);
        this.lado = lado;
    }
    
    public double getLado() {
        return this.lado;
    }
    
    public void setLado(double lado) {
        this.lado = lado;
    }
    
    @Override
    public double calcularArea() {
        return this.lado * this.lado;
    }
    
    @Override
    public double calcularPerimetro() {
        return this.lado * 4;
    }

    @Override
    public String toString() {
        return "Area: " + this.calcularArea() + " - Perimetro: " + this.calcularPerimetro() + " - Color Relleno: " + super.getColorRelleno() + " - Color Linea: ";
    }
    //usar tostring de la super clase
    
//no hace falta el override
}
