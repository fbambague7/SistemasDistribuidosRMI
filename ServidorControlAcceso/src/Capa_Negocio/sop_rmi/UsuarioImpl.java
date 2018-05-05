package Capa_Negocio.sop_rmi;

import Capa_Negocio.sop_rmi.UsuarioInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Usuario
 */
public class UsuarioImpl extends UnicastRemoteObject implements UsuarioInt {

    protected UsuarioImpl() throws RemoteException {
    }

    @Override
    public boolean solicitarAcceso(String codigo, String clave, String Area) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
