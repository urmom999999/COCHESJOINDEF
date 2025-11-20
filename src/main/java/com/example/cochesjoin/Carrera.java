package com.example.cochesjoin;

public class Carrera {
    public static int siguientePosicion = 0;
    private static MainController controller;
    public static void setController(MainController controller) {
        Carrera.controller = controller;
    }

public static synchronized void ganadores(Coche coche) {
    siguientePosicion++;
    coche.posicion=siguientePosicion;
    System.out.println(coche.nombre + " terminó la carrera en la posicion: "+ coche.posicion +"!");
    String mensajeFinal= coche.nombre + " terminó la carrera en la posicion: "+ coche.posicion +"!";
    controller.agregarResultado(mensajeFinal);
    //AÑADIRLO Y MOSTRAR EN EL TEXT?
    if(!coche.fin){
        coche.posicion=siguientePosicion;
        if(!Coche.fin){
        if(siguientePosicion>=4){
            System.out.println("Carrera terminada!");
            coche.fin=true;
        }}
    }
}
}
