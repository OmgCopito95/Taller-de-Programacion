
package LUCIA.practica_2.parte_1;

public class Triangulo {
    
    //ATRIBUTOS
    private double lado1;
    private double lado2;
    private double lado3;
    private String colorLinea;
    private String colorRelleno;
   
    public Triangulo(){   //CONSTRUCTOR NULO
    }
    
    //CONSTRUCTOR
    public Triangulo(double lado1, double lado2, double lado3, String colorLinea, String colorRelleno){
        this.lado1= lado1;
        this.lado2= lado2;
        this.lado3= lado3;
        this.colorLinea= colorLinea;
        this.colorRelleno= colorRelleno;
    }

   //METODOS
    public void setLado1(double lado1){
        this.lado1 = lado1;
    }
    
    public double getLado1(){
        return lado1;
    }
            
    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }
    
     public double getLado2() {
        return lado2;
    }
     
    public void setLado3 (double lado3){
        this.lado3= lado3;
    }
    
    public double getLado3(){
        return lado3;
    }
        
    public void setColorL (String colorLinea){
        this.colorLinea= colorLinea;
    }
    
    public String getColorL (){
        return colorLinea;
    }
    
    public void setColorR(String colorRelleno){
        this.colorRelleno= colorRelleno;
    }
    
    public String getColorR(){
        return colorRelleno;
    }
    
    public double calcularArea(){
        double s= (lado1 + lado2 + lado3)/2;
        double area= (Math.sqrt(s*(s-this.getLado1())*(s-this.getLado2())*(s-this.getLado3())));
        return area;
    }
    
    public double calcularPerimetro(){
        double suma= this.getLado1()+this.getLado2()+this.getLado3();  //es lo ismo que lado1 + lado2 + lado3;
        return suma;
    }
    
   public String toString(){
       //String aux; 
      /* aux = */ return ("El area del triangulo es "+this.calcularArea()+" y el perimetro "+this.calcularPerimetro());//+calcularArea()+" es "+calcularPerimetro()";
       //return aux;
    } 
}
