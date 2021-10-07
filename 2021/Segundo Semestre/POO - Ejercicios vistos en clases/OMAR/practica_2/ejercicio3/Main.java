package OMAR.practica_2.ejercicio3;

//"Herbert Schildt"
//"John Horton"

import PaqueteLectura.*;

public class Main {

    public static void main(String[] args) {
        
        Autor a1 = new Autor();
        
        System.out.print("Ingrese el nombre del autor: ");
        a1.setNombreAutor(Lector.leerString());
        
        System.out.print("Ingrese la biografia del autor: ");
        a1.setBiografiaAutor(Lector.leerString());
        
        Libro libro1 = new Libro("Java: A Beginner's Guide", "Mcgraw-Hill", 2014, a1 , "978-0071809252", 21.72);
        Libro libro2 = new Libro("Learning Java by Building Android Games", "CreateSpace Independent Publishing", a1 , "978-1512108347");
        System.out.println(libro1.toString());
        System.out.println(libro2.toString());
        System.out.println("Precio del libro2: " + libro2.getPrecio());
        System.out.println("Año edición del libro2: " + libro2.getAñoEdicion());
        Libro libro3 = new Libro();
    }

}
