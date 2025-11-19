package com.example.cochesjoin;

public class Coche extends Thread{
    public String nombre;
    int distanciaRecorrida;
    int velocidadMaxima;
    public int posicion;

    public static boolean fin = false;
    private static final int distanciaCircuito=20;


    public Coche(String nombre, int velocidadMaxima,int distanciaRecorrida){
        this.nombre=nombre;
        this.velocidadMaxima=velocidadMaxima;
        this.distanciaRecorrida=distanciaRecorrida;
        this.posicion=0;
    }

//Recorrer y determinar resultados cada minuto.
    @Override
    public void run(){
int tiempo=0;
        while(fin!=true){
        //Calculo velocidad media
            int velocidadMedia = (int) (Math.random() * velocidadMaxima);
            try {
                tiempo++;
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            //Calcular distancia recorrida
            double distanciaTramo=(velocidadMedia / 60.0 );
            distanciaRecorrida += distanciaTramo;

            int espacios=distanciaCircuito-distanciaRecorrida;
            if (espacios<0){espacios=0;};
//Devolver el resultado tras un minuto?
        System.out.println(nombre + " a velocidad media de " + velocidadMedia + "km/h tras "+ tiempo +" minutos de carrera recorrió  "+ distanciaRecorrida +" kilometros! Principio:" + ("=").repeat(distanciaRecorrida) +"💨🚗"+("_").repeat(espacios)+":Fin");
            //System.out.println("Tras "+ tiempo +" minuto de carrera:");
            //Comparar velocidad de cada coche
            //System.out.println(nombre+" recorrió "+ distanciaRecorrida + " y esta en la posición "+ posicion +"! ");

if(distanciaRecorrida >= distanciaCircuito){
    Carrera.ganadores(this);
    break;

}

       }

    }}
