/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LUCIA.practica_3.ejercicio2;

public class Entrenador extends Empleado {

    private int cantCampeonatosGanados;

    //========= CONSTRUCTOR =========//  
    public Entrenador(String nombre, int sueldoBasico, int cantCampeonatosGanados) {
        super(nombre, sueldoBasico);
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }

    //========= GETTERS Y SETTERS =========// 
    public int getCantCampeonatosGanados() {
        return cantCampeonatosGanados;
    }

    public void setCantCampeonatosGanados(int cantCampeonatosGanados) {
        this.cantCampeonatosGanados = cantCampeonatosGanados;
    }

    //========= CALCULAR SUELDO =========//       
    @Override
    public int calcularSueldoACobrar() {
        if ((this.getCantCampeonatosGanados() >= 1) && (this.getCantCampeonatosGanados() <= 4)) {
            return this.getSueldoBasico() + 5000;
        }
        if ((this.getCantCampeonatosGanados() >= 5) && (this.getCantCampeonatosGanados() <= 10)) {
            return this.getSueldoBasico() + 30000;
        }
        if (this.getCantCampeonatosGanados() > 10) {
            return this.getSueldoBasico() + 50000;
        } else {
            return this.getSueldoBasico();
        }
    }
    
    //========= TOSTRING =========//
    @Override
    public String toString() {
        return "ENTRENADOR// " + super.toString() + " tiene " + this.getCantCampeonatosGanados() + " campeonatos ganados";
    }

}

//no hace falta el override