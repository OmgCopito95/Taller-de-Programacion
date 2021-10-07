/* Generar una clase para representar círculos. Los círculos se caracterizan por su radio (double), 
el color de relleno (String) y el color de línea (String). El círculo debe saber:

A) Devolver/modificar el valor de cada uno de sus atributos (get# y set#)
B) Calcular el área y devolverla. (método calcularArea)
C) Calcular el perímetro y devolverlo. (método calcularPerimetro)

NOTA: la constante PI es Math.PI
 */
package LUCIA.practica_2.parte_1;

public class Circulo {
    
    private double radio;                //ATRIBUTOS
    private String colorRelleno;
    private String colorLinea;
    
    public Circulo(){                  //CONST5RUCTOR NULO   
    }
    
    public Circulo(double radio, String colorRelleno, String colorLinea){  //CONSTRUCTOR
        this.radio= radio;
        this.colorRelleno= colorRelleno;
        this.colorLinea= colorLinea;
    }
    
    public void setRadio (double radio){     //GETTERS Y SETTER ---INCISO A---
        this.radio= radio;
    }
    public double getRadio(){
        return radio;
    }
    
    public void setColorRelleno (String colorRelleno){
        this.colorRelleno= colorRelleno;
    }
    
    public String getColorRelleno (){
        return colorRelleno;
    }
    
    public void setColorLinea (String colorLinea){
        this.colorLinea= colorLinea;
    }
    
    public String getColorLinea (){
        return colorLinea;
    }
    
    public double calcularArea(){                      //------- INCISO B -------//
        double area= (Math.PI * (this.getRadio()*this.getRadio()));
        return area;
    }
    
    public double calcularPerimetro(){
        double perimetro= (2* (Math.PI) * this.getRadio());
        return perimetro;
    }
}
