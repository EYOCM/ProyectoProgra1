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
import javafx.scene.control.Label;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nitro
 */
public class NotificacionController implements Initializable {

    @FXML
    private Button btnOk;
    @FXML
    private Label txtNotificacion;
    private String Notificacion;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    public void initNotifiacion(String Notificacion) {
        this.Notificacion = Notificacion;
        txtNotificacion.setText(Notificacion);
    }
    
    @FXML
    private void EventbtnOk(ActionEvent event) {
        Stage mystage = (Stage) txtNotificacion.getScene().getWindow();
        mystage.close();
    }
    
}
