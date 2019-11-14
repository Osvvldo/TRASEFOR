
package clases;
import clases.ConexionMySQL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    private int id_usuario;
    private String apodo;
    private String clave;
    
    public Usuario()  {
        
    }
    public static boolean conector(String usuario, String clave){
       boolean valido = false;
       ConexionMySQL sql = new ConexionMySQL();
       String query = "SELECT *FROM usuario ";
       query += "WHERE apodo = '" + usuario+ "' ";
       query += "AND clave = '" +clave+ "' ";
       
     
        try {
            Statement s = sql.conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            int filas =0;
            while(rs.next()){
                filas++;
                
            }
            if (filas ==1){
                valido = true;
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
       return valido;
       
    }
    
    
}
