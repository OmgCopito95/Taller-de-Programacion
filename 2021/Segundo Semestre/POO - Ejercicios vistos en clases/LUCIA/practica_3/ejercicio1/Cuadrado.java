package LUCIA.practica_3.ejercicio1;


public class Cuadrado extends Figura{
    
    private double lado;
    
    public Cuadrado(double unLado, String unColorR, String unColorL){
        super(unColorR,unColorL);
        this.setLado(unLado);

    } 
    
    public double getLado(){
        return lado;       
    }
  
    public void setLado(double unLado){
        lado=unLado;
    }

    public double calcularArea(){
       return (getLado()* getLado());
    }
    
    public double calcularPerimetro(){
       return (getLado()*4);
    }
    
    public String toString(){
       String aux = super.toString() + 
                    " Lado: " + getLado();
       return aux;
    }

 
}
