
package javafxapplication16;

import BaseDeDatos1.UsuariosDB;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javax.swing.JOptionPane;

/**
 *
 * @author Windows 10
 */
public class ListaUsuarios {

    //private ArrayList<Usuario> BBDUsuarios;
    private UsuariosDB nuevaBaseDeDatosSQL;

    public ListaUsuarios() {
nuevaBaseDeDatosSQL = new UsuariosDB();
    }

    public void AgregarUsuario(Usuario TempUser) {
        nuevaBaseDeDatosSQL.create(TempUser);

    }
    
    public void EliminarUsuario(int Indice) {
        Usuario usuario = nuevaBaseDeDatosSQL.obtenerUsuarios().get(Indice);
        if (usuario != null) {
            nuevaBaseDeDatosSQL.eliminar(usuario.getCUI());
        } else {
            System.out.println("Índice de usuario no válido.");
        }
    }
    public void ModificarUsuario(int Indice, Usuario TempUser) {
        Usuario usuario = nuevaBaseDeDatosSQL.obtenerUsuarios().get(Indice);
        if (usuario != null) {
            nuevaBaseDeDatosSQL.updateUsuario(TempUser);
        } else {
            System.out.println("Índice de usuario no válido.");
        }
    }
        
    

public Boolean ValidarUsuario(String user, String pwd, int intentos, String Tipo) {
    UsuariosDB nuevaBaseDeDatosSQL = new UsuariosDB();
    boolean encontrado = nuevaBaseDeDatosSQL.validarUsuario(user, pwd, Tipo);

    if (encontrado) {
        intentos = 0; // Resetear intentos en caso de éxito
    } else {
        intentos++;
        if (intentos == 3) { // Cerrar el programa después de 3 intentos fallidos
            System.exit(0);
        }
    }

    return encontrado;
}
    
    public ObservableList<Usuario> ObtenerListaObservable(){
        return FXCollections.observableArrayList(nuevaBaseDeDatosSQL.obtenerUsuarios());
        
        
    } 
    public String getTipoUsuario(int Indice) {
        Usuario usuario = nuevaBaseDeDatosSQL.obtenerUsuarios().get(Indice);
        return usuario != null ? usuario.getTipoUsuario() : null;
    }

    public Usuario getBBDUsuarios(int Indice) {
        return nuevaBaseDeDatosSQL.obtenerUsuarios().get(Indice);
    }

//    public void setBBDUsuarios(ArrayList<Usuario> BBDUsuarios) {
//        this.BBDUsuarios = BBDUsuarios;
//    }
    
}
