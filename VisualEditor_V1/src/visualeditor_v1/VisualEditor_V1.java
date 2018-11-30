/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualeditor_v1;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 *
 * @author Potapov-VI
 */
public class VisualEditor_V1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
          
        Button first = new Button("First");
        // расположем кнопку в нижнем правом углу
        GridPane.setHalignment(first, HPos.LEFT);
        GridPane.setValignment(first, VPos.TOP);
         
        Button second = new Button("Second");
         
        // растянем кнопку по горизонтали
        second.setMaxWidth(Double.MAX_VALUE);
        GridPane.setHgrow(second, Priority.ALWAYS);
        GridPane.setValignment(second, VPos.TOP);
         
        Button third = new Button("Third");
        // растянем кнопку по горизонтали и вертикали
        third.setMaxWidth(Double.MAX_VALUE);
        third.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(third, Priority.ALWAYS);
        GridPane.setVgrow(third, Priority.ALWAYS);
         
        
        Rectangle rect = new Rectangle(200, 200, Color.RED);
        ScrollPane canvasscroll = new ScrollPane();
        
        canvasscroll.setContent(rect);

        canvasscroll.vvalueProperty().addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov,
              Number old_val, Number new_val) {
                  System.out.println(new_val.intValue());
          }
        });
        canvasscroll.hvalueProperty().addListener(new ChangeListener<Number>() {
          public void changed(ObservableValue<? extends Number> ov,
              Number old_val, Number new_val) {
                  System.out.println(new_val.intValue());
          }
      });        
        
        // кнопка заполняет все пространство ячейки
        canvasscroll.setMaxWidth(Double.MAX_VALUE);
        canvasscroll.setMaxHeight(Double.MAX_VALUE);
        GridPane.setHgrow(canvasscroll, Priority.ALWAYS);
        GridPane.setVgrow(canvasscroll, Priority.ALWAYS);
        // установим отступ в 10 единиц
        GridPane.setMargin(canvasscroll, new Insets(10));
         
         
        GridPane root = new GridPane();
         
        ColumnConstraints column1 = new ColumnConstraints(150);
        
        root.getColumnConstraints().add(column1);
         
        ColumnConstraints column2 = new ColumnConstraints();
        column2.setHgrow(Priority.ALWAYS);
        
        root.getColumnConstraints().add(column2);
         
        RowConstraints row1 = new RowConstraints(50);
        root.getRowConstraints().add(row1);
         
        RowConstraints row2 = new RowConstraints();
        
        row2.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(row2);
         
        root.setGridLinesVisible(true);
        root.add(first, 0, 0);
        root.add(second, 0, 1);
        root.add(third, 1, 0);
        root.add(canvasscroll, 1, 1);
         
         
        Scene scene = new Scene(root, 1000, 600);
      
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
