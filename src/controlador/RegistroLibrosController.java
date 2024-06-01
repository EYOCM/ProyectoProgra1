/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import static controlador.InterfazController.BBDLibros;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import static javafxapplication16.JavaFXApplication16.Base_En_Memoria;
import javafxapplication16.Libro;

/**
 * FXML Controller class
 *
 * @author Windows 10
 */
public class RegistroLibrosController implements Initializable {

    private String TipoUsuario;
    private String Ventana;
    private int Indice;

    public void Variable(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;

    }

    public void initVentana(String Ventana) {
        this.Ventana = Ventana;
    }

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
    private void AgregarLibroAlRegistro(ActionEvent event) throws IOException {
        if (!TxtIsbn.getText().isEmpty()
                && !TxtTitulo.getText().isEmpty()
                && !TxtAutor.getText().isEmpty()
                && !TxtAñoPublicacion.getText().isEmpty()
                && !TextEditorial.getText().isEmpty()
                && !TxtCantidadIngresar.getText().isEmpty()) {

            Libro LibroTemporal = new Libro(
                    TxtIsbn.getText(),
                    TxtTitulo.getText(),
                    TxtAutor.getText(),
                    Integer.parseInt(TxtAñoPublicacion.getText()),
                    TextEditorial.getText(),
                    Integer.parseInt(TxtCantidadIngresar.getText())
            );

            System.out.println(LibroTemporal);
            if (Ventana.contains("MenuAdmin")) {
                BBDLibros.AgregarLibro(LibroTemporal);
                for (Libro libro : BBDLibros.ObtenerListaObservable()) {
                    System.out.println(libro);
                }
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

                Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
                myStage.close();
            }
            if (Ventana.contains("Agregar Libro Gestion")) {
                BBDLibros.AgregarLibro(LibroTemporal);
                for (Libro libro : BBDLibros.ObtenerListaObservable()) {
                    System.out.println(libro);
                }
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionarLibros.fxml"));
                Parent root = loader.load();
                GestionarLibrosController controlador = loader.getController();
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

                Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
                myStage.close();
            }
            if (Ventana.contains("Gestionar Libros")) {
                BBDLibros.ModificarLibro(Indice, LibroTemporal);
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionarLibros.fxml"));
                Parent root = loader.load();
                GestionarLibrosController controlador = loader.getController();
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

                Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
                myStage.close();
            }

        }
    }

    @FXML
    private void SalirRegistroLibros(ActionEvent event) throws IOException {

        if ((Ventana.contains("MenuAdmin"))) {
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

            Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
            myStage.close();
        }

        if ((Ventana.contains("Gestionar Libros")) || (Ventana.contains("Agregar Libro Gestion"))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionarLibros.fxml"));
            Parent root = loader.load();
            GestionarLibrosController controlador = loader.getController();
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

            Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
            myStage.close();
        }

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

    public void MostrarLibroModificar(int indice) {
        this.Indice = indice;
        MostrarIndiceSelect();
        btnAgregarLibroAlRegistro.setText("Modificar Libro");
    }

    public void MostrarIndiceSelect() {
        TxtIsbn.setText(BBDLibros.getBBDLibros(Indice).getIsbn());
        TxtTitulo.setText(BBDLibros.getBBDLibros(Indice).getTitulo());
        TxtAutor.setText(BBDLibros.getBBDLibros(Indice).getAutor());
        TxtAñoPublicacion.setText(String.valueOf(BBDLibros.getBBDLibros(Indice).getAño()));
        TxtCantidadIngresar.setText(String.valueOf(BBDLibros.getBBDLibros(Indice).getExistencia()));
        TextEditorial.setText(BBDLibros.getBBDLibros(Indice).getEditorial());

    }

    void closeWindow() throws IOException {
        if (Ventana.contains("MenuAdmin")) {
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

            Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
            myStage.close();
        }

        if ((Ventana.contains("Gestionar Libros")) || (Ventana.contains("Agregar Libro Gestion"))) {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/GestionarLibros.fxml"));
            Parent root = loader.load();
            GestionarLibrosController controlador = loader.getController();
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

            Stage myStage = (Stage) this.btnAgregarLibroAlRegistro.getScene().getWindow();
            myStage.close();
        }

    }

}
