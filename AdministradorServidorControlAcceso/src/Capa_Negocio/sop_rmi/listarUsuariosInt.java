package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDTO.UsuarioAccesoInstalacionesDTO;
import Capa_Negocio.clasesDTO.UsuarioDTO;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface listarUsuariosInt extends Remote {
    
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosAcceso() throws RemoteException;
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosNoAcceso() throws RemoteException;
    
}
