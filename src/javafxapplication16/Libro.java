/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication16;

/**
 *
 * @author Windows 10
 */
public class Libro {
   private String isbn;
    private String titulo;
    private String Autor;
    private int    año;
    private String Editorial;
    private int existencia;

    public Libro(String isbn, String titulo, String Autor, int año, String Editorial, int existencia) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.Autor = Autor;
        this.año = año;
        this.Editorial = Editorial;
        this.existencia = existencia;
    }

    public Libro() {
    }
    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return Autor;
    }

    public void setAutor(String Autor) {
        this.Autor = Autor;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public String getEditorial() {
        return Editorial;
    }

    public void setEditorial(String Editorial) {
        this.Editorial = Editorial;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }
        public void verificarExistenciLibro(int existencia){
            if(existencia >= 0){
                System.out.println(existencia + "Unidades disponibles");
            }else{
                System.out.println("No hay existencias");
                
            }
    
    }
        public boolean usuarioSinPrestamosPendientes(Usuario usuario) {
       return false;
    //return usuario.getPrestamos().isEmpty();  // Suponiendo que tienes una lista de préstamos en Usuario
}
    
    @Override
   public String toString(){
       
        return "ISB" + this.isbn + 
               "Titulo" + this.titulo + 
               "Autor" + this.Autor + 
               "Año" + this.año + 
               "Editorial" + this.Editorial + 
               "Existencia" + this.existencia;
   }
   

}