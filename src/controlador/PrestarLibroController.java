package controlador;

import com.sun.org.apache.bcel.internal.generic.AALOAD;
import static controlador.InterfazController.BBDLibros;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.SortEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import static javafx.scene.input.KeyCode.C;
import javafx.stage.Stage;
import javafxapplication16.Libro;
import javafxapplication16.ListaLibros;
import javafxapplication16.Usuario;

public class PrestarLibroController implements Initializable {

    @FXML
    private TextField txtBuscarLibro;
    @FXML
    private Button btnBuscarLibro;
    @FXML
    private Button btnPrestarLibro;
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

    private TableColumn<Libro, String> TableColumnTipoLibro = new TableColumn<>("Tipo Libro");
    ObservableList ListaObservable = BBDLibros.ObtenerListaObservable();
    private Usuario usuario;
    @FXML
    private TextArea txtResultadosBusqueda;
    private ListaLibros BBLibros;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ListaObservable = BBDLibros.ObtenerListaObservable();
        TableColumnISBN.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIsbn()));
        TableColumnTitulo.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getTitulo()));
        TableColumnAutor.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getAutor()));
        TableColumnPublicacion.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getAño())));
        TableColumnEditorial.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getEditorial()));
        TableColumnExistencia.setCellValueFactory(cellData -> new SimpleStringProperty(String.valueOf(cellData.getValue().getExistencia())));

        Table1.setItems(ListaObservable);

    }

    @FXML
    private void BotonParaBuscarLibroEnBBDLibros(ActionEvent event) {
        if (!txtBuscarLibro.getText().isEmpty()) {
            String termino = txtBuscarLibro.getText();
            ArrayList<Libro> resultados = BBDLibros.BuscarLibro(termino);
            ObservableList<Libro> observableResultados = FXCollections.observableArrayList(resultados);
            Table1.setItems(observableResultados);
            if (resultados.isEmpty()) {
                txtResultadosBusqueda.setText("No se encontraron resultados.");
            } else {
                txtResultadosBusqueda.clear();
            }
        } else {
            ListaObservable = BBDLibros.ObtenerListaObservable();
            Table1.setItems(ListaObservable);
        }

    }

    @FXML
    private void BotonParaRealizarPrestamoLibro(ActionEvent event) {
        try {
            Libro libroAPrestar = Table1.getSelectionModel().getSelectedItem();

            if (libroAPrestar != null && usuario != null) {
                boolean prestamoRealizadoExitosamente = BBDLibros.realizarPrestamo(usuario, libroAPrestar);
                if (prestamoRealizadoExitosamente) {
                    Table1.refresh();
                    System.out.println("Préstamo realizado con éxito.");
                } else {
                    System.out.println("No se pudo realizar el préstamo.");
                }
            } else {
                System.out.println("Usuario o libro no puede ser null.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void closeWindow() {
        Stage myStage = (Stage) this.btnPrestarLibro.getScene().getWindow();
        myStage.close();
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.

    }

    @FXML
    private void TableEvent(SortEvent<Libro> event) {
    }

}
