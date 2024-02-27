/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import static javafx.scene.input.KeyCode.T;

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
    private void ResgistrarLibro(ActionEvent event) {
    }

    @FXML
    private void GestionarUsuarios(ActionEvent event) {
    }

    @FXML
    private void GestionarLibro(ActionEvent event) {
    }

    @FXML
    private void RegistroDeTransacciones(ActionEvent event) {
    }

    @FXML
    private void SalirMenuAdmin(ActionEvent event) {
    }
    
}
