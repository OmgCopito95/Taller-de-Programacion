/*4-A- Generar una clase para representar círculos. Los círculos se caracterizan por su radio
(double), el color de relleno (String) y el color de línea (String). El círculo debe saber:
▪ Devolver/modificar el valor de cada uno de sus atributos (get# y set#)
▪ Calcular el área y devolverla. (método calcularArea)
▪ Calcular el perímetro y devolverlo. (método calcularPerimetro)
NOTA: la constante PI es Math.P
*/
package CHECHU.practica_2;

public class Circulo {
    private double radio;
    private String colorRelleno;
    private String colorLinea;

public Circulo() { //CONSTRUCTOR NULO
    
}    
//----------SET---------

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public void setColorRelleno(String colorRelleno) {
        this.colorRelleno = colorRelleno;
    }

    public void setColorLinea(String colorLinea) {
        this.colorLinea = colorLinea;
    }
//----------GET----------

    public double getRadio() {
        return radio;
    }

    public String getColorRelleno() {
        return colorRelleno;
    }

    public String getColorLinea() {
        return colorLinea;
    }
   public double calcularArea(){
    return Math.PI* radio * radio;
}
   public double calcularPerimetro() {
        return 2 * Math.PI * radio;
   }
   
}//del CLASS
