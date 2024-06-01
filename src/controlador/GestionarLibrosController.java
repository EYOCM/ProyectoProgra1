/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.InterfazController.BBDLibros;
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
import javafxapplication16.Libro;

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class GestionarLibrosController implements Initializable {

    @FXML
    private Button btnAgregar;
    @FXML
    private Button btnModificar;
    @FXML
    private Button btnEliminar;
    @FXML
    private TextField txtBuscarLibro;
    @FXML
    private Button btnBuscarLibro;
    @FXML
    private TableView<Libro> Table1;
    @FXML
    private TableColumn<Libro, String> TableColumnISBN = new TableColumn<>("ISBN");
    @FXML
    private TableColumn<Libro, String> TableColumnTitulo = new TableColumn<>("Titulo");
    @FXML
    private TableColumn<Libro, String> TableColumnAutor = new TableColumn<>("Autor");
    @FXML
    private TableColumn<Libro, String> TableColumnPublicacion = new TableColumn<>("Publicacion");
    @FXML
    private TableColumn<Libro, String> TableColumnEditorial = new TableColumn<>("Editorial");
    @FXML
    private TableColumn<Libro, String> TableColumnExistencia = new TableColumn<>("Existencia");
    @FXML
    private Button btnAgregar1;
    @FXML
    private TableColumn<Libro, String> TableColumnTipoLibro = new TableColumn<>("Tipo Libro");
    ObservableList ListaObservable = BBDLibros.ObtenerListaObservable();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ListaObservable = BBDLibros.ObtenerListaObservable();
        TableColumnISBN.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIsbn()));
        TableColumnTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        TableColumnAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        TableColumnPublicacion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAño())));
        TableColumnEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        TableColumnExistencia.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getExistencia())));

        Table1.setItems(ListaObservable);
        System.out.println("Inicializado");

    }

    @FXML
    private void AgregarLibro(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroLibros.fxml"));
        Parent root = loader.load();
        RegistroLibrosController controlador = loader.getController();
        controlador.Variable("Cliente");
        controlador.initVentana("Agregar Libro Gestion");
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
    private void ModificarLibro(ActionEvent event) throws IOException {
        int Indice = Table1.getSelectionModel().getSelectedIndex();
        if (Indice >= 0) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroLibros.fxml"));
            Parent root = loader.load();
            RegistroLibrosController controlador = loader.getController();
            controlador.Variable(BBDUsuarios.getTipoUsuario(Indice));
            controlador.MostrarLibroModificar(Indice);
            controlador.initVentana("Gestionar Libros");
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

            Stage myStage = (Stage) this.btnBuscarLibro.getScene().getWindow();
            myStage.close();
        } else {
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
    private void EliminarLibro(ActionEvent event) {

        BBDLibros.EliminarLibro(Table1.getSelectionModel().getSelectedIndex());

        ListaObservable = BBDLibros.ObtenerListaObservable();
        Table1.setItems(null);
        Table1.setItems(ListaObservable);

    }

    @FXML
    private void BuscarLibroDesdeEltxt(ActionEvent event) {
    }

    @FXML
    private void BuscarLibro(ActionEvent event) {
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
    private void TableEvent(SortEvent<Libro> event) {
    }

}
