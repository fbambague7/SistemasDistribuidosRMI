package Capa_Negocio.sop_rmi;

import Capa_Negocio.sop_rmi.UsuarioInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Usuario
 */
public class UsuarioImpl extends UnicastRemoteObject implements UsuarioInt {
    
    private CallbackInt Callback;

    protected UsuarioImpl() throws RemoteException {
    }

    @Override
    public boolean solicitarAcceso(String codigo, String clave, String Area) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void notificar(String rol, String nombre) throws RemoteException{
        Callback.notificarIngresoUsuario(rol, nombre);
    }

    
}
