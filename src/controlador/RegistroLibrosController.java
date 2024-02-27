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
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class RegistroLibrosController implements Initializable {

    @FXML
    private Button btnAgregarLibroAlRegistro;
    @FXML
    private Button btnSalirRegistroLibros;
    @FXML
    private TextField TxtIsbn;
    @FXML
    private TextField TxtTitulo;
    @FXML
    private TextField TxtAutor;
    @FXML
    private TextField TxtAñoPublicacion;
    @FXML
    private TextField TextEditorial;
    @FXML
    private TextField TxtCantidadIngresar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AgregarLibroAlRegistro(ActionEvent event) {
    }

    @FXML
    private void SalirRegistroLibros(ActionEvent event) {
    }

    @FXML
    private void getTxtIsbn(ActionEvent event) {
    }

    @FXML
    private void getTxtTitulo(ActionEvent event) {
    }

    @FXML
    private void getTxtAutor(ActionEvent event) {
    }

    @FXML
    private void getTxtAñoPublicacion(ActionEvent event) {
    }

    @FXML
    private void getTextEditorial(ActionEvent event) {
    }

    @FXML
    private void getTxtCantidadIngresar(ActionEvent event) {
    }
    
}
