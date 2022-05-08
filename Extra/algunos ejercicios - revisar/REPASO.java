package repaso;
/*
Una escuela de música necesita un sistema para realizar un concurso entre sus alumnos. 
El concurso está dividido en cinco géneros musicales y en cada género se pueden inscribir hasta N alumnos como máximo. 

De cada alumno registra su nombre, edad, el instrumento que toca y puntaje obtenido. 
1- Genere las clases necesarias. Implemente constructores para iniciar el concurso sin alumnos inscriptos, recibiendo N 
(el máximo de alumnos por género musical). Los alumnos deben instanciarse dando valor a todos sus atributos.
2- Implemente métodos en las clases que corresponda para permitir:
a. Dado un alumno y un género musical válido, inscriba al alumno en dicho género. Asuma que hay lugar. 
b. Dado un nombre de alumno, devolver el instrumento que toca. NOTA: El alumno podría no estar inscripto en el concurso.
c. Devolver cuántos alumnos inscriptos en el concurso tocan un determinado instrumento que se recibe.
3- Realice un programa que instancie un concurso con un máximo de 20 alumnos por género. Instancie 5 alumnos e inscriba 
a cada uno en algún género musical. Imprima el resultado de las consultas pedidas.
 */
public class REPASO {
  public static void main(String[] args) {
    Concurso concurso = new Concurso (3);
    
    //INCRIPCION
    concurso.Inscripcion(new Alumno ("Ramon", 23,"piano",7.9), 1);
    concurso.Inscripcion(new Alumno ("Marlen", 19,"bandolina",9.9), 4);
    concurso.Inscripcion(new Alumno ("Ivan", 21,"piano",8.3), 4);
    concurso.Inscripcion(new Alumno ("Victoria", 16,"piano",5.9), 2);
    concurso.Inscripcion(new Alumno ("Tamara", 17,"guitarra",6.9), 1);
    
    //IMPRIMIR
    System.out.println("Marlen toca la "+concurso.devolverInstrumento("Marlen"));
    System.out.println("Hay "+concurso.cuantosTocanXInstrumento("piano")+" alumnos que tocan el piano");
  }
    
}
