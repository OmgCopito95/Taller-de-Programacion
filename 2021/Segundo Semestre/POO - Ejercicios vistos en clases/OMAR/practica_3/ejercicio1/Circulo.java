public class Circulo extends Figura{
    
    private double radio;
    
    public Circulo(String colorRelleno, String colorLinea, double radio) {
        super(colorRelleno, colorLinea);
        this.radio = radio;
    }
    
    public double getRadio() {
        return this.radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    @Override
    public double calcularArea() {
        return Math.PI * Math.pow(this.radio, 2);
    }
    
    @Override
    public double calcularPerimetro() {
        return 2 * Math.PI * this.radio;
    }

    @Override
    public String toString() {
        return "Area: " + this.calcularArea() + " - Perimetro: " + this.calcularPerimetro() + " - Color Relleno: " + super.getColorRelleno() + " - Color Linea: " + super.getColorLinea() + super.getColorLinea() ;
    }
    
    //usar tostring de la super clase
//no hace falta el override
}
