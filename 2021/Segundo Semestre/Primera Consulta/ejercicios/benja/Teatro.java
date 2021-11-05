/*
 





 */
package parcial;



public class Teatro {
    
    private String titulo;
    private String fecha;
    private String hora;
    private Espectador espectador [][];
    private int dimF;
    private int dimC;           
    private int diml[];

    
    
    public Teatro (String unTitulo,String unaHora,String unaFecha){
        
        this.setTitulo(unTitulo);
        this.setFecha(unaFecha);
        this.setHora(unaHora);
        
        this.espectador = new Espectador [20][10];
        
        for (int i=0;i<20;i++){
            for (int j=0;j<10;j++){  // sala vacia
                this.espectador[i][j]=null;
            }
        }
        diml = new int [20];
        for (int i=0;i<20;i++){
            diml[i]=0;
        }            
        this.dimF=20;
        this.dimC=10;
    }
    
    public Teatro (){
        
    }
    
    public boolean validarFila (int F){
        
       return F >= 1 && F <= this.dimF;
       
    }
    
    public boolean hayButacaLibreEnFila (int F){
        
        return this.diml[F] < this.dimC;
        
    }
    
    public int devolverButaca (int F){ //metodo de ayuda propio
         
     return (this.diml[F]);
                     
    }
    
    
    public void agregarEspectadorAFila (int F,Espectador E){
        
       if (this.hayButacaLibreEnFila(F)) {           
           espectador[F][this.diml[F]]= E;           
           this.diml[F]++;                      
       }         
    }
    
    public boolean hayEspacio (){  //metodo de ayuda propio              
        
        return this.calcularButacasLibres() != 0;        
        
    }
    
    
    public int calcularButacasLibres (){
    int cant=0;    
                
        for (int i=0;i<20;i++){
            if (this.hayButacaLibreEnFila(i)){                
                for (int j=this.diml[i];j < 10; j++){
                    cant++;
                }                    
            }            
        }
         return cant;       
    }
    
    
    public int cantidadDeEspectadores (){ //metodo propio
    int cant=0;    
       for (int i=0;i<20;i++){
           cant = cant + this.diml[i];           
       } 
        return cant;
    }
    
    public double calcularEdadPromEspectadores (){
    int cant=0;
        
    for (int i=0;i<this.dimF;i++){                                                                  
              for (int j =0;j<this.diml[i];j++){
                     cant = cant+this.espectador[i][j].getEdad();                        
                    }
                                    
    }                    
      return cant/this.cantidadDeEspectadores();      
    }
    
    public boolean estaRegistrado (int D) {
    boolean aux=false;
    int i=0,j;
    while ((i < this.dimF) && (aux)) {   
       j = 0;  
       while ((j < this.dimC) && (aux)) {   
          if (this.espectador[i][j].getDni() == D) {                   
                 aux = true;
           }
           j++;   
            }
       i++;   
     }    
      return aux;        
    }
    
    
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
            
    
    
}
