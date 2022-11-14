package models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import resources.Conexion;

public class Usuarios {
    private int id_usuario;
    private String apodo;
    private String clave;
    
    public boolean login(String usuario, String clave) {
        Conexion c = new Conexion();
        ResultSet r = c.ejecutar("SELECT * FROM usuarios WHERE apodo = '"+ usuario +"' AND clave = '"+ clave +"'; ");
        try {
            return r.next();
        } catch (SQLException ex) {
            return false;
        }
    }
}
