/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exampledndresizing;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
/**
 *
 * @author Potapov-VI
 */
public class ExampleDnDResizing extends Application {
    SelectionModel selectionModel;
    MouseHandler mouseHandler;

    @Override
    public void start(Stage primaryStage) {

        Group root = new Group();

        // object layer
        Group objectLayer = new Group();
        root.getChildren().add( objectLayer);

        // selection layer on top of object layer
        Group selectionLayer = new Group();
        root.getChildren().add( selectionLayer);

        selectionModel = new SelectionModel( selectionLayer);
        mouseHandler = new MouseHandler( selectionModel);

        Rectangle rect1 = new Rectangle(200,100);
        rect1.setFill(Color.RED.deriveColor(1, 1, 1, 0.2));
        rect1.relocate(100,100);
        mouseHandler.makeDraggable(rect1);

        Rectangle rect2 = new Rectangle(200,100);
        rect2.setFill(Color.AQUA.deriveColor(1, 1, 1, 0.2));
        rect2.relocate(300,300);
        mouseHandler.makeDraggable(rect2);

        TitledPane sampleNode = new TitledPane();
        sampleNode.setPrefHeight(100);
        sampleNode.setPrefWidth(200);
        sampleNode.relocate(400,200);
        mouseHandler.makeDraggable(sampleNode);

        StackPane sampleNode2 = new StackPane();
        sampleNode2.getChildren().add( new Label( "I'm a StackPane"));
        sampleNode2.setStyle( "-fx-background-color: lightblue");
        sampleNode2.setPrefHeight(100);
        sampleNode2.setPrefWidth(200);
        sampleNode2.relocate(600,300);
        mouseHandler.makeDraggable(sampleNode2);

        objectLayer.getChildren().addAll( rect1, rect2, sampleNode, sampleNode2);

        Scene scene = new Scene( root, 1600, 900);

        // clear selection when user clicks outside of cell
        scene.setOnMousePressed(mouseEvent -> selectionModel.clear());

        scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

        primaryStage.setScene( scene);
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
