package Capa_Negocio.sop_rmi;


import Capa_Negocio.clasesDTO.UsuarioDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;


/**
 *
 * @author Usuario
 */
public interface gestionUsuariosInt extends Remote{
    public boolean registrarUsuario(UsuarioDTO usuario) throws RemoteException;
    public boolean modificarUsuario(UsuarioDTO usuario) throws RemoteException;
    public boolean eliminarUsuario(String codigo) throws RemoteException;
    public UsuarioDTO consultarUsuario (String codigo)throws RemoteException;
}
