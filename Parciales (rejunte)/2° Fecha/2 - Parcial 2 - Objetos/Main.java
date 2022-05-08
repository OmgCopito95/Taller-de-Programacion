package parcial.pkg2;

public class Main {

    public static void main(String[] args) {
        Concurso c = new Concurso(20);
        
        Alumno a1 = new Alumno("Nombre1",1,"Instrumento1");
        Alumno a2 = new Alumno("Nombre2",2,"Instrumento2");
        Alumno a3 = new Alumno("Nombre3",3,"Instrumento3");
        Alumno a4 = new Alumno("Nombre4",4,"Instrumento4");
        Alumno a5 = new Alumno("Nombre5",5,"Instrumento5");
        
        c.inscribirAlumno(a1, 0);
        c.inscribirAlumno(a2, 1);
        c.inscribirAlumno(a3, 2);
        c.inscribirAlumno(a4, 3);
        c.inscribirAlumno(a5, 4);
        
        c.asignarPuntaje(10, a1);
        c.asignarPuntaje(9, a2);
        c.asignarPuntaje(8, a3);
        c.asignarPuntaje(7, a4);
        c.asignarPuntaje(6, a5);
        
        System.out.println(c.devolverGenero());
        
        //System.out.println(a1.getPuntaje());
    }
    
}
