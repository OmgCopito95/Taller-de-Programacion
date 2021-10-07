
public abstract class Figura {

    protected String colorRelleno; //private
    protected String colorLinea;

    public Figura(String colorRelleno, String colorLinea) {
        this.colorRelleno = colorRelleno;
        this.colorLinea = colorLinea;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }

    @Override
    public String toString() {
        return "Area: " + this.calcularArea() + " - Perimetro: " + this.calcularPerimetro() + " - Color Relleno: " + this.getColorRelleno() + " - Color Linea: " + this.getColorLinea();
    }

    public abstract double calcularArea();

    public abstract double calcularPerimetro();

}
