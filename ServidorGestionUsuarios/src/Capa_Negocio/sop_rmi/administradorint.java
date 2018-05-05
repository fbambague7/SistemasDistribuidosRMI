package Capa_Negocio.sop_rmi;


import Capa_Negocio.clasesDTO.AdministradorDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface administradorint extends Remote {
    public boolean loginAdministrador(String loginAdmin, String passAdmin) throws RemoteException;
    public boolean modificarAdmin(AdministradorDTO clsAdministradorDTO)throws RemoteException;
}
