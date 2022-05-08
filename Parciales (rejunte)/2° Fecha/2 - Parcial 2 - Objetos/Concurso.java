package parcial.pkg2;

public class Concurso {
    private final int GENEROS = 5;
    
    private Alumno mConcurso[][];
    
    private int cantAlumnos;
    private int dimL[];
    
    public Concurso(int n){
        this.cantAlumnos = n;
        mConcurso = new Alumno[GENEROS][cantAlumnos];
        
        for (int i=0;i<GENEROS;i++){
            for(int j=0;j<n;j++){
                mConcurso[i][j] = null;
            }
        }
        
        dimL = new int[GENEROS];
        
        for (int i=0;i<GENEROS;i++){
            dimL[i] = 0;
        }
    }
    
    public void inscribirAlumno(Alumno a , int unGenero){
        mConcurso[unGenero][dimL[unGenero]] = a;
        dimL[unGenero]++;
    }
    
    public void asignarPuntaje(double unPuntaje , Alumno a){
        for (int i=0 ; i<GENEROS; i++){
            for (int j=0;j<cantAlumnos;j++){
                if ((mConcurso[i][j] != null)&&(mConcurso[i][j] == a)){
                    mConcurso[i][j].setPuntaje(unPuntaje);
                }
            }
        }
    }
    
    public int devolverGenero(){
        int max = -1;
        
        for (int i=0; i<GENEROS; i++){
            if(dimL[i] > max){
                max = i;
            }
        }
        return max;
    }
}
