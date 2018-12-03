/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplegridpane;

import javafx.application.Application; 
import javafx.geometry.VPos; 
import javafx.scene.Scene; 
import javafx.scene.control.Label; 
import javafx.scene.control.ScrollPane; 
import javafx.scene.control.TitledPane; 
import javafx.scene.layout.BorderPane; 
import javafx.scene.layout.GridPane; 
import javafx.scene.layout.RowConstraints; 
import javafx.scene.layout.VBox; 
import javafx.stage.Stage; 

/**
 *
 * @author Potapov-VI
 */
public class ExampleGridPane extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane(); 
     grid.add(createTitledPane("Pane 1"), 0, 0); 
     grid.add(createTitledPane("Pane 2"), 0, 2); 

     RowConstraints top = new RowConstraints(); 
     top.setValignment(VPos.TOP); 
     top.setPercentHeight(100.0/3.0); 

     RowConstraints middle = new RowConstraints(); 
     middle.setValignment(VPos.CENTER); 
     middle.setPercentHeight(100.0/3.0); 

     RowConstraints bottom = new RowConstraints(); 
     bottom.setValignment(VPos.BOTTOM); 
     bottom.setPercentHeight(100.0/3.0); 

     grid.getRowConstraints().addAll(top, middle, bottom); 

     BorderPane root = new BorderPane(new Label("Content"), null, grid, null, null); 
     primaryStage.setScene(new Scene(root, 800, 600)); 
     primaryStage.show(); 
    } 

    private TitledPane createTitledPane(String title) { 
     TitledPane expandable = new TitledPane(); 
     expandable.setText(title); 
     VBox content = new VBox(5); 
     for (int i=1; i<=20; i++) { 
      content.getChildren().add(new Label("Item "+i)); 
     } 
     ScrollPane scroller = new ScrollPane(); 
     scroller.setContent(content); 
     expandable.setContent(scroller); 
     expandable.setExpanded(false); 
     return expandable ; 
    } 

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
