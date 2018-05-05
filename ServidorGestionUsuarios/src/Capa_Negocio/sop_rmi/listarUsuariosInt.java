package Capa_Negocio.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Capa_Negocio.clasesDTO.UsuarioDTO;

public interface listarUsuariosInt extends Remote {
    public ArrayList<UsuarioDTO> listarUsuarios() throws RemoteException;
}
