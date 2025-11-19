package com.example.cochesjoin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import javafx.scene.image.ImageView;

public class MainController {
    @FXML
    private ImageView barrera;
    @FXML
    private Button buttonStart;
    @FXML
    private Label welcomeText;
    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }


    @FXML
    private void initialize() {
        buttonStart.setOnAction(event -> {
            final int distancia = 0;
            Coche c1 = new Coche("Ferrari F40", 317, distancia);
            Coche c2 = new Coche("Toyota Supra MK4", 324, distancia);
            Coche c3 = new Coche("Subaru Impreza Sti", 340, distancia);
            Coche c4 = new Coche("Porsche 911 Turbo", 228, distancia);

            System.out.println("Ha empezado la carrera!");
            comenzado=true;
            animacionStart();


            c1.start();
            c2.start();
            c3.start();
            c4.start();

            //Mientras que los 4 coches no terminaron

        });
    }
    private boolean comenzado=false;

    private void animacionStart(){


        fondoStart();
    };
    private void fondoStart(){
        double barreraComienzo = barrera.getLayoutX();
        Timeline timeline = new Timeline(
                new KeyFrame(Duration.millis(50), event->{
                    barrera.setLayoutX(barrera.getLayoutX()-30);
                    if(barrera.getLayoutX()== (barreraComienzo -120)){
                        barrera.setLayoutX(barreraComienzo);
                    }
                })
        );
        timeline.setCycleCount(Timeline.INDEFINITE); // repeat forever
        timeline.play();

        comenzado = true;

    };
}
