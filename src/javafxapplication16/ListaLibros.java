package javafxapplication16;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ListaLibros {

    // Creamos una base de datos para los libros creados
    private ArrayList<Libro> BBDLibros;
    //   private List<Libro> libros;

    public ListaLibros() {
        BBDLibros = new ArrayList<Libro>();

        BBDLibros.add(new Libro(
                "libro1",
                "libro1",
                "libro1",
                1,
                "libro1",
                1
        ));
        BBDLibros.add(new Libro(
                "libro2",
                "autor2",
                "titulo2",
                2020,
                "edit",
                1
        ));

    }

    public void AgregarLibro(Libro TempLibro) {
        BBDLibros.add(TempLibro);

    }

    public void EliminarLibro(int Indice) {
        BBDLibros.remove(Indice);

    }

    public void ModificarLibro(int Indice, Libro TempLibro) {

        if (Indice >= 0 && Indice < BBDLibros.size()) {
            BBDLibros.set(Indice, TempLibro);
        } else {

            System.out.println("Índice de libro no válido.");
        }
    }

    public ObservableList<Libro> ObtenerListaObservable() {
        return FXCollections.observableArrayList(BBDLibros);

    }

    public Libro getBBDLibros(int Indice) {
        return BBDLibros.get(Indice);
    }

    public void setBBDLibros(ArrayList<Libro> BBDLibros) {
        this.BBDLibros = BBDLibros;
    }

    public ArrayList<Libro> BuscarLibro(String criterioBusqueda) {
        ArrayList<Libro> resultadoBusqueda = new ArrayList<Libro>();
        for (Libro libroABuscar : BBDLibros) {
            if (libroABuscar.getIsbn().equalsIgnoreCase(criterioBusqueda)
                    || libroABuscar.getAutor().equalsIgnoreCase(criterioBusqueda)
                    || libroABuscar.getTitulo().equalsIgnoreCase(criterioBusqueda)) {
                resultadoBusqueda.add(libroABuscar);
            }
        }
        return resultadoBusqueda;

    }

    //METODO PARA VERIFICAR LA SOLVENCIA DEL USUARIO
    public boolean realizarPrestamo(Usuario usuario, Libro libro) {
        if (usuario.usuarioConPrestamosPendientes()) {
            System.out.println("No se puede realizar la transaccion debido a que el usuairo: " + usuario + "tiene prestamos pendientes");
            return false;
        }
        if (libro.getExistencia() <= 0) {
            System.out.println("Libro no disponible");
        }
        
        libro.setExistencia(libro.getExistencia() - 0);
        
        RegitroDePrestamosLibros nuevoRegistro = new RegitroDePrestamosLibros(libro, LocalDate.now());
                usuario.agregarPrestamo(nuevoRegistro);
            
            System.out.println("Transaccion realizda");
            return true;
    }

}
