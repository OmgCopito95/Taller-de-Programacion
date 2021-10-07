/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CARO_ALONSO.practica_2;

/**
 *
 * @author Julieta
 */
public class Triangulo {

    //ATRIBUTOS
    private double lado1, lado2, lado3;
    private String color_relleno;
    private String color_linea;

    //CONSTRUCTORES
    public Triangulo() {  //MISMO NOMBRE DE LA CLASE    
    }

    public Triangulo(double lado1, double l2, double l3, String cr, String cl) {
        this.lado1 = lado1;
        this.lado2 = l2;
        this.lado3 = l3;
        this.color_relleno = cr;
        this.color_linea = cl;
    }

    //METODOS = COMPORTAMIENTO DEL OBJETO

    public double getLado1() {
        return this.lado1;
    }

    public double getLado2() {
        return lado2;
    }

    public double getLado3() {
        return lado3;
    }

    public String getColor_relleno() {
        return color_relleno;
    }

    public String getColor_linea() {
        return color_linea;
    }

    public void setLado1(double lado1) {
        this.lado1 = lado1;
    }

    public void setLado2(double lado2) {
        this.lado2 = lado2;
    }

    public void setLado3(double lado3) {
        this.lado3 = lado3;
    }

    public void setColor_relleno(String color_relleno) {
        this.color_relleno = color_relleno;
    }

    public void setColor_linea(String color_linea) {
        this.color_linea = color_linea;
    }
    
    
    
    
}
