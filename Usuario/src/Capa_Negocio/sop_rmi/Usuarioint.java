/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author JULIAN
 */
public class Usuarioint {

    /**
     * @param args the command line arguments
     */
    public interface UsuarioInt extends Remote{
    public boolean solicitarAcceso(String codigo, String clave, String Area) throws RemoteException;
    

}

    
}
