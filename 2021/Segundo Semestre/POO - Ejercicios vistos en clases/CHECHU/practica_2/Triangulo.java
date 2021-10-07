/*
1- A- Definir una clase para representar triángulos. Un triángulo se caracteriza por el
tamaño de sus 3 lados (double), el color de relleno (String) y el color de línea (String).
El triángulo debe saber:
▪ Devolver/modificar el valor de cada uno de sus atributos (métodos get# y set#)
▪ Calcular el área y devolverla (método calcularArea)
▪ Calcular el perímetro y devolverlo (método calcularPerimetro)
 */
package CHECHU.practica_2;


public class Triangulo {
    //Atributos
    private double ladoUno; 
    private double ladoDos;
    private double ladoTres; 
    private String colorRelleno;
    private String colorLinea;
 
    public Triangulo(){
    //CONSTRUCTOR VACÍO
    }
    //Método - Constructor con parámetros formales
    
    public Triangulo (double ladoUno,double unladoDos,double unladoTres,String uncolorRelleno, String uncolorLinea){
        this.ladoUno = ladoUno;
        ladoDos = unladoDos;        //USAR LOS THIS
        ladoTres = unladoTres;
        colorRelleno = uncolorRelleno;
        colorLinea = uncolorLinea;
    } // del public Triangulo con los parametros
     
 
    
    //_________GETS_______
    public double getLadoUno() {
        return ladoUno;
    }

    public double getLadoDos() {
        return ladoDos;
    }

    public double getLadoTres() {
        return ladoTres;
    }
    public String getRelleno() {
        return colorRelleno;
    }
    public String getLinea() {
        return colorLinea;
    }
    //___________SETS______________________
  
    public void setLadoUno(double unLadoUno) {
        ladoUno = unLadoUno;
    }

    public void setLadoDos(double unLadoDos) {
        ladoDos = unLadoDos;
    }

    public void setLadoTres(double unLadoTres) {
        ladoTres = unLadoTres;
    }
    public void setRelleno(String uncolorRelleno) {
        colorRelleno = uncolorRelleno;
    }
    public void setLinea(String uncolorLinea) {
        colorLinea = uncolorLinea;
    }
    
    //______COMPORTAMIENTOS________
    public double calcularArea() {
        double s = (ladoUno+ladoDos+ladoTres)/2;
        return Math.sqrt(s*(s-ladoUno)*(s-ladoDos)*(s-ladoTres));
    }
    
    public double calcularPermitero() {
    return ladoUno + ladoDos+ ladoTres;
    }
} //del public Class

