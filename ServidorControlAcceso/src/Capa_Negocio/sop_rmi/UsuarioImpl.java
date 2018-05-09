package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDAO.UsuarioDAO;
import Capa_Negocio.clasesDTO.EnumArea;
import Capa_Negocio.clasesDTO.EnumRol;
import Capa_Negocio.clasesDTO.UsuarioDTO;
import Capa_Negocio.sop_rmi.UsuarioInt;
import Capa_Presentacion.Inicio;
import Capa_Presentacion.JFrameServidorCA;
import java.io.IOException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class UsuarioImpl extends UnicastRemoteObject implements UsuarioInt {
   
    UsuarioDTO usuarioDTO;
    UsuarioDAO usuarioDAO;
    private CallbackInt Callback;
    private estaUsuariosInt consultar;
    
    private static Inicio nuevo = new Inicio();

    public UsuarioImpl() throws RemoteException {
        super();
        usuarioDTO = new UsuarioDTO();
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public UsuarioDTO solicitarAcceso(String codigo, String clave, String area) throws RemoteException {
        usuarioDTO = null;
        usuarioDTO = nuevo.objRemotoEsta.obtenerUsuarioRegistrado(codigo, clave, area);
        //usuarioDTO=consultar.obtenerUsuarioRegistrado(codigo, clave, area);
        return usuarioDTO;                
    }

    @Override
    public void notificar(String rol, String nombre) throws RemoteException{
        Callback.notificarIngresoUsuario(rol, nombre);
    }
    
    public void guardarArchivo(String codigo, String area, boolean acceso) throws RemoteException{
        try {
            usuarioDAO.solicitar(codigo, area, acceso);
        } catch (IOException ex) {
            Logger.getLogger(UsuarioImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
   public void registrarCallback(CallbackInt objRemoto)throws RemoteException
        {
            System.out.println("invocando a registrar");
            Callback=objRemoto;
        }


    
}
