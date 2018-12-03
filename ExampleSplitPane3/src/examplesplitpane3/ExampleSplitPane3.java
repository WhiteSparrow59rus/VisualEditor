/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplesplitpane3;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 *
 * @author Potapov-VI
 */
public class ExampleSplitPane3 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Split Views");
        
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768, Color.WHITE);
        
        VBox MainVBox = new VBox();
        
        HBox TopHBox = new HBox();
        HBox BottomHBox = new HBox();
        
        HBox ToolsTopHBox = new HBox();
        HBox ToolsBottomHBox = new HBox();
       
        
        
        VBox Tools = new VBox();
        
        HBox Content = new HBox();
        HBox ContentInfo = new HBox();
        
        SplitPane MainSplitPane = new SplitPane();
        MainSplitPane.setOrientation(Orientation.VERTICAL);
        MainSplitPane.prefWidthProperty().bind(scene.widthProperty());
        MainSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        SplitPane MainContentSplitPane = new SplitPane();
        MainContentSplitPane.setOrientation(Orientation.HORIZONTAL);
        MainContentSplitPane.prefWidthProperty().bind(scene.widthProperty());
        MainContentSplitPane.prefHeightProperty().bind(scene.heightProperty()); 
        
        SplitPane ContentSplitPane = new SplitPane();
        ContentSplitPane.setOrientation(Orientation.VERTICAL);
        ContentSplitPane.prefWidthProperty().bind(scene.widthProperty());
        ContentSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        SplitPane ToolsSplitPane = new SplitPane();
        ToolsSplitPane.setOrientation(Orientation.VERTICAL);
        ToolsSplitPane.prefWidthProperty().bind(scene.widthProperty());
        ToolsSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        ToolsSplitPane.getItems().add(ToolsTopHBox);
        ToolsSplitPane.getItems().add(ToolsBottomHBox);
        
        Tools.getChildren().add(ToolsSplitPane);
        
        ContentSplitPane.getItems().add(Content);
        ContentSplitPane.getItems().add(ContentInfo);
        
        MainContentSplitPane.getItems().add(Tools);
        MainContentSplitPane.getItems().add(ContentSplitPane);
        
        BottomHBox.getChildren().add(MainContentSplitPane);
        
        MainSplitPane.getItems().add(TopHBox);
        MainSplitPane.getItems().add(BottomHBox);
        
        MainVBox.getChildren().add(MainSplitPane);
        
        root.getChildren().add(MainVBox);
        
        
        
        
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
