package edu.ntnu.idatt2003.cardgame;

import edu.ntnu.idatt2003.cardgame.controller.Controller;
import edu.ntnu.idatt2003.cardgame.view.View;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        View view = new View();
        new Controller(view);
        view.start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
