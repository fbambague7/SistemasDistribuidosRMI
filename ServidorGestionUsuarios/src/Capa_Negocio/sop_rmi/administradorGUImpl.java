package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDAO.AdministradorDAO;
import Capa_Negocio.clasesDTO.AdministradorDTO;


import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class administradorGUImpl extends UnicastRemoteObject implements administradorGUint {

    private Archivo archivo;
    private AdministradorDAO adminDAO;

    public administradorGUImpl() throws RemoteException {
        super();
        adminDAO = new AdministradorDAO();
    }

    @Override
    public boolean loginAdministrador(String loginAdmin, String passAdmin) throws RemoteException {
        System.out.println("Iniciando Sesión...");
        return adminDAO.iniciarSesion(loginAdmin, passAdmin);
    }

    @Override
    public boolean modificarAdmin(AdministradorDTO adminOBJ) throws RemoteException {
        System.out.println("Modificando datos del administrador...");
        return adminDAO.modificarAdmin(adminOBJ);
    }


}

