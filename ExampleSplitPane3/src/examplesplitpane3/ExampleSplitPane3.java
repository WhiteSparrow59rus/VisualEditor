/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplesplitpane3;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author Potapov-VI
 */
public class ExampleSplitPane3 extends Application {
    Circle circle_Blue;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Split Views");
        
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768, Color.WHITE);

        Canvas canvas = new Canvas(2000, 2000);
 

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
        
        ScrollPane canvasscroll = new ScrollPane();
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
        
        canvasscroll.setMaxWidth(Double.MAX_VALUE);
        canvasscroll.setMaxHeight(Double.MAX_VALUE);
        // кнопка заполняет все пространство ячейки
        Content.setHgrow(canvasscroll, Priority.ALWAYS);
       
        Content.getChildren().add(canvasscroll);
        
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
        TopHBox.setMinHeight(20);
        TopHBox.setMaxHeight(50);
        
        ToolsTopHBox.setMaxHeight(150);
        ToolsTopHBox.setMinHeight(50);
        
        Tools.setMaxWidth(150);
        Tools.setMinWidth(50);
        ContentInfo.setMaxHeight(150);
        ContentInfo.setMinHeight(50);
        
        SplitPane.setResizableWithParent(Tools, Boolean.FALSE);
        SplitPane.setResizableWithParent(ContentInfo, Boolean.FALSE);
        SplitPane.setResizableWithParent(TopHBox, Boolean.FALSE);
        SplitPane.setResizableWithParent(ToolsTopHBox, Boolean.FALSE);
        
        
        
        GraphicsContext gc = canvas.getGraphicsContext2D();
        // Draw a Text
        gc.setLineWidth(2.0);
 // Set fill color

        gc.setFill(Color.GREEN);

        // Draw a rounded Rectangle

        gc.fillRoundRect(50, 50, 300, 100, 10, 10);

        canvasscroll.setContent(canvas);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    EventHandler<MouseEvent> circleOnMousePressedEventHandler = 
        new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
            orgSceneX = t.getSceneX();
            orgSceneY = t.getSceneY();
            orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
            orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
        }
    };
    
    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler = 
        new EventHandler<MouseEvent>() {

        @Override
        public void handle(MouseEvent t) {
            double offsetX = t.getSceneX() - orgSceneX;
            double offsetY = t.getSceneY() - orgSceneY;
            double newTranslateX = orgTranslateX + offsetX;
            double newTranslateY = orgTranslateY + offsetY;
            
            ((Circle)(t.getSource())).setTranslateX(newTranslateX);
            ((Circle)(t.getSource())).setTranslateY(newTranslateY);
        }
    };
}
