package controlador;

import BaseDeDatos1.UsuariosDB;
import static controlador.InterfazController.BBDUsuarios;
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
import javafxapplication16.Usuario;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.control.Label;
import javafxapplication16.ListaUsuarios;

public class CrearUsuarioController implements Initializable {
    
    private String TipoUsuario;
    private String Ventana;
    private int Indice;
    private ListaUsuarios nuevaBaseDeDatosSQL;
    
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
    private Label txtTitulo;
    
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

//    public CrearUsuarioController() {
//        BBDUsuarios = new ListaUsuarios();
               UsuariosDB usuarioDB = new UsuariosDB();
//    }
    // al presioanr el boton de crear usuario se ejectuta el siguiente bloque de codigo
    @FXML
    void getCrearUsuario(ActionEvent event) throws IOException {
        // verifica que todos los  campos esten llenos es decir diferente de vacio
        if (!txtNombre.getText().isEmpty()
                && !txtApellido.getText().isEmpty()
                && !txtUser.getText().isEmpty()
                && !txtPswd.getText().isEmpty()
                && !txtTel.getText().isEmpty()
                && !TextCui.getText().isEmpty()
                && !txtDireccion.getText().isEmpty()) {
            // si se cumple la condicion guarda la informacion en un objeto (UsuarioTemporal) de la case Usuario.
            Usuario UsuarioTemporal = new Usuario(
                    txtNombre.getText(),
                    txtApellido.getText(),
                    txtUser.getText(),
                    txtPswd.getText(),
                    txtTel.getText(),
                    TextCui.getText(),
                    txtDireccion.getText(),
                    TipoUsuario,
                    LocalDate.now().toString()
            );
            
            System.out.println("Usuario temporal creado: " + UsuarioTemporal); // indica que se ha craeado el usuario temporal
 
            // ACONTINUACION SE EJECUTA UNA SERIE DE VERIFICACIONES PARA REUTILIZAR EL CODIGO ANTERIOR, ESTO DEPENDIENDO DESDE DONDE SE LLAME
            // AL CONTROLADOR DE CREAR USUARIO
            // SI EL METODO inintVentana contiene la variable "gestionarUsuario" que ha sido declarada en el controlador GestionarUsuario
            if (Ventana.contains("gestionarUsuario")) {
                usuarioDB.updateUsuario(UsuarioTemporal); //implementa el metodo modificcar usuario 
            } else {
                usuarioDB.create(UsuarioTemporal); // si no tiene variable agrega el usuario temporal a la base de datos
                System.out.println("Agregando usuario...");
            }
//            for (Usuario user : nuevaBaseDeDatosSQL.ObtenerListaObservable()) {
//                System.out.println(user);
//                System.out.println(user.getTipoUsuario());
//            }

            // SI CONTIENE VENTANA USUARIOS DECLARADA EN GESTIONAR USUARIOS EN EL METODO AGREGAR USUARIOS REDIRECCIONA A GestionarUsuarios Y AGREGA UN NUEVO USUARIO
            // A LA TABLA DE USUARIOS EN EL MENU GESTIONAR USUARIOS
            if (Ventana.contains("Ventana Usuarios")) {
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
                        Logger.getLogger(LogeoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                
                Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
                myStage.close();
            } // SI LA VARIABLE CONTIENE VENTANA LOGEO CREA UN NUEVO USUARIO
            else if (Ventana.contains("Ventana Logeo")) {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/logeo.fxml"));
                Parent root = loader.load();
                LogeoController controlador = loader.getController();
                controlador.initVariable(TipoUsuario); // asignamos una variable para indicar que tiipo de usuario accedio
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
            } // SI LA VARIABLE TIENE GESRIONAR USUARIOS REDIRECCIONA A GESTIONAR USUARIOS Y MODIFICA UN USUARIO SELECCIONADO 
            else if (Ventana.contains("gestionarUsuarios")) {
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
                        Logger.getLogger(LogeoController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                });
                
                Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
                myStage.close();
                
            }
            
        } else { // VERIFICA QUE TODOS LOS CAMPOS ESTEN LLENOS CASO CONTRARIO LANZA UNAN NOTIFICAION
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Notificacion.fxml"));
            Parent root = loader.load();
            NotificacionController controlador = loader.getController();
            controlador.initNotifiacion("Uno de los campos esta vacio");
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
        }
        
    }
// ACA NOS ENCONTRAMOS MODIFICANDO UN USUARIO PERO SI LE DAMOS CANCELAR NOS REGRESA A LA VENTANA ANTERIOR QUE ES LA DE GESTIONAR USUARIOS DEL MENU ADMIN.

    @FXML
    void cancel(ActionEvent event) throws IOException {
        if (Ventana.contains("gestionarUsuarios")) {
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
                    Logger.getLogger(LogeoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
            myStage.close();
        }
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
        
    }
// METODO PARA INDICAR SI EL USUARIO CREADO ES UN ADMINISTRADOR O UN CLIENTE 

    public void Variable(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
        txtTitulo.setText(TipoUsuario);
    }
// METODO PARA ASIGNAR UNA VARIABLE A UN BLOQUE DE CODIGO Y RECUPERARLA Y EJECUTARLA EN OTRO BLOQUE DE CODIGO, CON EL FIN DE RECICLAR CODIGO Y VENTANAS 

    public void initVentana(String Ventana) {
        this.Ventana = Ventana;
    }
    
    void closeWindow() throws IOException {
        // METODOS PARA CERRAR O VOLVER A VENTANAS ANTERIORRES 
        if (Ventana.contains("Ventana Usuarios")) {
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
                    Logger.getLogger(LogeoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
            myStage.close();
        }
        if (Ventana.contains("gestionarUsuarios")) {
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
                    Logger.getLogger(LogeoController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            Stage myStage = (Stage) this.btnCrearUsuario.getScene().getWindow();
            myStage.close();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // METODO PARA LLENAR LOS CAMPOS DEL CONTROLADOR CREARUSUARIO Y PODER MODIFICAR LOS DATOS DEL INDICE SELECCIONADO
    public void MostrarUsuarioModificar(int indice) {
        this.Indice = indice;
        MostrarIndiceSelect();
        btnCrearUsuario.setText("Modificar");
    }
// METODO PARA RECUPERAR LA INFORMACION DEL INDICE SELECCIONADO A EDITAR

    public void MostrarIndiceSelect() {
        txtNombre.setText(BBDUsuarios.getBBDUsuarios(Indice).getNombre());
        txtApellido.setText(BBDUsuarios.getBBDUsuarios(Indice).getApellido());
        txtUser.setText(BBDUsuarios.getBBDUsuarios(Indice).getUs());
        txtPswd.setText(BBDUsuarios.getBBDUsuarios(Indice).getPwdUsuario());
        txtTel.setText(BBDUsuarios.getBBDUsuarios(Indice).getTelefono());
        TextCui.setText(BBDUsuarios.getBBDUsuarios(Indice).getCUI());
        txtDireccion.setText(BBDUsuarios.getBBDUsuarios(Indice).getDireccion());
        
    }
    public void ModificarUsuario(String cui, Usuario TempUser) {
    UsuariosDB usuariosDB = new UsuariosDB();
    Usuario usuarioActual = usuariosDB.read(cui);
    if (usuarioActual != null) {
        usuariosDB.updateUsuario(TempUser);
    } else {
        System.out.println("Usuario no encontrado.");
    }
}
    
}
