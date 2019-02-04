/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proggraphics;
import javafx.application.Application;
import javafx.geometry.VPos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
/**
 *
 * @author Slava
 */
public class ProgGraphics extends Application {
    
  
     @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(600, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        
 
        // сетка
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(.5);
        gc.setFontSmoothingType(null);
        gc.setLineDashes(5, 2);
        for (int i = 0; i < 10; i++) {
            gc.strokeLine(i * 60, 0, i * 60, 600);
            gc.strokeLine(0, i * 60, 600, i * 60);
        }
        gc.setStroke(Color.BLUE);
        gc.setLineDashes(null);
        gc.setLineWidth(1);
 
        // числа
        gc.setTextAlign(TextAlignment.CENTER);
        for (int i = 0; i < 11; i++) {
            if (i == 5) continue;
            gc.strokeText(String.valueOf(i * 60 - 300), i * 60, 315);
        }
        gc.setTextBaseline(VPos.CENTER);
        gc.setTextAlign(TextAlignment.LEFT);
        for (int i = 0; i < 11; i++) {
            if (i == 5) continue;
            gc.strokeText(String.valueOf(300 - i * 60), 310, i * 60);
        }
 
        gc.setStroke(Color.BLACK);
        gc.strokeLine(300, 0, 300, 600);    // zero line
        gc.strokeLine(0, 300, 600, 300);    // zero line
 
        class LineB{
            GraphicsContext gc = canvas.getGraphicsContext2D();
            void create(int x1, int y1, int x2, int y2){
                int A = y2 - y1;
                int B = x1 - x2;
                int Sign;
                int SignA;
                int SignB;
                int f;
                int X;
                int Y;
                
                if  (Math.abs(A) >  Math.abs(B)) {
                    Sign = 1;
                } else {
                    Sign = -1;
                }
                if (A < 0) {SignA = -1;} else {SignA = 1;} 
                if (B < 0) {SignB = -1;} else {SignB = 1;} 
                f = 0;
                X = x1;
                Y = y1;
                gc.fillRect(X,  Y, 1, 1);
                if  (Sign == -1) {
                    do {
                    f = f + A*SignA;
                        if (f > 0) {
                            f = f - B*SignB;
                            Y = Y + SignA;
                        } 
                    X = X - SignB;
                    gc.fillRect(X,  Y, 1, 1);
                    

                    } while (X != x2 || Y != y2);
                } else
                    do {
                    f = f + B*SignB;
                        if (f > 0) {
                            f = f - A*SignA;
                            X = X - SignB;
                        } 
                    Y = Y + SignA;
                    gc.fillRect(X,  Y, 1, 1);    
                    } while (X != x2 || Y != y2);
                }
        
    }        
        LineB Line = new LineB();
        
      
        Line.create(100, 100, 90, 95);
        Line.create(300, 300, 350, 250);
        
        
     
//    
//        for (int i = 0; i < 11; i++) {
//            if (i == 5) continue;
//            gc.strokeText(String.valueOf(i * 60 - 300), i * 60, 315);
//        }
        
 
        primaryStage.setScene(new Scene(new Group(canvas)));
        primaryStage.show();
    }
   
}