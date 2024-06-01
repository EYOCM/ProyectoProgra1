/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication16;

import java.util.ArrayList;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Windows 10
 */
public class JavaFXApplication16 extends Application {
    
    //instancia de la base de datos para que se pueda acceder desde cualquier punto
     public static BBDMemoria Base_En_Memoria = new BBDMemoria();
    
     // metodo start para mostrar las ventanas
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/vista/Interfaz.fxml"));
        //Parent root = FXMLLoader.load(getClass().getResource("/vista/GestionarUsuarios.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
