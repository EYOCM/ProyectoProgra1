
package javafxapplication16;

import java.time.LocalDate;


public class RegitroDePrestamosLibros {
        private Libro libro;
    private LocalDate fechaInicio;
    private LocalDate fechaDevolucion;

    public RegitroDePrestamosLibros(Libro libro, LocalDate fechaInicio) {
        this.libro = libro;
        this.fechaInicio = fechaInicio;
        this.fechaDevolucion = null;
    }
        public Libro getLibro() {
        return libro;
    }
            public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(LocalDate fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    @Override
    public String toString() {
        return "Prestamo{" +
                "libro=" + libro +
                ", fechaInicio=" + fechaInicio +
                ", fechaDevolucion=" + fechaDevolucion +
                '}';
    }
}
