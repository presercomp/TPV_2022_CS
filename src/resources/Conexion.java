
package resources;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.ResultSet;

public class Conexion {
    private String _server;
    private String _user;
    private String _pass;
    private String _dbName;
    private String _url;
    
    private int _port;
    private Statement _stmt;
    private Connection _conn;
    
    
    public Conexion(){
        this._server = "localhost";
        this._user = "root";
        this._pass = "";
        this._dbName = "terminal_ventas";
        this._url = "jdbc:mysql://"+this._server+":3306/"+this._dbName;
        System.out.println(this._url);
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this._conn = DriverManager.getConnection(this._url, 
                    this._user,
                    this._pass);
            this._stmt = this._conn.createStatement();
        } catch(ClassNotFoundException | SQLException ex){
            System.out.println("Error al conectar servicio: "+ex.getMessage());
        }
    }

    public ResultSet ejecutar(String sql){
        ResultSet resultado = null;
        try {
            resultado = this._stmt.executeQuery(sql);
        } catch(SQLException ex){
            System.out.println("Error al ejecutar consulta: "+
                    ex.getMessage());
        }
        return resultado;
    }
}
