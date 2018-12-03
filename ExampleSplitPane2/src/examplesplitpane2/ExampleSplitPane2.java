/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examplesplitpane2;

import javafx.application.Application;
import javafx.scene.text.TextBuilder;
import javafx.collections.ObservableList;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Potapov-VI
 */
public class ExampleSplitPane2 extends Application {
    
     @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Split Views");
        primaryStage.show();
        Group root = new Group();
        Scene scene = new Scene(root, 1024, 768, Color.WHITE);
        
        SplitPane MainSplitPane = new SplitPane();
        MainSplitPane.prefWidthProperty().bind(scene.widthProperty());
        MainSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        VBox Tools = new VBox(10);
        HBox rowBox = new HBox(20);
        final Text ToolsText = TextBuilder.create()
                .text("Tools")
                .translateX(20)
                .fill(Color.RED)
                .font(Font.font(null, FontWeight.BOLD, 20))
                .build();

        rowBox.getChildren().add(ToolsText);
        Tools.getChildren().add(rowBox);
        Tools.setAlignment(Pos.CENTER);
        
        
        SplitPane ContentSplitPane = new SplitPane();
        ContentSplitPane.setOrientation(Orientation.VERTICAL);
        ContentSplitPane.prefWidthProperty().bind(scene.widthProperty());
        ContentSplitPane.prefHeightProperty().bind(scene.heightProperty());

        HBox Content = new HBox();
 
        final Text upperRight = TextBuilder.create()
            .text("Content")
            .x(100)
            .y(50)
             .fill(Color.RED)
            .font(Font.font(null, FontWeight.BOLD, 35))
            .translateY(50)
            .build();
        Content.getChildren().add(upperRight);

        HBox ContentInfo = new HBox();
        
        final Text lowerRight = TextBuilder.create()
            .text("Content Info")
            .x(100)
            .y(50)
             .fill(Color.RED)
            .font(Font.font(null, FontWeight.BOLD, 35))
            .translateY(50)
            .build();
        ContentInfo.getChildren().add(lowerRight);

        ContentSplitPane.getItems().add(Content);
        ContentSplitPane.getItems().add(ContentInfo);

        MainSplitPane.getItems().add(Tools);

        MainSplitPane.getItems().add(ContentSplitPane);

        ObservableList<SplitPane.Divider> dividers = MainSplitPane.getDividers();
        for (int i = 0; i < dividers.size(); i++) {
            dividers.get(i).setPosition((i + 1.0) / 3);
        }
        HBox hbox = new HBox();
        hbox.getChildren().add(MainSplitPane);
        root.getChildren().add(hbox);
        SplitPane.setResizableWithParent(Tools, Boolean.FALSE);
        //SplitPane.setResizableWithParent(Tools, Boolean.FALSE);
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
