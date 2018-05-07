package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDAO.AdministradorDAO;
import Capa_Negocio.clasesDTO.AdministradorDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Capa_Negocio.sop_rmi.administradorCAint;

public class administradorCAImpl extends UnicastRemoteObject implements administradorCAint {

    private Archivo archivo;
    private AdministradorDAO administradorDAO;

    public administradorCAImpl() throws RemoteException {
        super();
        archivo = new Archivo();
        administradorDAO = new AdministradorDAO();
    }

    @Override
    public boolean loginAdministrador(AdministradorDTO AdministradorDTO) throws RemoteException {
        System.out.println("Invocando iniciarSesion()...");
        return AdministradorDAO.iniciarSesion(AdministradorDTO,archivo);
    }    

    @Override
    public boolean modificarAdmin(AdministradorDTO AdministradorDTO) throws RemoteException {
        System.out.println("Invocando modificarAdmin()...");
        return administradorDAO.modificarAdmin(AdministradorDTO,archivo);
    }

}
