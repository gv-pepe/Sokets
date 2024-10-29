
package voto;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class ImplementarValidarCliente extends UnicastRemoteObject implements ValidarCliente{

    public ImplementarValidarCliente()throws RemoteException{}
    
    
    public String[] verificar_votante(int dni) throws RemoteException {
        
        Conexion mysql = new Conexion();
        mysql.conectar();
        
        String sql = "select nombre, apellido_paterno, apellido_materno, direccion from electores where dni = "+dni+";";
              
        ResultSet resultado= mysql.consultar(sql);
        
        String datos[]=new String[4];
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    datos[0]=resultado.getString("nombre");
                    datos[1]=resultado.getString("apellido_paterno");                           
                    datos[2]=resultado.getString("apellido_materno");
                    datos[3]=resultado.getString("direccion");
       
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(ImplementarValidarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }
              
          
        return datos;
    }
    
    public boolean verificar_voto(int dni)throws RemoteException{
    Conexion mysql = new Conexion();
        mysql.conectar();
        
        
        
        
        String sql = "select voto from electores where dni = "+dni;
              
        ResultSet resultado=mysql.consultar(sql);
        
        boolean voto=false;
          if(resultado!=null){
            try {
                while(resultado.next()){
                    
                    voto = resultado.getBoolean("voto");
                  
                }
            } catch (SQLException ex) {
                Logger.getLogger(ImplementarValidarCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
      
             }
          
        return voto;
    }

    public void enviar_voto(String voto,int dni) throws RemoteException {
     
        
        Registry register;
        try {
            register = LocateRegistry.getRegistry("192.168.1.74",3000);
            votos miInerfaz =(votos)register.lookup("urna");
            miInerfaz.votar(voto);
            
            Conexion mysql = new Conexion();
              mysql.conectar();
        
              mysql.ejecutar("update electores set voto = true where dni ="+dni);
        
            
        } catch (RemoteException ex) {
            Logger.getLogger(ImplementarValidarCliente.class.getName()).log(Level.SEVERE, null, ex);
        }catch(NotBoundException ex){
            System.out.println(""+ex.getMessage());
        }
        
    }
    
}
