package Capa_Negocio.sop_rmi;



import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Capa_Negocio.clasesDTO.UsuarioDTO;

public class listarUsuariosImpl extends UnicastRemoteObject implements listarUsuariosInt {

    public listarUsuariosImpl() throws RemoteException {
        super();
    }


    @Override
    public ArrayList<UsuarioDTO> listarUsuarios() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
