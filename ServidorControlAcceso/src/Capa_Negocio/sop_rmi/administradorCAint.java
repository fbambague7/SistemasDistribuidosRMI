package Capa_Negocio.sop_rmi;


import Capa_Negocio.clasesDTO.AdministradorDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface administradorCAint extends Remote {
    public boolean loginAdministrador(AdministradorDTO AdministradorDTO) throws RemoteException;
    public boolean modificarAdmin(AdministradorDTO AdministradorDTO)throws RemoteException;
}
