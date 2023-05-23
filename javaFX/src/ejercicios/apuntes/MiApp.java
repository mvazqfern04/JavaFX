/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ejercicios.apuntes;

import java.time.LocalDate;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class MiApp extends Application{

    @Override
    public void start(Stage w1) throws Exception {
//        prueba1(w1);
//        prueba2();
//        prueba3();
//        prueba4();
        prueba5();
    }
    
    public void prueba1(Stage w1){
        w1.setTitle("Ventana 1");
        w1.setX(0);
        w1.setY(0);
        w1.setWidth(500);
        w1.setHeight(200);
        w1.show();
        
    }
    
    public void prueba2(){
        Stage w1 = new Stage();
        Stage w2 = new Stage();
        Stage w3 = new Stage();
        
        Screen pantalla = Screen.getPrimary();
        Rectangle2D area = pantalla.getBounds();
        double ancho = area.getWidth();
        double alto = area.getHeight();
        
        w1.setY(0.2*alto);
        w2.setY(0.2*alto);
        w3.setY(0.2*alto);
        
        w1.setX(0);
        w2.setX(ancho/3);
        w3.setX(2*ancho/3);
        
        w1.setWidth(ancho/3);
        w2.setWidth(ancho/3);
        w3.setWidth(ancho/3);
        
        w1.setHeight(alto*0.6);
        w2.setHeight(alto*0.6);
        w3.setHeight(alto*0.6);
        
        w1.setTitle("Ventana 1");
        w2.setTitle("Ventana 2");
        w3.setTitle("Ventana 3");
        
        w1.show();
        w2.show();
        w3.show();
    }
    
    public void prueba3(){
        Stage w1 = new Stage();
        Stage w2 = new Stage();
        Stage w3 = new Stage();
        w1.setTitle("Ventana 1");
        w2.setTitle("Ventana 2");
        w3.setTitle("Ventana 3");
        w1.showAndWait();
        w2.show();
        w3.show();
    }
    
    public void prueba4(){
        Stage w1 = new Stage();
        w1.setX(100);
        w1.setY(100);
        w1.setWidth(500);
        w1.setHeight(300);
        Button boton = new Button("Hey?");
        ColorPicker cp = new ColorPicker();
        cp.getValue();
        DatePicker dp = new DatePicker(LocalDate.now());
        VBox layout = new VBox(50.0);
        layout.getChildren().add(boton);
        layout.getChildren().add(cp);
        layout.getChildren().add(dp);
        
        Scene escena = new Scene(layout);
        w1.setScene(escena);
        w1.show();
        
    }
    
    /**
     * 
     */
    public void prueba5(){
        Stage w1 = new Stage();
        w1.setX(100);
        w1.setY(100);
        w1.setWidth(500);
        w1.setHeight(300);
        
        Button boton = new Button("Hey?");
        ColorPicker cp = new ColorPicker();
        Label etiqueta = new Label("Nada que hacer");
        cp.getValue();
        VBox layout = new VBox(50.0);
        
        layout.getChildren().add(boton);
        layout.getChildren().add(cp);
        layout.getChildren().add(etiqueta);
        
        Scene escena = new Scene(layout);
        EventHandler<ActionEvent> valor = new EventHandler(){
            @Override
            public void handle(Event event) {
                System.out.println("Boton pulsado");
                etiqueta.setText("Boton pulsado");
                Color color = cp.getValue();
                layout.setBackground(new Background(new BackgroundFill(color,null,null)));
                etiqueta.textFillProperty().setValue(color.invert());
            }
            
        };
        boton.setOnAction(valor);
        
        w1.setScene(escena);
        w1.show();
    }
    
    public static void main(String[] args) {
        launch();
    }
}
