/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso3;
import PaqueteLectura.Lector;

/*3- Una escuela de artes musicales arma coros con algunos de sus alumnos para participar
de ciertos eventos. Un coro tiene un director y alumnos como coristas. De los coristas se
conoce el nombre, el dni, la edad y el tono fundamental (un número entero). Del director
se conoce el nombre, el dni, la edad y la antigüedad (un número entero). Los coros poseen
un nombre y están formados por un director y una serie de coristas. Asimismo pueden
formarse de dos formas: o bien los coristas se colocan en el escenario uno al lado del otro
formando un semicírculo, o bien conforman hileras de la misma cantidad de coristas.
a. Implemente el modelo de clases teniendo en cuenta que los coros deberían crearse con
un director y sin ningún corista, pero sí sabiendo cuantos coristas va a tener el coro.
b. Implemente métodos (en las clases donde corresponda) que permitan:
 agregar un corista a un coro.
o En el coro semicircular los coristas se deben ir agregando de izquierda
a derecha
o En el coro por hileras los coristas se deben ir agregando de izquierda a
derecha completando la hilera antes de pasar a la siguiente,
comenzando por la hilera de adelante.
 determinar si un coro está lleno o no. Devuelve true si el coro tiene a todos sus
coristas asignados o false en caso contrario.
 determinar si un coro (se supone que está lleno) está bien formado. Un coro
está bien formado si:
o En el caso del coro semicircular, de izquierda a derecha los coristas
están ordenados de mayor a menor en cuanto a tono fundamental.
o En el caso del coro por hileras, desde adelante hacia atrás los coristas
están ordenados de mayor a menor en cuanto a tono fundamental y
todos los miembros de una misma hilera tienen el mismo tono
fundamental.
 devolver la representación de un coro formada por el nombre del coro, todos
los datos del director y todos los datos de todos los coristas.Taller de Programación 2021 – Módulo POO
c. Escriba un programa que instancie cuatro coros y que los vaya almacenando en un
arreglo. El tipo de cada uno de los cuatro coros es leído por teclado. Una vez leído el
tipo de coro se deberá leer o bien la cantidad de coristas (en el caso del coro
semicircular) o la cantidad de hileras e integrantes por hilera (en el caso del coro por
hileras). Luego se deberá crear la cantidad de coristas necesarios, leyendo sus datos, y
almacenándolos en el coro. Finalmente imprima toda la información de los cuatro
coros indicando si están bien formados o no.
 * @author debodiaz
 */
public class Repaso3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {//no pide ingresar nombre del director,uso constructor nulo??
        //esta bien que todos se llamen unCoro?
        Coro[] vector = new Coro[4];
        String aux="";
        for (int i = 0; i < 4; i++) {
            System.out.println("Ingrese el tipo de coro: semicircular o hilera");
            aux = Lector.leerString();
            if(aux.equals("semicircular")){
                coroSemicircular unCoro = new coroSemicircular();
                System.out.println("Ingrese cantidad de corista");
                unCoro.setCantCoristas(Lector.leerInt());
               
            }
            else{ 
                coroHilera unCoro = new coroHilera();
                System.out.println("Ingrese cantidad de hileras");
 
                unCoro.setCantHileras(Lector.leerInt());
                System.out.println("Ingrese cantidad de corista por hilera");
                unCoro.setCorxHilera(Lector.leerInt());
             
            }
             vector[i]= unCoro;
             
             
        }
        /* Luego se deberá crear la cantidad de coristas necesarios, leyendo sus datos, y
almacenándolos en el coro. Finalmente imprima toda la información de los cuatro
coros indicando si están bien formados o no. */
        //Como seteo los coristas(vector dentro de un vector)?
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < vector[i].getCantCoristas(); j++) {
                vector[i].agregarCorista();
               
                System.out.println("ingrese nombre del corista");
                vector[i].coristas.setNombreCorista(Lector.leerString());
                System.out.println("ingrese dni del corista");
                vector[i].setNombreCorista(Lector.leerInt());
                System.out.println("ingrese edad del corista");
                vector[i].setNombreCorista(Lector.leerInt());
                System.out.println("ingrese tono fundamental del corista");
                vector[i].setNombreCorista(Lector.leerInt());
    
            
        }
        
            
    }
    
}
}
