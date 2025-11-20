package com.example.cochesjoin;

public class Coche extends Thread{
    public String nombre;
    int distanciaRecorrida;
    int velocidadMaxima;
    public int posicion;
    private final MainController controller;

    public static boolean fin = false;
    private static final int distanciaCircuito=19;


    public Coche(String nombre, int velocidadMaxima,int distanciaRecorrida,MainController controller){
        this.nombre=nombre;
        this.velocidadMaxima=velocidadMaxima;
        this.distanciaRecorrida=distanciaRecorrida;
        this.posicion=0;
        this.controller=controller;
    }

//Recorrer y determinar resultados cada minuto.
    @Override
    public void run(){
        while(!fin){
        //Calculo velocidad media
            int velocidadMedia = (int) (Math.random() * (velocidadMaxima -50));
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


            //Calcular distancia recorrida
            double distanciaTramo=(velocidadMedia / 100.0 );
            distanciaRecorrida += (int) distanciaTramo;
//MOSTRAR POSICIÓN VISUALMENTE
            controller.actualizarPosicionCoche(nombre, distanciaRecorrida);
            if (distanciaRecorrida >= distanciaCircuito && !fin) {
                Carrera.ganadores(this);
                break;
            }
        }
    }

    public double getDistanciaRecorrida() {
        return distanciaRecorrida;
    }
}

/*
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

    }}*/
