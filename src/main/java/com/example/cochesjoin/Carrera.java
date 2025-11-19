package com.example.cochesjoin;

public class Carrera {
    public static int siguientePosicion = 0;
public static void ganadores(Coche coche) {
    siguientePosicion++;
    coche.posicion=siguientePosicion;
    System.out.println(coche.nombre + " terminó la carrera en la posicion: "+ coche.posicion +"!");
    if(!coche.fin){
        coche.posicion=siguientePosicion;

        if(siguientePosicion>4){
            System.out.println("Carrera terminada!");
            coche.fin=true;
        }
    }
}
}
