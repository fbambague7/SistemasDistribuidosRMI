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
    private consultarUsuariosInt consultar;

    protected UsuarioImpl() throws RemoteException {
    }

    @Override
    public int solicitarAcceso(String codigo, String clave, String Area) throws RemoteException {
        int indAcceso = 0;
        consultar.esUsuarioRegistrado(codigo);
        return indAcceso;                
    }

    @Override
    public void notificar(String rol, String nombre) throws RemoteException{
        Callback.notificarIngresoUsuario(rol, nombre);
    }

    
}
