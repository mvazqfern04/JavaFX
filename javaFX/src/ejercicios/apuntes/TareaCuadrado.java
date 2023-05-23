/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.apuntes;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class TareaCuadrado extends Application{
    public static void main(String[] args){
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage w1 = new Stage();
        w1.setX(100);
        w1.setY(100);
        
        Double gordo = 500.0;
        Double alto = 500.0;
        w1.setWidth(gordo);
        w1.setHeight(alto);
        
        VBox layout = new VBox(50.0);
        layout.setAlignment(javafx.geometry.Pos.BASELINE_CENTER);
        HBox layoutH = new HBox(50.0);
        Label text = new Label("Texto de ejemplo");
        TextField input = new TextField();
        
        layout.getChildren().add(text);
        layout.getChildren().add(input);
        layout.getChildren().add(layoutH);
        
        
        
        Rectangle rec1 = new Rectangle(100,100,Color.BLUE);
        rec1.setHeight(alto);
        rec1.setWidth(gordo*0.5);
        Rectangle rec2 = new Rectangle(100,100,Color.PINK);
        rec2.setHeight(alto);
        rec2.setWidth(gordo*0.5);
        
        layoutH.getChildren().add(rec1);
        layoutH.getChildren().add(rec2);
        
        
        rec1.addEventHandler(MouseEvent.MOUSE_ENTERED, e->brillar(rec1));
        rec1.addEventHandler(MouseEvent.MOUSE_EXITED, e->oscurecer(rec1));
        rec2.addEventHandler(MouseEvent.MOUSE_ENTERED, e->brillar(rec2));
        rec2.addEventHandler(MouseEvent.MOUSE_EXITED, e->oscurecer(rec2));
        
        Scene escena = new Scene(layout);
        
        escena.addEventFilter(KeyEvent.KEY_TYPED,e->filtroNumeros(e));
        
        w1.setScene(escena);
        w1.show();
    }
    
    private void brillar(Rectangle rec){
        Color actual = (Color)rec.getFill();
        rec.setFill(actual.brighter());
    }
    private void oscurecer(Rectangle rec){
        Color actual = (Color)rec.getFill();
        rec.setFill(actual.darker());
    }
    private void comunista(Rectangle rec){
        Color actual = Color.RED;
        rec.setFill(actual);
    }

    private void filtroNumeros(KeyEvent e) {
        if(!Character.isDigit(e.getCharacter().charAt(0))){
            e.consume();
        }
    }
    
}
