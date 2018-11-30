/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualeditor_v1;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Potapov-VI
 */
public class VisualEditor_V1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
      
      
       Label first = new Label("First");
        Label second = new Label("Second");
        Label third = new Label("Third");
         
        GridPane root = new GridPane();
        root.getColumnConstraints().add(new ColumnConstraints(80));
        root.getColumnConstraints().add(new ColumnConstraints(150));
        root.getColumnConstraints().add(new ColumnConstraints(70));
         
        root.setGridLinesVisible(true); // делаем видимой сетку строк и столбцов
        root.setColumnIndex(first, 0);
        root.setColumnIndex(second, 1);
        root.setColumnIndex(third, 2);
        root.getChildren().addAll(first, second, third);
         
         
        Scene scene = new Scene(root, 300, 200);

        primaryStage.setTitle("Editor");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
