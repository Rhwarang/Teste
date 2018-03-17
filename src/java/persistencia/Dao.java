package persistencia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Dao {
    protected Connection con;
    protected PreparedStatement stmt;
    protected ResultSet rs;
    
    
    public void abrirConexao() throws Exception{
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3307/rodoviaria", "root", "1234");
    }
    
    public void fecharConexao(){
        try {
            con.close();
        } catch (Exception e) {
        }
    }
}
