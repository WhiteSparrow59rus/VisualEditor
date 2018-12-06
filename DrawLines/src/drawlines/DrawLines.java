/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package drawlines;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
/**
 *
 * @author Potapov-VI
 */
public class DrawLines extends Application {
    @Override // Override the start method in the Application class
    public void start(Stage primaryStage) {
        // Create a pane
        Pane pane = new Pane();

        // Create object to draw lines upon KeyEvent
        LineDrawingObject lineDrawingObject = new LineDrawingObject(20, Color.BLACK,
            pane.getWidth() / 2, pane.getWidth() / 2);
        pane.getChildren().add(lineDrawingObject);
        lineDrawingObject.setOnKeyPressed(e -> {
            lineDrawingObject.paintLine(e.getCode());
        });

        // Create a scene and place it in the pane
        Scene scene = new Scene(pane, 250, 250);
        primaryStage.setTitle("DrawLines"); // Set the stage title
        primaryStage.setScene(scene); // Place the scene in the stage
        primaryStage.show(); // Display the stage

        // Allow object to receive key input
        lineDrawingObject.requestFocus();
    }
     public static void main(String[] args) { 
     launch(args); 
    }
}
