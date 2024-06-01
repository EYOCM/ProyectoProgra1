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
import javafx.scene.control.ListView;
import static javafx.scene.input.KeyCode.T;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class MenuAdminController implements Initializable {

    @FXML
    private Button btnRegistrarLibro;
    @FXML
    private Button btnGestionarUsuarios;
    @FXML
    private Button btnGestionarLibro;
    @FXML
    private Button btnRegistroDeTransacciones;
    @FXML
    private Button btnSalirMenuAdmin;
    @FXML
    private ListView<?> listMenuAdmin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ResgistrarLibro(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroLibros.fxml"));
        Parent root = loader.load();
        RegistroLibrosController controlador = loader.getController();
        controlador.initVentana("MenuAdmin");
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
        
        Stage myStage = (Stage) this.btnGestionarUsuarios.getScene().getWindow();
        myStage.close();
    }

    @FXML
    private void GestionarUsuarios(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionarUsuarios.fxml"));
        Parent root = loader.load();
        GestionarUsuariosController controlador = loader.getController();
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
        
        Stage myStage = (Stage) this.btnGestionarUsuarios.getScene().getWindow();
        myStage.close();
    }

    @FXML
    private void GestionarLibro(ActionEvent event) throws IOException {
     FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionarLibros.fxml"));
        Parent root = loader.load();
        GestionarLibrosController controlador = loader.getController();
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
        
        Stage myStage = (Stage) this.btnGestionarUsuarios.getScene().getWindow();
        myStage.close(); 
    }

    @FXML
    private void RegistroDeTransacciones(ActionEvent event) {
    }

    @FXML
    private void SalirMenuAdmin(ActionEvent event) {
    }
    
    void closeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Interfaz.fxml"));
        Parent root = loader.load();
        InterfazController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            controlador.closeWindow();
        });

        Stage myStage = (Stage) this.btnGestionarLibro.getScene().getWindow();
        myStage.close();

        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
