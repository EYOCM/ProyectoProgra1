/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafxapplication16.ListaLibros;
import javafxapplication16.ListaUsuarios;

/**
 *
 * @author Windows 10
 */
public class InterfazController implements Initializable {
    
    @FXML
    private Button btnIngresoAdmin;
    private Button btnIngresoCliente;
    
    
    // instancia de las bases de datos para acceder a las mismas 
    static ListaUsuarios BBDUsuarios  = new ListaUsuarios();
    static ListaLibros BBDLibros = new ListaLibros();
   
    // accion que se raalizara al presionar el boton de ingreso desde la interfaz principal
    @FXML
    private void showLogeoAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logeo.fxml"));
        Parent root = loader.load();
        LogeoController controlador = loader.getController();
        controlador.initVariable("Administrador"); // asignamos una variable para indicar que tiipo de usuario accedio
        
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindow();
            } catch (IOException ex) {
                Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Stage myStage = (Stage) this.btnIngresoAdmin.getScene().getWindow();
        myStage.close();
        
        
    }
    // accion que se raalizara al presionar el boton de ingreso desde la interfaz principal
        @FXML
    void showLogeoCliente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logeo.fxml"));
        Parent root = loader.load();
        LogeoController controlador = loader.getController();
        controlador.initVariable("Cliente");// asignamos una variable para indicar que tiipo de usuario accedio
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindow();
            } catch (IOException ex) {
                Logger.getLogger(InterfazController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
        Stage myStage = (Stage) this.btnIngresoAdmin.getScene().getWindow();
        myStage.close();
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void closeWindow() {
        Stage myStage = (Stage) this.btnIngresoAdmin.getScene().getWindow();
        myStage.close();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        
    }
    
}
