package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDAO.UsuarioDAO;


import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Capa_Negocio.clasesDTO.UsuarioDTO;

public class gestionUsuariosImpl extends UnicastRemoteObject implements gestionUsuariosInt {

    private UsuarioDAO userDAO;
    private Archivo archivo;
    public gestionUsuariosImpl() throws RemoteException {
        super();
        userDAO = new UsuarioDAO();
    }

    @Override
    public boolean registrarUsuario(UsuarioDTO usuario) throws RemoteException {
        System.out.println("Registrando usuario...");
        return userDAO.registrarUsuario(usuario);
    }

    @Override
    public boolean modificarUsuario(UsuarioDTO usuario) throws RemoteException {
        System.out.println("Modificando usuario...");
        return userDAO.modificarUsuario(usuario);
    }

    @Override
    public UsuarioDTO consultarUsuario(String codigo, String clave, String area) throws RemoteException {
        System.out.println("Consultando usuario...");
        return userDAO.consultarUsuario(codigo,clave,area);
    }
    
    @Override
    public boolean eliminarUsuario(String codigo) throws RemoteException {
        System.out.println("Eliminando usuario...");
        return userDAO.eliminarUsuario(codigo);
    }
}
