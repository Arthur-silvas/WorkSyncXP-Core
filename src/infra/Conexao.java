package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Conexao {

    public final String url = "jdbc:mysql://127.0.0.1:3306/pi01_arthur_pompollo";
    public final String user = "root";
    public final String password = "";

    Connection conn;
    PreparedStatement st;
    
    public Connection conectar(){
        conn = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url,user,password);
        }catch(ClassNotFoundException | SQLException sqle){
            JOptionPane.showMessageDialog(null, "Erro de conexão");
            System.out.println("Erro de conexão: " + sqle.getMessage());
        }
        return conn;
    }
    
    public void desconectar(Connection conn) {
        try {
            if (conn != null && !conn.isClosed()) {
                conn.close();
                System.out.println("Voce se desconectou do banco de dados.");
            }
        } catch (SQLException ex) {
            System.out.println("Nao foi possivel desconectar do banco dados.");
        }
    }
}
