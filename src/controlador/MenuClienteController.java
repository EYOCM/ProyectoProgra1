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

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class MenuClienteController implements Initializable {

    @FXML
    private Button btnPrestarLibro;
    @FXML
    private Button btnDevolverLibro;
    @FXML
    private Button btnMultas;
    @FXML
    private Button btnRegistroTransacciones;
    @FXML
    private Button btnEstatusPrestamo;
    @FXML
    private Button btnSalir;
    @FXML
    private ListView<?> listBuscarLibro;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void ShowBooks(ActionEvent event) {
    }

    @FXML
    private void DevolverLibro(ActionEvent event) {
    }

    @FXML
    private void ConsultarMulta(ActionEvent event) {
    }

    @FXML
    private void MostrarHistorialLibros(ActionEvent event) {
    }

    @FXML
    private void VerEstadoDelPrestamo(ActionEvent event) {
    }

    @FXML
    private void VolveraMenuPrincipal(ActionEvent event) {
    }
    
}
