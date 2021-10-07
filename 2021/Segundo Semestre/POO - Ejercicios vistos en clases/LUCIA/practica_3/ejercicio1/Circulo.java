/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LUCIA.practica_3.ejercicio1;

/**
 *
 * @author Lucia
 */
public class Circulo extends Figura {
     private double radio;   
     
     public Circulo(double radio, String colorRelleno, String colorLinea){  //CONSTRUCTOR
        super (colorRelleno,colorLinea);
        this.radio= radio;
        
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

     
     
    @Override
    public double calcularArea() {
         double area= (Math.PI * (this.getRadio()*this.getRadio()));
        return area;
    }

    @Override
    public double calcularPerimetro() {
        double perimetro= (2* (Math.PI) * this.getRadio());
        return perimetro;
    }
    
     @Override
     public String toString(){
      return "Perimetro del CIRCULO: "+String.format("%.2f", this.calcularPerimetro())+" "+super.toString();
  }
     
}

//no hace falta el override