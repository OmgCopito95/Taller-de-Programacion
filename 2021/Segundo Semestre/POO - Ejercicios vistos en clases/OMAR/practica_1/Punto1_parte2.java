package OMAR.practica_1; 
import PaqueteLectura.*;

public class Punto1_parte2 {

    public static void main(String[] args) {
       
        Persona p = new Persona(); //Creamos una variable de tipo Persona y creamos o instanciamos un objeto de tipo Persona
        
        p.setNombre("Omar");
        p.setEdad(26);
        p.setDni(38638835);
        
        System.out.println(p.toString());
        
    }
}
