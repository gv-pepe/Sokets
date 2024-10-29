package voto;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ImplementarVoto extends UnicastRemoteObject implements votos{

    public ImplementarVoto()throws RemoteException{}
    
    
    
@Override
    public String[][] recuento() throws RemoteException {
    //public JTable recuento(JTable recuento_de_votos) throws RemoteException {
        
        Conexion mysql = new Conexion();
        mysql.conectar();
      
        String sql;
        
        DefaultTableModel model;
        String[] titulos={"CANDIDATOS","VOTOS"};
        String[][] registro=new String[3][2];
       // model=new DefaultTableModel(null,titulos);
       // recuento_de_votos.setModel(model);
        
       sql = "select candidato CANDIDATO ,count(candidato) VOTOS from urna group by(candidato)";
              ResultSet resultado=mysql.consultar(sql);
        int cont=0;
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    registro[cont][0]=resultado.getString("CANDIDATO");
                    registro[cont][1]=Integer.toString(resultado.getInt("VOTOS"));
                           cont++;
                }
            } catch (SQLException ex) {
                Logger.getLogger(ImplementarVoto.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }           
        return registro;        
    }

    @Override
    public void votar(String candidato) throws RemoteException {
    Conexion mysql = new Conexion();
        mysql.conectar();
        
        mysql.ejecutar("INSERT INTO urna VALUES ('"+candidato+"')");
        
    }


       
}
