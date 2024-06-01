
package javafxapplication16;

import controlador.RegistroLibrosController;
import java.util.ArrayList;
import java.util.List;

public class Usuario {

    public Usuario(int Indice) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getUs() {
        return Us;
    }

    public void setUs(String Us) {
        this.Us = Us;
    }

    public String getPwdUsuario() {
        return PwdUsuario;
    }

    public void setPwdUsuario(String PwdUsuario) {
        this.PwdUsuario = PwdUsuario;
    }

    public String getCUI() {
        return CUI;
    }

    public void setCUI(String CUI) {
        this.CUI = CUI;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTipoUsuario() {
        return TipoUsuario;
    }

    public void setTipoUsuario(String TipoUsuario) {
        this.TipoUsuario = TipoUsuario;
    }

    public String getFechaCreacion() {
        return FechaCreacion;
    }

    public void setFechaCreacion(String FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    String Nombre;
    String Apellido;
    String Us;
    String PwdUsuario;
    String CUI;
    String Telefono;
    String Direccion;
    String TipoUsuario;
    String FechaCreacion;
    private String fechaRegistro;
    private ArrayList<RegitroDePrestamosLibros> prestamos;

    public Usuario(String Nombre, String Apellido, String Us, String PwdUsuario, String CUI, String Telefono, String Direccion, String TipoUsuario, String FechaCreacion) {
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Us = Us;
        this.PwdUsuario = PwdUsuario;
        this.CUI = CUI;
        this.Telefono = Telefono;
        this.Direccion = Direccion;
        this.TipoUsuario = TipoUsuario;
        this.FechaCreacion = FechaCreacion;
        this.prestamos = new ArrayList<>();
    }

//    public Usuario() {
//    }
    public Usuario() {
        this.prestamos = new ArrayList<>(); // instancia del arraylist de prestamos 
    }

    public List<RegitroDePrestamosLibros> getPrestamos() { // creamos una lista para acceder a los registros de prestamos 
        return prestamos;
    }

    public void agregarPrestamo(RegitroDePrestamosLibros prestamo) {
        prestamos.add(prestamo);
    }
    public void devolverLibro(RegitroDePrestamosLibros prestamo){
    prestamos.remove(prestamo);
    }
    // METODO PARA VERIFICAR SI EL USUARIO TIENE PRESTAMO PENDIENTES
    public boolean usuarioConPrestamosPendientes(){
    for(RegitroDePrestamosLibros prestamo: prestamos) //RECORRE EL ARRAY DE PRESTAMOS Y VERIFICA SI AUN NO SE HA DEVUELTO.
        if(prestamo.getFechaDevolucion() == null){
        return true;
        }
    return false;
    }
}
