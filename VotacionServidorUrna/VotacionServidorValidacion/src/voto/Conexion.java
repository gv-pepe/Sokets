package voto;


import java.sql.*;
import javax.swing.JOptionPane;
public class Conexion {

    private Connection conexion;

    public Connection getConexion() {
        return conexion;
    }

    public void setConexion(Connection conexion) {
        this.conexion = conexion;
    }

    public Conexion conectar() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String BaseDeDatos = "jdbc:mysql://localhost/Electores?user=root&password=123456789";
            setConexion(DriverManager.getConnection(BaseDeDatos));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
        }

        return this;
    }

    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e,"Error",JOptionPane.ERROR_MESSAGE);
    
            return null;
        }
        return resultado;
    }

    public boolean ejecutar(String sql) {
        try {
            Statement sentencia = getConexion().createStatement(ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY);
            sentencia.executeUpdate(sql);
            sentencia.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null,e,"MOVIE PLANET",JOptionPane.ERROR_MESSAGE);
   
            return false;
        }
        return true;
    }
}
