/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LUCIA.practica_3.ejercicio3;

public class Trabajador extends Persona {
    private String tarea;
    
    public Trabajador(String nombre,int DNI,int edad, String tarea){   //CONSTRUCTOR
        //this.setNombre(nombre);
        //this.setDNI(DNI);          
        //this.setEdad(edad);
        super(nombre,DNI,edad);
        this.tarea= tarea;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }
    
    public String toString(){
        return super.toString()+" Soy "+this.getTarea();
    }
}
