package OMAR.practica_3.ejercicio2;


public abstract class Empleado {

    protected String nombreEmpleado; //private
    protected double sueldoBasicoEmpleado;

    public Empleado(String nombreEmpleado, double sueldoBasicoEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
        this.sueldoBasicoEmpleado = sueldoBasicoEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public double getSueldoBasicoEmpleado() {
        return sueldoBasicoEmpleado;
    }

    public void setSueldoBasicoEmpleado(double sueldoBasicoEmpleado) {
        this.sueldoBasicoEmpleado = sueldoBasicoEmpleado;
    }

    @Override
    public String toString() {
        return "Nombre: " + this.nombreEmpleado + " - Sueldo básico: " + this.sueldoBasicoEmpleado;
    }
    
    public abstract double calcularSueldoACobrar();
}

//no hace falta el override