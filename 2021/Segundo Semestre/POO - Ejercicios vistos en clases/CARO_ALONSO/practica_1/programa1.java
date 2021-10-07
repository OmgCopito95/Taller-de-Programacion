/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CARO_ALONSO.practica_1;

import CARO_ALONSO.practica_2.Triangulo;

/**
 *
 * @author Julieta
 */
public class programa1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        GeneradorAleatorio.iniciar();
        
        double lado1 = GeneradorAleatorio.generarDouble(20);
        double lado2 = GeneradorAleatorio.generarDouble(20);       
        double lado3 = GeneradorAleatorio.generarDouble(20);
        String color = GeneradorAleatorio.generarString(10);        
        String linea = GeneradorAleatorio.generarString(10);
                
        Triangulo tri = new Triangulo(lado1, lado2, lado3, color, linea);  //instancia un objeto triangulo con valores iniciales
        
        System.out.println("Perímetro: "+ String.format("%.2f",tri.calcularPerimetro()));
        System.out.println("Area : "+ String.format("%.2f",tri.calcularArea()));       
        
    }
    
}
