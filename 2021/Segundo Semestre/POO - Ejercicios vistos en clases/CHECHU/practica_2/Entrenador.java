/*
3- A- Definir una clase para representar entrenadores de un club de fútbol. Un entrenador
se caracteriza por su nombre, sueldo básico y la cantidad de campeonatos ganados.
▪ Defina métodos para obtener/modificar el valor de cada atributo.
▪ Defina el método calcularSueldoACobrar que calcula y devuelve el sueldo a cobrar por
el entrenador. El sueldo se compone del sueldo básico, al cual se le adiciona un plus por
campeonatos ganados (5000$ si ha ganado entre 1 y 4 campeonatos; $30.000 si ha
ganado entre 5 y 10 campeonatos; 50.000$ si ha ganado más de 10 campeonatos).
 */
package CHECHU.practica_2;


public class Entrenador {
    private String nombre;
    private double sueldoBasico;
    private int campeonatosGanados;

public Entrenador() { //constructor nulo
}

public Entrenador(String nombre, double sueldoBasico, int campeonatosGanados) { //construc. con parametros formales
   this.nombre = nombre;
   this.sueldoBasico = sueldoBasico;
   this.campeonatosGanados = campeonatosGanados;
    }

//-------SET----------

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

    public void setCampeonatosGanados(int campeonatosGanados) {
        this.campeonatosGanados = campeonatosGanados;
    }

//-----------GET-------
    public String getNombre() {
        return nombre;
    }

    public double getSueldoBasico() {
        return sueldoBasico;
    }

    public int getCampeonatosGanados() {
        return campeonatosGanados;
    }

 public double calcularSueldoACobrar(){ //calcula y devuelve el sueldo a cobrar por el entrenador.
 switch (campeonatosGanados) {      //PODRIA HACERSE CON UN IF Y RANGOS
            case 0:
                return sueldoBasico;
            case 1:
            case 2:
            case 3:
            case 4:
                return sueldoBasico + 5000; //son $5000 si ha ganado entre 1 y 4 
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
                return sueldoBasico + 30000; //$30.000 si ha ganado entre 5 y 10 campeonatos
            default:
                return sueldoBasico + 50000;//50.000$ si ha ganado más de 10 campeonatos
        }
 }
 
}//del CLASS
