package com.example.cochesjoin;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class MainController {
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

            c1.start();
            c2.start();
            c3.start();
            c4.start();

            //Mientras que los 4 coches no terminaron

        });
    }
}
