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

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }
    
    public boolean create(String apodo, String clave){
        String query = "INSERT INTO usuarios (clave, apodo) VALUES ('"+clave+"', '"+apodo+"')";
        Conexion c = new Conexion();
        ResultSet r = c.ejecutar(query);        
       try {           
            return r.next();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public ResultSet result(){
        String query = "SELECT * FROM usuarios";
        Conexion c = new Conexion();
        return c.ejecutar(query);                
    }
    
    public boolean update(int id_usuario, String apodo, String clave){
        String query = "UPDATE usuarios SET clave = '"+clave+"', ";
        query+= " apodo ='"+apodo+"' WHERE id_usuario = "+id_usuario+");";
        Conexion c = new Conexion();
        ResultSet r = c.ejecutar(query);        
        try {           
            return r.next();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean delete(int id_usuario){
        String query = "DELETE FROM usuarios WHERE id_usuario = '"+id_usuario+"'";
        Conexion c = new Conexion();
        ResultSet r = c.ejecutar(query);        
        try {           
            return r.next();
        } catch (SQLException ex) {
            Logger.getLogger(Usuarios.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
