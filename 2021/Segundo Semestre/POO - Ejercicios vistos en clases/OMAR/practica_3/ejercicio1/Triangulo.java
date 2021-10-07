
public class Triangulo extends Figura{

    private double lado1;
    private double lado2;
    private double lado3;

    public Triangulo(String colorRelleno, String colorLinea, double lado1, double lado2, double lado3) {
        super(colorRelleno, colorLinea);
        this.lado1 = lado1;
        this.lado2 = lado2;
        this.lado3 = lado3;
    }

    public double getLado1() {
        return lado1;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }
    
    @Override
    public double calcularArea() {
        double s = (this.lado1 + this.lado2 + this.lado3)/2;
        return Math.sqrt(s*(s-this.lado1)*(s-this.lado2)*(s-this.lado3));
    }

    @Override
    public double calcularPerimetro() {
        return this.lado1 + this.lado2 + this.lado3;
    }

    @Override
    public String toString() {
        return "Area: " + this.calcularArea() + " - Perimetro: " + this.calcularPerimetro() + " - Color Relleno: " + super.getColorRelleno() + " - Color Linea: " + super.getColorLinea();
    }//usar tostring de la super clase
    
}
