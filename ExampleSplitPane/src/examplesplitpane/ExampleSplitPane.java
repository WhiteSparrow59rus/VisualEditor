/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplesplitpane;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.SplitPane;

/**
 *
 * @author Potapov-VI
 */
public class ExampleSplitPane extends Application {
     
  @Override public void start(final Stage stage) throws Exception {
    StackPane r1 = new StackPane();
    r1.setPrefSize(200, 150);
    r1.setStyle("-fx-background-color: palegreen;");

    StackPane r2 = new StackPane();
    r2.setPrefSize(200, 150);
    r2.setStyle("-fx-background-color: coral;");

    SplitPane split = new SplitPane();
    split.getItems().setAll(
      r1, r2
    );
    split.setStyle("-fx-box-border: transparent;");

    StackPane layout = new StackPane();
    layout.getChildren().setAll(split);
    layout.setStyle("-fx-padding: 20px; -fx-background-color: cornsilk");

    stage.setScene(new Scene(layout));
    stage.show();
  }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
