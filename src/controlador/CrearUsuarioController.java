/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class CrearUsuarioController implements Initializable {
@FXML
    private PasswordField txtPswd;

    @FXML
    private Button btnCancel;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtDireccion;


    @FXML
    private TextField txtUser;

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private TextField txtTel;

    @FXML
    private TextField txtApellido;
    @FXML
    private TextField TextCui;

    @FXML
    void getTextPswd(ActionEvent event) {

    }

    @FXML
    void getTextNombre(ActionEvent event) {

    }
    
    

    @FXML
    void getTextApellido(ActionEvent event) {

    }

    @FXML
    void getTextUser(ActionEvent event) {

    }

    @FXML
    void getCrearUsuario(ActionEvent event) {

    }

    @FXML
    void cancel(ActionEvent event) {

    }    
    
    @FXML
    void getTextDireccion(ActionEvent event) {

    }

    @FXML
    void getTextCui(ActionEvent event) {

    }
        @FXML
    void getTextTel(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
        
        Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
        myStage.close();
    
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
