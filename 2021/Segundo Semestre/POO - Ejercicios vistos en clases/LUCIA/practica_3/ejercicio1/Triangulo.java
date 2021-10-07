/* Agregar la clase Triángulo a la jerarquía de figuras vista en clase
(paquete tema5 del proyecto). Triángulo debe heredar de Figura todo lo que es común 
y definir su constructor y sus atributos y métodos propios. Además debe redefinir el método toString.
 */
package LUCIA.practica_3.ejercicio1;

public class Triangulo extends Figura {
  private double lado1;
  private double lado2;
  private double lado3;

   
  public Triangulo (double lado1, double lado2, double lado3, String colorRelleno, String colorLinea){
      super(colorRelleno,colorLinea);  //NO SE USA THIS ¿POR QUE?, SE EVITA EL SETEO. EL SUPER VA EN PRIMERA LINEA
      this.lado1= lado1;
      this.lado2= lado2;
      this.lado3= lado3;
      
      //System.out.println("Color de relleno:", super.getColorRelleno());
       //this.setColorRelleno(colorRelleno);
      //this.setColorLinea(colorLinea);      
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

    
    public double calcularArea() {
        double s= (this.getLado1() + this.getLado2() + this.getLado3())/2;
        double area= (Math.sqrt(s*(s-this.getLado1())*(s-this.getLado2())*(s-this.getLado3())));
        return area;
    }

    public double calcularPerimetro() {
       return this.getLado1()+this.getLado2()+this.getLado3();  
    }
    
    
     public String toString(){
      return "El perimetro "+this.calcularPerimetro()+" "+super.toString();
  }
  
}
