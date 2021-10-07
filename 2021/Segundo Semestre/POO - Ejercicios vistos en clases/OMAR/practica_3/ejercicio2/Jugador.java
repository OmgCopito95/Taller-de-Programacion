package OMAR.practica_3.ejercicio2;


public class Jugador extends Empleado {

    private int cantPartidosJugados;
    private int cantGolesAnotados;
    
    public Jugador(String nombreEmpleado, double sueldoBasicoEmpleado, int cantPartidosJugados, int cantGolesAnotados) {
        super(nombreEmpleado, sueldoBasicoEmpleado);
        this.cantPartidosJugados = cantPartidosJugados;
        this.cantGolesAnotados = cantGolesAnotados;
    }

    public int getCantPartidosJugados() {
        return cantPartidosJugados;
    }

    public void setCantPartidosJugados(int cantPartidosJugados) {
        this.cantPartidosJugados = cantPartidosJugados;
    }

    public int getCantGolesAnotados() {
        return cantGolesAnotados;
    }

    public void setCantGolesAnotados(int cantGolesAnotados) {
        this.cantGolesAnotados = cantGolesAnotados;
    }

    @Override
    public String toString() {
        return super.toString() + " - Partidos jugados: " + this.cantPartidosJugados + " - Goles Anotados: " + this.cantGolesAnotados;
    }
    
    @Override
    public double calcularSueldoACobrar() {
        double promedio = (this.cantGolesAnotados / this.cantPartidosJugados);
        if (promedio > 0.5) {
            return sueldoBasicoEmpleado * 2;
        } else {
            return sueldoBasicoEmpleado;
        }
    }
}

//no hace falta el override