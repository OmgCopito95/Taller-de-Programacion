/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial;


public class Espectador {
    
    private String nombre;
    private int dni;
    private int edad;

    
    
    public Espectador (String unNombre,int unDni,int unaEdad){
        
      this.setNombre(unNombre);
      this.setDni(unDni);
      this.setEdad(unaEdad);
      
    }
    
    
    public Espectador (){
        
        
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }
    
    
    
    
    
    
    
    
}
