/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso3;

/**
 *
 * @author debod
 */
public class coroHilera extends Coro{

    private int cantHileras;
    private int corxHilera;
    private Corista [][] coristas;
    private int filaActual;
    private int columActual;
    private int totalCoristas;
    
    public coroHilera(){
        
    }
    public coroHilera(String nomDirector,int filas, int columnas ){
        super(nomDirector);
        this.cantHileras=filas;
        this.corxHilera=columnas;
        this.coristas = new Corista[this.cantHileras][this.corxHilera];
        this.filaActual=0;
        this.columActual=0;
        this.totalCoristas=0;
    }
    @Override
     public  int getCantCoristas() {
        return this.cantHileras*this.corxHilera;
    }
     public void setCantCoristas(int cantHilera,int corxhilera){
         this.totalCoristas = cantHilera * corxhilera;
     }
    public int getCantHileras() {
        return cantHileras;
    }

    public void setCantHileras(int cantHileras) {
        this.cantHileras = cantHileras;
    }

    public int getCorxHilera() {
        return corxHilera;
    }

    public void setCorxHilera(int corxHilera) {
        this.corxHilera = corxHilera;
    }

    public Corista[][] getCoristas() {
        return coristas;
    }

    public void setCoristas(Corista[][] coristas) {
        this.coristas = coristas;
    }

    public int getFilaActual() {
        return filaActual;
    }

    private void setFilaActual(int filaActual) {
        this.filaActual = filaActual;
    }

    public int getColumActual() {
        return columActual;
    }

    private void setColumActual(int columActual) {
        this.columActual = columActual;
    }
    
    private void actualizarHilera(){
        if(this.columActual == this.corxHilera){
            this.filaActual++;
            this.columActual=0;
        }
        else{
            this.columActual++;
            
        }
    }
    @Override
    public boolean estaLleno(){
        boolean aux = false;
        if (this.totalCoristas == this.getCantCoristas()){
            aux = true;
        }
        return aux;
    }
    
    public void agregarCorista(){
        Corista unCorista = new Corista();
        if (!this.estaLleno()){
            this.coristas[this.filaActual][this.columActual]= unCorista;
            this.actualizarHilera();
            this.totalCoristas++;
            
        }
    }
    
    @Override
    public boolean bienFormado(){
        boolean aux = false;
        int col=0 ;
        int fila =0;
        int min=-1 ;
        int tonoHilera=-1;
        if(this.estaLleno()){
            
             while(fila<this.cantHileras && tonoHilera == min ){
                 col=0;
                 tonoHilera = this.coristas[fila][col].getTonoFundamental();
                 if (min < tonoHilera){
                     min = tonoHilera;
                     while (col<this.corxHilera && tonoHilera == min  ){
                         col++;
                         if (col == this.corxHilera ) {
                             fila++ ;  
                         }
                          else{
                             tonoHilera = this.coristas[fila][col].getTonoFundamental(); 
                         }
                     } 
                 }
             }
             if (fila == this.cantHileras && col == this.corxHilera){
              aux = true;
             }  
        }
        return aux;
    }
    
    @Override
    public String datosCoristas(){
        String aux = "";
         for (int i = 0; i < this.getCantCoristas(); i++) {
             for (int j = 0; j < this.getCantCoristas(); j++) {
                 aux+="el nombre del corista es "+this.coristas[i][j].getNombreCorista()+" su dni es "+this.coristas[i][j].getDniCorista()+" su edad "+this.coristas[i][j].getEdadCorista()+"su tono es "+this.coristas[i][j].getTonoFundamental();
                 
             }
             
         }
         return aux;
    }
      
    
    @Override
    public String toString(){
        String aux = "";
        aux =super.toString()+""+this.datosCoristas();
        return aux;
    }
    
}
