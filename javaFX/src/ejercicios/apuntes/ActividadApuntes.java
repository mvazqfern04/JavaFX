package ejercicios.apuntes;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.*;

/**
 *
 * @author alumno
 */
public class ActividadApuntes extends Application {

    public static void main(String[] args) {
        launch();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
//        actividad3();
//        actividad4();
//        actividad6();
        actividad8();
    }

    public void actividad8() {
        Stage w1 = new Stage();
        Double ladoV = Screen.getPrimary().getBounds().getHeight();
        Double ladoH = Screen.getPrimary().getBounds().getWidth();
        w1.setWidth(ladoH);
        w1.setHeight(ladoV);

        TilePane caja = new TilePane();

        Double ladoCV = ladoH / 8;
        Double ladoCH = ladoV / 8;
        Boolean sortear = true;
        boolean cambiar = false;
        for (int i = 0; i < 32; i++) {
            if (sortear) {
                
                caja.getChildren().add(new Rectangle(ladoCV, ladoCH, Color.WHITE));
                caja.getChildren().add(new Rectangle(ladoCV, ladoCH, Color.BLACK));

            }else{
                
                caja.getChildren().add(new Rectangle(ladoCV, ladoCH, Color.BLACK));
                caja.getChildren().add(new Rectangle(ladoCV, ladoCH, Color.WHITE));
            }
            if(((i+1)%4)==0 & i>1){
                sortear=!sortear;
            }

        }
        

        Scene escena = new Scene(caja);
        w1.setScene(escena);
        w1.show();
    }

    private void actividad6() {
        Stage w1 = new Stage();
        w1.setHeight(300);
        w1.setWidth(500);

        TextField linea = new TextField();
        TextArea area = new TextArea();
        Button boton = new Button("Añadir texto");

        boton.setOnAction((event) -> {
            area.setText(area.getText() + ", " + linea.getText());
        });

        VBox lay = new VBox();

        lay.getChildren().add(linea);
        lay.getChildren().add(area);
        lay.getChildren().add(boton);

        Scene esce = new Scene(lay);
        w1.setScene(esce);
        w1.show();
    }

    private void actividad4() {
        Stage w1 = new Stage();
        double estandar = 100.0;
        w1.setX(estandar);
        w1.setY(estandar);
        w1.setHeight(500);
        w1.setWidth(500);

        Button boton = new Button("Cambiar color");
        ColorPicker colorincho = new ColorPicker();

        VBox layout = new VBox(20);
        layout.getChildren().add(boton);
        layout.getChildren().add(colorincho);

        boton.setOnAction((event) -> {
            Color color = colorincho.getValue();
            layout.setBackground(new Background(new BackgroundFill(color, null, null)));
        });

        Scene escena = new Scene(layout);

        w1.setScene(escena);
        w1.show();
    }

    private void actividad3() {
        Stage w1 = new Stage();
        w1.setX(100);
        w1.setY(100);
        Double lado = 500.0;
        Double estandar = 20.0;
        w1.setHeight(lado);
        w1.setWidth(lado);

        Button boton = new Button("Sumar");
        TextField texto1 = new TextField();
        TextField texto2 = new TextField();

        Label resultado = new Label();

        boton.setOnAction(e -> sumar(texto1, texto2, resultado));

        HBox layout = new HBox(20);
        layout.getChildren().add(texto1);
        layout.getChildren().add(texto2);
        layout.getChildren().add(boton);
        layout.getChildren().add(resultado);

        Scene escena = new Scene(layout);
        w1.setScene(escena);
        w1.show();
    }

    private void sumar(TextField texto1, TextField texto2, Label resultado) {
        Double valor1 = Double.parseDouble(texto1.getCharacters().toString());
        Double valor2 = Double.parseDouble(texto2.getCharacters().toString());
        Double resu = valor1 + valor2;
        resultado.setText(resu.toString());
    }

}
