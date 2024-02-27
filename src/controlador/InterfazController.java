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
import javax.swing.plaf.basic.BasicBorders;

/**
 *
 * @author Windows 10
 */
public class InterfazController implements Initializable {
    
    @FXML
    private Button btnIngresoAdmin;
    private Button btnIngresoCliente;
    
    @FXML
    private void showLogeoAdmin(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logeo.fxml"));
        Parent root = loader.load();
        LogeoController controlador = loader.getController();
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
        @FXML
    void showLogeoCliente(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logeo.fxml"));
        Parent root = loader.load();
        LogeoController controlador = loader.getController();
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

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    void closeWindow() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
