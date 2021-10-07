/*
 
 */
package LUCIA.practica_3.ejercicio2;

public class Jugador extends Empleado {
    private int partidosJugados;
    private int nroGoles;

    
    //========= CONSTRUCTOR =========//   
    public Jugador(String nombre, int sueldoBasico, int partidosJugados, int nroGoles) {
        super(nombre, sueldoBasico);
        this.partidosJugados= partidosJugados;
        this.nroGoles= nroGoles;
    }
    
    //========= GETTERS Y SETTERS =========// 
    public int getPartidosJugados() {
        return partidosJugados;
    }

    public void setPartidosJugados(int partidosJugados) {
        this.partidosJugados = partidosJugados;
    }

    public int getNroGoles() {
        return nroGoles;
    }

    public void setNroGoles(int nroGoles) {
        this.nroGoles = nroGoles;
    }
    
    //========= CALCULAR SUELDO =========//  
    @Override
    public int calcularSueldoACobrar(){
        if ((this.getNroGoles()/this.getPartidosJugados())> 0.5){
            return this.sueldoBasico*2;
        }
        return this.sueldoBasico;
    }
   
    
    //========= TOSTRING =========//  
    @Override   
    public String toString (){
        return "JUGADOR// "+super.toString()+". Tiene "+this.getPartidosJugados()+" partidos jugados, con "+this.getNroGoles()+" goles ";
    }
    
}

//no hace falta el override