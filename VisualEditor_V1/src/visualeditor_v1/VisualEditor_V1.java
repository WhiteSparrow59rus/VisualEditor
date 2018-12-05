/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualeditor_v1;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javafx.geometry.Orientation;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


/**
 *
 * @author Potapov-VI
 */
public class VisualEditor_V1 extends Application {
    
    @Override
    public void start(Stage primaryStage) {
          
       //Общая группа
        Group root = new Group();
        
        // Поле для Content части
        Pane Canvas = new Pane();
        
        // Создаем сцену, в которую внедряем общую группу
        Scene scene = new Scene(root, 1024, 768, Color.WHITE);
        
        //Главный вертикальный бокс
        VBox MainVBox = new VBox();
        
        //Горизонтальные боксы 
        HBox TopHBox = new HBox();
        HBox BottomHBox = new HBox();
        
        //Горизонтальные боксы для Инструментов
        HBox ToolsTopHBox = new HBox();
        HBox ToolsBottomHBox = new HBox();
        
       // Вертикальный бокс Инструментов
        VBox Tools = new VBox();
        
        //Вертикальные боксы для контент части
        HBox Content = new HBox();
        HBox ContentInfo = new HBox();
        
        //Создаем главную сплит панель, которая разделяет боксы TopHBox и BottomHBox
        SplitPane MainSplitPane = new SplitPane();
        MainSplitPane.setOrientation(Orientation.VERTICAL);
        MainSplitPane.prefWidthProperty().bind(scene.widthProperty());
        MainSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        //Создаем сплит панель для BottomHBox , которая разделяет панели  ContentSplitPane и ToolsSplitPane
        SplitPane MainContentSplitPane = new SplitPane();
        MainContentSplitPane.setOrientation(Orientation.HORIZONTAL);
        MainContentSplitPane.prefWidthProperty().bind(scene.widthProperty());
        MainContentSplitPane.prefHeightProperty().bind(scene.heightProperty()); 
        
        //Создаем сплит панель для боксов контент части
        SplitPane ContentSplitPane = new SplitPane();
        ContentSplitPane.setOrientation(Orientation.VERTICAL);
        ContentSplitPane.prefWidthProperty().bind(scene.widthProperty());
        ContentSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        //Создаем сплит панель для боксов части инструментов
        SplitPane ToolsSplitPane = new SplitPane();
        ToolsSplitPane.setOrientation(Orientation.VERTICAL);
        ToolsSplitPane.prefWidthProperty().bind(scene.widthProperty());
        ToolsSplitPane.prefHeightProperty().bind(scene.heightProperty());
        
        //Создаем скролл 
        ScrollPane canvasscroll = new ScrollPane();
        
        //Проверка, отображать скролы или нет, в зависимости от размеров внутреннего контента и окна
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
        
        //Установка параметров для canvas
        Canvas.setCursor(Cursor.HAND);
        Canvas.setMinWidth(2000);
        Canvas.setMinHeight(2000);
        
        //Установить контент Canvas в canvasscroll
        canvasscroll.setContent(Canvas);  
        canvasscroll.setMaxWidth(Double.MAX_VALUE);
        canvasscroll.setMaxHeight(Double.MAX_VALUE);
        
        // кнопка заполняет все пространство ячейки
        Content.setHgrow(canvasscroll, Priority.ALWAYS);
        
        //Добавить в бокс Content > canvasscroll
        Content.getChildren().add(canvasscroll);
        
        //Добавить в панель инструментов боксы  ToolsTopHBox и ToolsBottomHBox
        ToolsSplitPane.getItems().add(ToolsTopHBox);
        ToolsSplitPane.getItems().add(ToolsBottomHBox);
        
        //Добавить сплит панель ToolsSplitPane в бокс Tools
        Tools.getChildren().add(ToolsSplitPane);
        
        //Добавить в контент панель боксы  Content и ContentInfo
        ContentSplitPane.getItems().add(Content);
        ContentSplitPane.getItems().add(ContentInfo);
        
        //Добавить в главную контент сплит панель боксы Tools и ContentSplitPane
        MainContentSplitPane.getItems().add(Tools);
        MainContentSplitPane.getItems().add(ContentSplitPane);
        
        //Добавить в бокс BottomHBox главную контент сплит панель MainContentSplitPane
        BottomHBox.getChildren().add(MainContentSplitPane);
        
        //Добавить в главную сплит панель боксы  TopHBox и BottomHBox
        MainSplitPane.getItems().add(TopHBox);
        MainSplitPane.getItems().add(BottomHBox);
        
        //Добавить в главнй бокс MainVBox главную сплит панель MainSplitPane
        MainVBox.getChildren().add(MainSplitPane);
        
        //Добавить в корень главный бокс
        root.getChildren().add(MainVBox);
        
        //Устанавливаем максимальные и минимальные размеры боксов
        TopHBox.setMinHeight(20);
        TopHBox.setMaxHeight(50);
        
        ToolsTopHBox.setMaxHeight(150);
        ToolsTopHBox.setMinHeight(50);
        
        Tools.setMaxWidth(150);
        Tools.setMinWidth(50);
        ContentInfo.setMaxHeight(150);
        ContentInfo.setMinHeight(50);
        
        //Запрещаем изменять размер боксов при изменении размеров окна
        SplitPane.setResizableWithParent(Tools, Boolean.FALSE);
        SplitPane.setResizableWithParent(ContentInfo, Boolean.FALSE);
        SplitPane.setResizableWithParent(TopHBox, Boolean.FALSE);
        SplitPane.setResizableWithParent(ToolsTopHBox, Boolean.FALSE);
        
        
        
        

        
        primaryStage.setScene(scene);
        
        //Устанавливаем название окна
        primaryStage.setTitle("Editor");
        
        //Показываем окно
        primaryStage.show();
    }  


    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
