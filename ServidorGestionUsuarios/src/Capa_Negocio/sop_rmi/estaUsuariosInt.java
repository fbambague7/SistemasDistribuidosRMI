package Capa_Negocio.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import Capa_Negocio.clasesDTO.UsuarioDTO;

public interface estaUsuariosInt extends Remote {
    public UsuarioDTO esUsuarioRegistrado(String codigo) throws RemoteException;
} 
