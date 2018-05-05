package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDTO.UsuarioAccesoInstalacionesDTO;
import Capa_Negocio.sop_rmi.listarUsuariosInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class listarUsuariosImpl extends UnicastRemoteObject implements listarUsuariosInt {

    public listarUsuariosImpl() throws RemoteException {
        super();
    }

    @Override
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuarios() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
