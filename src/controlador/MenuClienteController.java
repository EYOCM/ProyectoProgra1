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
import javafx.stage.Stage;

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
    private void ShowBooks(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/PrestarLibro.fxml"));
        Parent root = loader.load();
       PrestarLibroController controlador = loader.getController();
    //  controlador.Variable("Cliente");
    //  controlador.initVentana("Agregar Libro Gestion");
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            controlador.closeWindow();
        });
        
        Stage myStage = (Stage) this.btnDevolverLibro.getScene().getWindow();
        myStage.close();
        
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
    void closeWindow() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuCliente.fxml"));
        Parent root = loader.load();
        InterfazController controlador = loader.getController();
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            controlador.closeWindow();
        });

        Stage myStage = (Stage) this.btnDevolverLibro.getScene().getWindow();
        myStage.close();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
