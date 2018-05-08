package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDAO.UsuarioDAO;
import Capa_Negocio.clasesDTO.EnumArea;
import Capa_Negocio.clasesDTO.EnumRol;
import Capa_Negocio.clasesDTO.UsuarioDTO;
import Capa_Negocio.sop_rmi.UsuarioInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author Usuario
 */
public class UsuarioImpl extends UnicastRemoteObject implements UsuarioInt {
    
    UsuarioDTO usuarioDTO;
    UsuarioDAO usuarioDAO;
    private CallbackInt Callback;
    private estaUsuariosInt consultar;

    protected UsuarioImpl() throws RemoteException {
        super();
        usuarioDTO = new UsuarioDTO();
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public UsuarioDTO solicitarAcceso(String codigo, String clave, String area) throws RemoteException {
        usuarioDTO = null;
        usuarioDTO=consultar.esUsuarioRegistrado(codigo);
        return usuarioDTO;                
    }

    @Override
    public void notificar(String rol, String nombre) throws RemoteException{
        Callback.notificarIngresoUsuario(rol, nombre);
    }
    
    public void guardarArchivo(String codigo, String area, boolean acceso) throws RemoteException{
            usuarioDAO.solicitar(codigo, area, acceso);
    }

    
}
