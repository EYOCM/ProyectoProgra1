package controlador;

import static controlador.InterfazController.BBDUsuarios;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafxapplication16.ListaUsuarios;

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class LogeoController implements Initializable {

    private String TipoUsuario;
    private ListaUsuarios BBUsuarios;
    @FXML
    private PasswordField txtPswdCliente;

    @FXML
    private Button btnCrearUsuario;

    @FXML
    private Button btnInicioSesionCliente;

    @FXML
    private TextField txtUserCliente;
    //METODO QUE RECIBE COMO PARAMETRO UNA VARIABLE QUE INDICA DESDE DONDE ESTA LLAMANDO A LA FUNCION DE LOGEO 
    public void initVariable(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    @FXML
    void IngresCliente(ActionEvent event) throws IOException {
        if (BBDUsuarios.ValidarUsuario(
                txtUserCliente.getText(),
                txtPswdCliente.getText(), 0,
                TipoUsuario)) {
            if (TipoUsuario.contains("Administrador")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuAdmin.fxml"));
                Parent root = loader.load();
                MenuAdminController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage myStage = (Stage) this.btnInicioSesionCliente.getScene().getWindow();
                myStage.close();
            }

            if (TipoUsuario.contains("Cliente")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuCliente.fxml"));
                Parent root = loader.load();
                MenuClienteController controlador = loader.getController();
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
                Stage myStage = (Stage) this.btnInicioSesionCliente.getScene().getWindow();
                myStage.close();
            }
        } else {
            txtUserCliente.setText("");
            txtPswdCliente.setText("");

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Notificacion.fxml"));
            Parent root = loader.load();
            NotificacionController controlador = loader.getController();
            controlador.initNotifiacion("Su Usuario o Contraseña incorrecto");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();

        }

    }

    @FXML
    void crearUsuario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/CrearUsuario.fxml"));
        Parent root = loader.load();
        CrearUsuarioController controlador = loader.getController();
        controlador.Variable(TipoUsuario);
        controlador.initVentana("Ventana Logeo");
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        stage.setOnCloseRequest(e -> {
            try {
                controlador.closeWindow();
            } catch (IOException ex) {
                Logger.getLogger(LogeoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });

        Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
        myStage.close();

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

        Stage myStage = (Stage) this.btnInicioSesionCliente.getScene().getWindow();
        myStage.close();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    void setStage(Stage stage) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
