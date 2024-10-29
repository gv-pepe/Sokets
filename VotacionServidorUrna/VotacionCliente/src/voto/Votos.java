/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package voto;


import java.rmi.Remote;
import java.rmi.RemoteException;
import javax.swing.JTable;

/**
 *
 * @author gis_k
 */
public interface Votos extends Remote {

    public String[][] recuento() throws RemoteException;

    public void votar(String candidato) throws RemoteException;
}
