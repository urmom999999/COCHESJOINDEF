package com.example.cochesjoin;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class MainController {
    @FXML
    private ImageView barrera;
    @FXML
    private Button buttonStart;

    @FXML
    private ImageView ferrariF40;
    @FXML
    private ImageView toyotaSupra;
    @FXML
    private ImageView subaruImpreza;
    @FXML
    private ImageView porscheTurbo;
    @FXML
    private Text textResulatados;

    private List<Coche> coches = new ArrayList<>();
    private boolean comenzado = false;



    @FXML
    private void initialize() {
        Carrera.setController(this);
        /*
        cocheVista.put("Ferrari F40", ferrariF40);
        cocheVista.put("Toyota Supra MK4", toyotaSupra);
        cocheVista.put("Subaru Impreza Sti", subaruImpreza);
        cocheVista.put("Porsche 911 Turbo", porscheTurbo);*/
        buttonStart.setOnAction(event -> {

            final int distancia = 0;
            Coche c1 = new Coche("Ferrari F40", 310, distancia, this);
            Coche c2 = new Coche("Toyota Supra MK4", 300, distancia, this);
            Coche c3 = new Coche("Subaru Impreza Sti", 300, distancia, this);
            Coche c4 = new Coche("Porsche 911 Turbo", 310, distancia, this);
//guardar
            coches.clear();
            coches.add(c1);
            coches.add(c2);
            coches.add(c3);
            coches.add(c4);

            System.out.println("Ha empezado la carrera!");
            comenzado = true;
            animacionStart();


            c1.start();
            c2.start();
            c3.start();
            c4.start();

            //Mientras que los 4 coches no terminaron
//HILO PARA MOSTRAR DATOS
            Thread monitorThread = new Thread(() -> {
                try {
                    c1.join();
                    c2.join();
                    c3.join();
                    c4.join();
                    System.out.println("Fin!");
                    resultadoFin();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            monitorThread.start();

//ACTUALIZAR HILO
            Thread actualizadorThread = new Thread(() -> {
                while (!fin()) {
                    try {
                        Thread.sleep(100);
                        actualizarTodo();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }}


                });
            actualizadorThread.start();

        });}
    //fin indice
        //________________________________________________________________
        public void actualizarPosicionCoche(String nombreCoche, double distanciaRecorrida) {
            ImageView imagenCoche = obtenerImageViewPorNombre(nombreCoche);
            if (imagenCoche != null) {
                double nuevaPosX = getPosicionInicial(nombreCoche) + (distanciaRecorrida * 50);
                imagenCoche.setLayoutX(nuevaPosX);
            }
        }

        private ImageView obtenerImageViewPorNombre(String nombreCoche) {
            switch (nombreCoche) {
                case "Ferrari F40": return ferrariF40;
                case "Toyota Supra MK4": return toyotaSupra;
                case "Subaru Impreza Sti": return subaruImpreza;
                case "Porsche 911 Turbo": return porscheTurbo;
                default: return null;
            }
        }

        private double getPosicionInicial(String nombreCoche) {
            switch (nombreCoche) {
                case "Ferrari F40": return 64.0;
                case "Toyota Supra MK4": return 48.0;
                case "Subaru Impreza Sti": return 37.0;
                case "Porsche 911 Turbo": return 26.0;
                default: return 50.0;
            }
        }

        private void actualizarTodo() {
            for (Coche coche : coches) {
                if (coche.isAlive() || coche.getDistanciaRecorrida() > 0) {
                    actualizarPosicionCoche(coche.nombre, coche.getDistanciaRecorrida());
                }
            }
        }

        private boolean fin() {
            for (Coche coche : coches) {
                if (coche.isAlive()) {
                    return false;
                }
            }
            return true;
        }

        private void resultadoFin() {
            StringBuilder resultados = new StringBuilder("RESULTADOS FINALES:\n\n");

            // Ordenar coches por posición (1º, 2º, 3º, 4º)
            for (int posicion = 1; posicion <= 4; posicion++) {
                for (Coche coche : coches) {
                    if (coche.posicion == posicion) {
                        String resultadoLinea = coche.nombre + " terminó en posición: " + coche.posicion + "!\n";
                        resultados.append(resultadoLinea);
                        break;
                    }
                }
            }

            // Actualizar el TextArea
            if (textResulatados != null) {
                javafx.application.Platform.runLater(() -> {
                    textResulatados.setText(resultados.toString());
                });
            }
        }

//_____________________________________________________________________

        public void agregarResultado (String mensaje) {
        if (textResulatados != null) {
            //Para Textarea
            Platform.runLater(() -> {
                String textoActual = textResulatados.getText();
                textResulatados.setText(textoActual + mensaje + "\n");
            });
        }
        }


    private void animacionStart(){

        fondoStart();
        //AÑADIR CARRETERASTART
    };
    //FONDO=========
    private void fondoStart(){
        double barreraComienzo = barrera.getLayoutX();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50), event->{
                    barrera.setLayoutX(barrera.getLayoutX()-30);
                    if(barrera.getLayoutX()<= (barreraComienzo -120)){
                        barrera.setLayoutX(barreraComienzo);
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); //LOOP
        timeline.play();}
};

