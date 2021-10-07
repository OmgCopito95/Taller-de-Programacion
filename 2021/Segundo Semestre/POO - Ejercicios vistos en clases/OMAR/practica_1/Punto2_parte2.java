package OMAR.practica_1; 
import PaqueteLectura.*;

public class Punto2_parte2 {
    
    public static void main(String[] args) {
        
        GeneradorAleatorio.iniciar();
        
        Persona vPersonas[] = new Persona[5];
        Persona p;
        
        int cantMayores = 0;
        
        Persona pDniMenor = new Persona();
        pDniMenor.setDni(9999);
        pDniMenor.setEdad(9999);
        pDniMenor.setNombre("ZZZ");
        int pos = -1;
        
        for (int i = 0; i < vPersonas.length; i++) {           
            p = new Persona(); //Creo un objeto de tipo Persona
            p.setNombre(GeneradorAleatorio.generarString(10)); //Le mando el nombre a través del método set
            p.setEdad(GeneradorAleatorio.generarInt(91)); //Le mando la edad a través del método set
            p.setDni(GeneradorAleatorio.generarInt(901)); //Le mando el dni a través del método set
            vPersonas[i] = p; //Una vez seteados los datos, los guardo en el vector
        }
        
        for (int i = 0; i < vPersonas.length; i++) {
            if (vPersonas[i].getEdad() > 65) {
                cantMayores += 1;
            }
            if (vPersonas[i].getDni() < pDniMenor.getDni()) {
                pDniMenor.setDni(vPersonas[i].getDni());
                pDniMenor.setEdad(vPersonas[i].getEdad());
                pDniMenor.setNombre(vPersonas[i].getNombre());
                pos = i;
            }
        }

        //SE DEBE USAR EL METODO TOSTRING
        for (int i = 0; i < vPersonas.length; i++) {
            System.out.println("NOMBRE: " + vPersonas[i].getNombre()); //Obtengo los datos del objeto Persona a través del método get 
            System.out.println("EDAD: " + vPersonas[i].getEdad()); //Obtengo los datos del objeto Persona a través del método get 
            System.out.println("DNI: " + vPersonas[i].getDni()); //Obtengo los datos del objeto Persona a través del método get 
            System.out.println("");
        }

        System.out.println("");
        System.out.println("LA CANTIDAD DE PERSONAS MAYORES A 65 AÑOS ES: " + cantMayores);
        System.out.println("REPRESENTACIÓN DE LA PERSONA CON MENOR DNI: " + pDniMenor.toString());
    }
}
