package repaso;
/*
1- Genere las clases necesarias. Implemente constructores para iniciar el concurso sin alumnos inscriptos, recibiendo N 
(el máximo de alumnos por género musical). Los alumnos deben instanciarse dando valor a todos sus atributos.

2- Implemente métodos en las clases que corresponda para permitir:
a. Dado un alumno y un género musical válido, inscriba al alumno en dicho género. Asuma que hay lugar. 
b. Dado un nombre de alumno, devolver el instrumento que toca. NOTA: El alumno podría no estar inscripto en el concurso.
c. Devolver cuántos alumnos inscriptos en el concurso tocan un determinado instrumento que se recibe

3- Realice un programa que instancie un concurso con un máximo de 20 alumnos por género. Instancie 5 alumnos e inscriba 
a cada uno en algún género musical. Imprima el resultado de las consultas pedidas.
 */
public class Concurso {
  //  private String nombreGenero [];
    private Alumno inscripcionesGenero [][];
    private int vectorDF [];
    
    //CONSTRUCTORES
    public Concurso (int N){
      inscripcionesGenero = new Alumno [5][N]; //ASUMO QUE CADA POSICION SE INICIALIZA EN NULL
      vectorDF = new int [5]; //ASUMO QUE SE CADA POSICION SE INICIALIZA EN 0
    }
    
    //METODOS
    
    //a. Dado un alumno y un género musical válido, inscriba al alumno en dicho género. Asuma que hay lugar. 
    public boolean valido (int num){
      return num > 0 && num < 6;
    }
    
    public void Inscripcion (Alumno alumno, int numGenero){
      if (valido (numGenero)){
        inscripcionesGenero [numGenero - 1][vectorDF[numGenero - 1]] = alumno;
        vectorDF [numGenero - 1]++;
      }
    }
    //b. Dado un nombre de alumno, devolver el instrumento que toca. NOTA: El alumno podría no estar inscripto en el concurso.
    public String devolverInstrumento (String nombre){
      int i, j;
      String instrumento = null;
      boolean encontre = false;
      for (i=0; i<5 && !encontre; i++){
        for (j=0; j<vectorDF[i] && !encontre; j++){
          if (inscripcionesGenero[i][j].getNombre().equals(nombre)){
            encontre = true;
            instrumento = inscripcionesGenero[i][j].getInstrumento();
          }
       }
      }
      return instrumento;
    
    }
   // c. Devolver cuántos alumnos inscriptos en el concurso tocan un determinado instrumento que se recibe.
    public int cuantosTocanXInstrumento (String nomInstrumento){
      int i, j;
      int aux = 0;
      for (i=0; i<5; i++){
        for (j=0; j<vectorDF[i]; j++){
          if (inscripcionesGenero[i][j].getInstrumento().equals(nomInstrumento)){
            aux++;
          }
        }
      }
      return aux;
    
    }
}
