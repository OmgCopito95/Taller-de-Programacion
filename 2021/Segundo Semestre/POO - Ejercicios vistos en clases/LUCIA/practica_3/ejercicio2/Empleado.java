/*
 */
package LUCIA.practica_3.ejercicio2;
public abstract class Empleado {
    private String nombre;
    int sueldoBasico;
    
    
     //========= CONSTRUCTOR  =========//
    public Empleado (String nombre, int sueldoBasico ){    
        this.nombre= nombre;
        this.sueldoBasico= sueldoBasico;        
    }
    
    //========= GETTERS Y SETTERS  =========//
    public String getNombre() {       
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getSueldoBasico() {
        return sueldoBasico;
    }

    public void setSueldoBasico(int sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }
        
    //========= METODO ABSTRACTO =========//
    public abstract int calcularSueldoACobrar();
    
    //========= TO STRING =========// 
    @Override
    public String toString(){
        return "El empleado "+this.getNombre()+" tiene un sueldo de $"+this.calcularSueldoACobrar();
                
    }
        
}

//no hace falta el override