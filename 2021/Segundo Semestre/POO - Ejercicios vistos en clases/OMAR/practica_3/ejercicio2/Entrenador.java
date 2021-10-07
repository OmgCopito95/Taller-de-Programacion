package OMAR.practica_3.ejercicio2;


public class Entrenador extends Empleado{

    private int cantCampeonatos;

    public Entrenador(String nombreEmpleado, double sueldoBasicoEmpleado, int cantCampeonatos) {
        super(nombreEmpleado, sueldoBasicoEmpleado);
        this.cantCampeonatos = cantCampeonatos;
    }

    public int getCantCampeonatos() {
        return cantCampeonatos;
    }

    public void setCantCampeonatos(int cantCampeonatos) {
        this.cantCampeonatos = cantCampeonatos;
    }

    @Override
    public String toString() {
        return super.toString() + " - Campeonatos Ganados: " + this.cantCampeonatos;
    }
    
    @Override
    public double calcularSueldoACobrar() {
        double plus = 0;
        if ( (this.cantCampeonatos >= 1) && (this.cantCampeonatos <= 4) ) {
            plus = sueldoBasicoEmpleado + 5000;
        } else if ( (this.cantCampeonatos >= 5) && (this.cantCampeonatos <= 10) ) {
            plus = sueldoBasicoEmpleado + 30000;
        } else if ((this.cantCampeonatos > 10)) {
            plus = sueldoBasicoEmpleado + 50000;
        }
        
        return plus;
    }
}

//no hace falta el override