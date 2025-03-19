package edu.ntnu.idatt2003.cardgame;

import edu.ntnu.idatt2003.cardgame.controller.Controller;
import edu.ntnu.idatt2003.cardgame.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * The main class for the card game application.
 * This class launches the JavaFX application.
 */
public class Main extends Application {

    /**
     * Starts the JavaFX application.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) {
        View view = new View();
        new Controller(view);
        view.start(primaryStage);
    }

    /**
     * The main method to launch the application.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
