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
    public boolean eliminarUsuario(String nombre) throws RemoteException;
    public boolean consultarUsuario (String codigo, String clave, String area)throws RemoteException;
}
