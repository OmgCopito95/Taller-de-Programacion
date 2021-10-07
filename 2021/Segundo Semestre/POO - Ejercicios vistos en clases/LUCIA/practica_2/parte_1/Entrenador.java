/*Definir una clase para representar entrenadores de un club de fútbol.
Un entrenador se caracteriza por su nombre, sueldo básico y la cantidad de campeonatos ganados.

A) Defina métodos para obtener/modificar el valor de cada atributo.

B) Defina el método calcularSueldoACobrar que calcula y devuelve el sueldo a cobrar
por el entrenador. El sueldo se compone del sueldo básico,
al cual se le adiciona un plus por campeonatos ganados (5000$ si ha ganado entre 1 y 4 campeonatos; 
$30.000 si ha ganado entre 5 y 10 campeonatos; 50.000$ si ha ganado más de 10 campeonatos).
 */
package LUCIA.practica_2.parte_1;

public class Entrenador {
    private String nombre;
    private int sueldoBasico;
    private int cantCampeonatosGanados;
    
    public Entrenador(){     //CONSTRUCTOR NULO
                
    }
    
    public Entrenador (String nombre, int sueldoBasico, int cantCampeonatosGanados){   //CONSTRUCTOR
        this.nombre= nombre;
        this.sueldoBasico= sueldoBasico;
        this.cantCampeonatosGanados= cantCampeonatosGanados;
    }
    
    
    public void setNombre(String nombre){          //SETTERS Y GETTERS     ----INCISO A-----
        this.nombre= nombre;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setSueldoBasico (int sueldoBasico){
        this.sueldoBasico= sueldoBasico;
    }
    
    public int getSueldoBasico(){
        return sueldoBasico;
    }
    
    public void setCantCampeonatosGanados(int cantCampeonatosGanados){
        this.cantCampeonatosGanados= cantCampeonatosGanados;
    }
    
    public int getCantCampeonatosGanados (){
        return cantCampeonatosGanados;
    }
        
    //----------- INCISO B -----------//
    public double calcularSueldoACobrar (int sueldo){     //EN REALIDAD NO VIENE NINGUN PARAMETRO, SIMPLEMENTE DEVOLVES
        if ((this.getCantCampeonatosGanados() >= 1) && (this.getCantCampeonatosGanados() <= 4)){
            sueldo= (this.getSueldoBasico() + 5000);  //estaria bien this.getSueldoBasico=(this.getSueldoBasico() + 5000); o deberia setearse?  //NO, SINO ESTARIAS MODIFICANDO EL SUELDO BASICO
        }            
            else{
                if ((this.getCantCampeonatosGanados() >= 5) && (this.getCantCampeonatosGanados() <= 10)){
                   sueldo= (this.getSueldoBasico() + 30000);
                }                    
                else{
                    if ((this.getCantCampeonatosGanados() >10)){
                      sueldo= (this.getSueldoBasico() + 50000);
                    }
                }
            }
        return sueldo;
    }
}
