/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso3;

/**
 *
 * @author debod
 */
public class Director {
    private String nombreDirector;
    private int dniDirector;
    private int edadDirector;
    private int antiguedad;
    
    public Director(){
        
    }
    public Director(String nomDirector){
        this.nombreDirector = nomDirector;
    }
    public String get_nombreDirector(){
        return this.nombreDirector;
    }
    public int get_dniDirector(){
        return this.dniDirector;
    }
    public int get_edadDirector(){
        return this.edadDirector;
    }
    public int get_antiguedad(){
        return this.antiguedad;
    }
    public void set_nombreDirector(String nombre){
        this.nombreDirector = nombre;
    }
            
    public void set_dniDirector(int dni){
        this.dniDirector = dni;
    }
            
    public void set_edadDirector(int edad){
        this.edadDirector = edad;
    }
    
    public void set_antiguedad(int anios){
        this.antiguedad = anios;
    }
}
