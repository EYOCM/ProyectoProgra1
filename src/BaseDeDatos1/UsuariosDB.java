package BaseDeDatos1;

import BaseDeDatos1.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafxapplication16.Usuario;

public class UsuariosDB extends Usuario {

    private Connection conn; //interface de la libreria JDBC
    private Usuario tipoUsuario;
    

    public UsuariosDB() {
        conn = Conexion.getConnection();
        if (conn == null) {
            System.out.println("Conexión a la base de datos fallida.");
        } else {
            System.out.println("Conexión a la base de datos exitosa.");
        }
    }

    public void create(Usuario us) {
        if (us == null) {
            System.out.println("Usuario es nulo.");
            return;
        }
        PreparedStatement st = null; //VARIABLE QUE PERMITE EJECUTRA UNA CONSULTA SQL
        // CREAR SENTENCIA SQL PARA INSERTAR DATOS 
        try {
//            System.out.println("Longitud de nombre: " + us.getNombre().length());
//            System.out.println("Longitud de apellido: " + us.getApellido().length());
//            System.out.println("Longitud de usuario: " + us.getUs().length());
//            System.out.println("Longitud de pwdUsuario: " + us.getPwdUsuario().length());
//            System.out.println("Longitud de cui: " + us.getCUI().length());
//            System.out.println("Longitud de telefono: " + us.getTelefono().length());
//            System.out.println("Longitud de direccion: " + us.getDireccion().length());
//            System.out.println("Longitud de tipoUsuario: " + us.getTipoUsuario().length());
//            System.out.println("Longitud de fechaCreacion: " + us.getFechaCreacion().length());

            String sql = "INSERT INTO usuarioAdmin (nombre, apellido, us, pwdUsuario, cui, telefono, direccion, tipousuario,  fechaCreacion) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            st = conn.prepareStatement(sql);
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getUs());
            st.setString(4, us.getPwdUsuario());
            st.setString(5, us.getCUI());
            st.setString(6, us.getTelefono());
            st.setString(7, us.getDireccion());
            st.setString(8, us.getTipoUsuario());
            st.setString(9, us.getFechaCreacion());
            st.executeUpdate();
            System.out.println("Usuario agregado a la base de datos.");
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("Error al agregar usuario: " + ex.getMessage());

        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void updateUsuario(Usuario us) {
        PreparedStatement st = null;

        try {
            String sql = "UPDATE usuarioAdmin SET nombre = ?, apellido = ?, us = ?, pwdUsuario = ?, cui = ?, telefono = ?, direccion = ?, fechaCreacion = ?, tipousuario = ? WHERE cui = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, us.getNombre());
            st.setString(2, us.getApellido());
            st.setString(3, us.getUs());
            st.setString(4, us.getPwdUsuario());
            st.setString(5, getCUI());
            st.setString(6, us.getTelefono());
            st.setString(7, us.getDireccion());
            st.setString(8, us.getFechaCreacion());
            st.setString(9, us.getTipoUsuario());
            st.executeUpdate();

            System.out.println("Usuario modificado correctemente en la base de datos");

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public void eliminar(String CUI) {
        PreparedStatement st = null;

        try {
            String sql = "DELETE FROM usuariosAdmin WHERE cui = ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, CUI);

            st.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    public Usuario read(String CUI) {

        PreparedStatement st = null;
        ResultSet rs = null;
        Usuario us = new Usuario();

        try {
            String sql = " SELECT * FROM usuarioAdmin  WHERE cui = ? ";
            st = conn.prepareStatement(sql);
            st.setString(1, CUI);
            rs = st.executeQuery();

            while (rs.next()) {
                us.setNombre(rs.getString(1));
                us.setApellido(rs.getString(2));
                us.setUs(rs.getString(3));
                us.setPwdUsuario(rs.getString(4));
                us.setCUI(rs.getString(5));
                us.setTelefono(rs.getString(6));
                us.setDireccion(rs.getString(7));
                us.setFechaCreacion(rs.getString(8));
                us.setTipoUsuario(rs.getString(9));
                return us;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }

                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return null;
    }
//    
//    public ArrayList<Estudiante> readAll() {
//        
//        Statement st = null;
//        ResultSet rs = null; // almacenar el registro que se obtuvo desde la base de datos 
//        ArrayList<Estudiante> a = new ArrayList();
//        
//        try {
//            String sql = " SELECT *  FROM estudiante";
//            st = conn.createStatement();
//            rs = st.executeQuery(sql);
//            while (rs.next()) {
//                
//                Estudiante e = new Estudiante();
//                
//                e.setCarne(rs.getString(1));
//                e.setNombres(rs.getString(2));
//                e.setApellidos(rs.getString(3));
//                e.setEdad(rs.getInt(4));
//                String sexo = rs.getString(5);
//                if (sexo != null) {
//                    e.setSexo(rs.getString(5).charAt(0));
//                }
//                
//                a.add(e);
//            }
//            
//            return a;
//        } catch (SQLException ex) {
//            Logger.getLogger(EstudianteDB.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            try {
//                if (rs != null) {
//                    rs.close();
//                }
//                
//                if (st != null) {
//                    st.close();
//                }
//            } catch (SQLException ex) {
//                Logger.getLogger(EstudianteDB.class.getName()).log(Level.SEVERE, null, ex);
//            }
//        }
//
//        return null;
//    }
    
    public boolean validarUsuario(String user, String pwd, String tipo) {
        PreparedStatement st = null;
        ResultSet rs = null;
        boolean encontrado = false;

        try {
            String sql = "SELECT * FROM usuarioAdmin WHERE us = ? AND pwdUsuario = ? AND tipousuario = ?";
            st = conn.prepareStatement(sql);
            st.setString(1, user);
            st.setString(2, pwd);
            st.setString(3, tipo);
            rs = st.executeQuery();

            if (rs.next()) {
                encontrado = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
                if (st != null) {
                    st.close();
                }
            } catch (SQLException ex) {
                Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return encontrado;
    }

public List<Usuario> obtenerUsuarios() {
    List<Usuario> usuarios = new ArrayList<>();
    PreparedStatement st = null;
    ResultSet rs = null;

    try {
        String sql = "SELECT * FROM usuarioAdmin";
        st = conn.prepareStatement(sql);
        rs = st.executeQuery();

        while (rs.next()) {
            Usuario usuario = new Usuario();
            usuario.setNombre(rs.getString("nombre"));
            usuario.setApellido(rs.getString("apellido"));
            usuario.setUs(rs.getString("us"));
            usuario.setFechaCreacion(rs.getString("fechaCreacion"));
            usuario.setCUI(rs.getString("cui"));
            usuario.setTelefono(rs.getString("telefono"));
            usuario.setTipoUsuario(rs.getString("tipousuario"));
            usuarios.add(usuario);
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
    } finally {
        try {
            if (rs != null) {
                rs.close();
            }
            if (st != null) {
                st.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    return usuarios;
}

}
