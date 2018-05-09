package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDTO.UsuarioDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author Usuario
 */
public interface UsuarioInt extends Remote{
    public UsuarioDTO solicitarAcceso(String codigo, String clave, String Area) throws RemoteException;
    public void notificar(String rol, String nombre)throws RemoteException;
    public void guardarArchivo(String codigo, String area, boolean acceso) throws RemoteException;
    public void registrarCallback(CallbackInt objRemoto)throws RemoteException;
}
