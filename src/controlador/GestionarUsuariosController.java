/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import BaseDeDatos1.UsuariosDB;
import static controlador.InterfazController.BBDUsuarios;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafxapplication16.Usuario;


/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class GestionarUsuariosController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtBuscarUsuario;
    @FXML
    private Button btnBuscarUsuario;
    @FXML
    private TableView<Usuario> Table1;
    @FXML
    private TableColumn<Usuario, String> TableColumnNombre = new TableColumn<>("Nombre");
    @FXML
    private TableColumn<Usuario, String> TableColumnApellido = new TableColumn<>("Apellido");
    @FXML
    private TableColumn<Usuario, String> TableColumnUsuario = new TableColumn<>("Usuario");
    @FXML
    private TableColumn<Usuario, String> TableColumnFecha = new TableColumn<>("Fecha");
    @FXML
    private TableColumn<Usuario, String> TableColumnCui = new TableColumn<>("Cui");
    @FXML
    private TableColumn<Usuario, String> TableColumnTelefono = new TableColumn<>("Telefono");
    @FXML
    private TableColumn<Usuario, String> TableColumnTipoUsuario = new TableColumn<>("Tipo Usuario");
    ObservableList ListaObservable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      UsuariosDB usuariosDB = new UsuariosDB();
      ListaObservable = FXCollections.observableArrayList(usuariosDB.obtenerUsuarios());
        TableColumnNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        TableColumnApellido.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        TableColumnUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getUs()));
        TableColumnFecha.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getFechaCreacion()));
        TableColumnCui.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCUI()));
        TableColumnTelefono.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTelefono()));
        TableColumnTipoUsuario.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTipoUsuario()));

        Table1.setItems(ListaObservable);
        System.out.println("Inicializado");

    }

    @FXML
    private void AgregarUsuario(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/CrearUsuario.fxml"));
        Parent root = loader.load();
        CrearUsuarioController controlador = loader.getController();
        controlador.Variable("Cliente");
        controlador.initVentana("Ventana Usuarios");
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

        Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
        myStage.close();

    }
    
    
    @FXML
    private void ModificarUsuario(ActionEvent event) throws IOException {
 UsuariosDB usuarioDB = new UsuariosDB();
        int Indice = Table1.getSelectionModel().getSelectedIndex();
        if(Indice >= 0){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/CrearUsuario.fxml"));
        Parent root = loader.load();
        CrearUsuarioController controlador = loader.getController();
        controlador.Variable(BBDUsuarios.getTipoUsuario(Indice));
        controlador.MostrarUsuarioModificar(Indice);
        controlador.initVentana("gestionarUsuarios");
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

        Stage myStage = (Stage) this.btnBuscarUsuario.getScene().getWindow();
        myStage.close();
        }
        else{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Notificacion.fxml"));
                Parent root = loader.load();
                NotificacionController controlador = loader.getController();
                controlador.initNotifiacion("Seleccione un Usuario a modificar");
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.show();
        }
        

        
       // BBDUsuarios.ModificarUsuario(Table1.getSelectionModel().getSelectedIndex(), TempUser);
        
    }

    @FXML
    private void EliminarUsuario(ActionEvent event) {

        BBDUsuarios.EliminarUsuario(Table1.getSelectionModel().getSelectedIndex());

        ListaObservable = BBDUsuarios.ObtenerListaObservable();
        Table1.setItems(null);
        Table1.setItems(ListaObservable);

    }

    @FXML
    private void BuscarUsuarioDesdeEltxt(ActionEvent event) {
    }

    @FXML
    private void BuscarUsuario(ActionEvent event) {
    }

    void closeWindow() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/MenuAdmin.fxml"));
        Parent root = loader.load();
        MenuAdminController controlador = loader.getController();
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

        Stage myStage = (Stage) this.btnAgregar.getScene().getWindow();
        myStage.close();

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @FXML
    private void TableEvent(SortEvent event) {
    }

}
