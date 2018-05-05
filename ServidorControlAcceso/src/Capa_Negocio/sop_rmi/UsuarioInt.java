package Capa_Negocio.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Usuario
 */
public interface UsuarioInt extends Remote{
    public int solicitarAcceso(String codigo, String clave, String Area) throws RemoteException;
    public void notificar(String rol, String nombre)throws RemoteException;
}
