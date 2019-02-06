/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linedrawer;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class LineDrawer extends Application {
//    
//    class LineB{
//            
//            void create(int x1, int y1, int x2, int y2){
//                int A = y2 - y1;
//                int B = x1 - x2;
//                int Sign;
//                int SignA;
//                int SignB;
//                int f;
//                int X;
//                int Y;
//                
//                if  (Math.abs(A) >  Math.abs(B)) {
//                    Sign = 1;
//                } else {
//                    Sign = -1;
//                }
//                if (A < 0) {SignA = -1;} else {SignA = 1;} 
//                if (B < 0) {SignB = -1;} else {SignB = 1;} 
//                f = 0;
//                X = x1;
//                Y = y1;
//                gc.fillRect(X,  Y, 1, 1);
//                if  (Sign == -1) {
//                    do {
//                    f = f + A*SignA;
//                        if (f > 0) {
//                            f = f - B*SignB;
//                            Y = Y + SignA;
//                        } 
//                    X = X - SignB;
//                    gc.fillRect(X,  Y, 1, 1);
//                    
//
//                    } while (X != x2 || Y != y2);
//                } else
//                    do {
//                    f = f + B*SignB;
//                        if (f > 0) {
//                            f = f - A*SignA;
//                            X = X - SignB;
//                        } 
//                    Y = Y + SignA;
//                    gc.fillRect(X,  Y, 1, 1);    
//                    } while (X != x2 || Y != y2);
//                }
//        
//        }       
    
    
    
    
    public static void main(String[] args) {
        launch(args);
    }

    private Line curLine;
//    private LineB lineB;

    @Override
    public void start(Stage stage) throws Exception {
        Pane drawingPane = new Pane();
        drawingPane.setPrefSize(800, 800);
        drawingPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        ScrollPane scrollPane = new ScrollPane(drawingPane);
        scrollPane.setPrefSize(300, 300);
        scrollPane.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
        scrollPane.setStyle("-fx-focus-color: transparent;");
        
        
        
        
        drawingPane.setOnMousePressed(event -> {
            if (!event.isPrimaryButtonDown()) {
                return;
            }

            curLine = new Line(
                event.getX(), event.getY(), 
                event.getX(), event.getY()
            );
            drawingPane.getChildren().add(curLine);
        });

        drawingPane.setOnMouseDragged(event -> {
            if (!event.isPrimaryButtonDown()) {
                return;
            }

            if (curLine == null) {
                return;
            }

            curLine.setEndX(event.getX());
            curLine.setEndY(event.getY());

            double mx = Math.max(curLine.getStartX(), curLine.getEndX());
            double my = Math.max(curLine.getStartY(), curLine.getEndY());

            if (mx > drawingPane.getMinWidth()) {
                drawingPane.setMinWidth(mx);
            }

            if (my > drawingPane.getMinHeight()) {
                drawingPane.setMinHeight(my);
            }
        });

        drawingPane.setOnMouseReleased(event -> curLine = null);

        Scene scene = new Scene(scrollPane);
        stage.setMinWidth(100);
        stage.setMinHeight(100);
        stage.setScene(scene);
        stage.show();
    }
}