/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMain.java to edit this template
 */
package logingui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author alumno
 */
public class LoginGUI extends Application {

    private Stage w1 = new Stage();

    private Label etiqueta1 = new Label("Acceso al sistema");
    private Label intentos = new Label("Tras 3 intentos, se bloqueara la contraseña.");

    //Layout para la escena principal
    private VBox cajaPrincipal = new VBox(0);
    private VBox cajaDatos = new VBox(40);
    private VBox cajaUsu = new VBox(10);
    private VBox cajaPas = new VBox(10);
    private HBox cajaAcceso = new HBox(50);
    private VBox

    //Nodos para la escena principal
    private Label tUsu = new Label("Usuario");
    private TextField fUsu = new TextField();
    private Label tPas = new Label("Contraseña");
    private PasswordField fPas = new PasswordField();
    //Nodos para la escena bienvenido
    private Label tBien = new Label("Bienvenida/o!");
    private Label tBloq = new Label("Cuenta bloqueada/o!");

    private Button registrar = new Button("Registrar");
    private Button acceder = new Button("Acceder");

    private Scene escenaPrin = new Scene(cajaPrincipal);
    private Scene bienvenido = new Scene(tBien);
    private Scene bloqueado = new Scene(tBloq);
    //Escena registro
    private Scene registrar = new Scene();

    private Integer intentosRes = 3;
    //texto para probar
    private ArrayList<Usuario> users = new ArrayList();

    @Override
    public void start(Stage primaryStage) throws FileNotFoundException {
        w1.setHeight(600);
        w1.setWidth(500);
        w1.setResizable(false);
        w1.setScene(escenaPrin);

        //Decoración
        decorar();

        //Convertir a usuario
        File archivo = new File("/home/alumno/Descargas/users.db.csv");
        Scanner sc = new Scanner(archivo);
        //Salto de linea para ignorar la cabecera
        String cabecera = sc.nextLine();
        //Lista de usuarios
        while (sc.hasNext()) {
            users.add(new Usuario(sc.nextLine()));
        }

        //Funciones de los botones
        acceder.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try {
                    probarAcceso();
                } catch (FileNotFoundException ex) {
                    System.err.println("Fallitos");
                }
            }

        });
        escenaPrin.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    System.out.println("Funciona!!");
                    try {
                        probarAcceso();
                    } catch (FileNotFoundException ex) {
                        System.err.println("Fallitos");
                    }
                }
            }
        });
        w1.show();
    }

    private void probarAcceso() throws FileNotFoundException {
        //Usuario con los datos introducidos
        Usuario introducido = new Usuario(fUsu.getText(), fPas.getText());

        if (users.contains(introducido)) {
            w1.setScene(bienvenido);
            System.out.println("Funciona?!");

        } else {
            intentosRes--;
            intentos.setText("Tras " + intentosRes + " intentos, se bloqueara la contraseña.");
            if (intentosRes.equals(0)) {
                w1.setScene(bloqueado);
            }
        }

        w1.setHeight(600);
        w1.setWidth(500);
    }

    /**
     * Ajusta el css de la ventana
     */
    private void decorar() {
        ajustarCajaPrincipal();
        ajustarEtiqueta1();
        cajaAcceso.setAlignment(Pos.CENTER);

        cajaPrincipal.getChildren().add(etiqueta1);
        cajaPrincipal.getChildren().add(cajaDatos);
        cajaPrincipal.getChildren().add(cajaAcceso);

        cajaUsu.getChildren().add(tUsu);
        tUsu.setFont(Font.font(18));
        cajaUsu.getChildren().add(fUsu);

        cajaDatos.getChildren().add(cajaUsu);
        cajaDatos.getChildren().add(cajaPas);

        cajaPas.getChildren().add(tPas);
        tPas.setFont(Font.font(18));
        cajaPas.getChildren().add(fPas);
        cajaPas.getChildren().add(intentos);
        intentos.setFont(Font.font(12));

        cajaAcceso.getChildren().add(registrar);
        registrar.setFont(Font.font(18));
        cajaAcceso.getChildren().add(acceder);
        acceder.setFont(Font.font(18));

        tBien.setFont(Font.font(40));
        tBloq.setFont(Font.font(40));
    }

    private void ajustarEtiqueta1() {
        etiqueta1.setBackground(new Background(new BackgroundFill(Color.RED, null, null)));
        etiqueta1.setAlignment(Pos.CENTER);
        etiqueta1.setPadding(new Insets(10, 10, 10, 10));
        etiqueta1.setFont(Font.font(30));
        etiqueta1.setTextFill(Color.WHITE);
        tBien.setAlignment(Pos.CENTER);
        tBloq.setAlignment(Pos.CENTER);
    }

    private void ajustarCajaPrincipal() {
        cajaPrincipal.setPadding(new Insets(50, 100, 50, 100));
        cajaPrincipal.setMargin(etiqueta1, new Insets(0, 0, 60, 0));
        cajaPrincipal.setMargin(cajaDatos, new Insets(0, 0, 60, 0));
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    private boolean comprobarDni(String textDni, String letra) {
        boolean numero = false;
        boolean let = false;
        Integer dni = Integer.parseInt(textDni);
        if (dni > 100000000 && dni < 9999999) {
            numero = true;
            Integer letDni = dni % 21;
            String[] letrasDni={"T","R","W","A","G","M","Y","F","P","D","X","B","N","J","Z","S","Q","V","H","L","C","K","E"};
            if (letra.equals(letrasDni[letDni])) {
                let=true;
            }
        }

        return let;
    }
}
