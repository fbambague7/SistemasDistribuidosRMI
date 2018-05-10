package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDAO.UsuarioDAO;
import Capa_Negocio.clasesDTO.UsuarioAccesoInstalacionesDTO;
import Capa_Negocio.sop_rmi.listarUsuariosInt;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class listarUsuariosImpl extends UnicastRemoteObject implements listarUsuariosInt {
    
    ArrayList<UsuarioAccesoInstalacionesDTO> usuariosAcceso;
    ArrayList<UsuarioAccesoInstalacionesDTO> usuariosNoAcceso;
    UsuarioAccesoInstalacionesDTO usuarioDTO;
    UsuarioDAO usuarioDAO;
    Archivo archivo;

    public listarUsuariosImpl() throws RemoteException {
        super();
        archivo = new Archivo();
        usuarioDAO = new UsuarioDAO();
    }

    @Override
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosAcceso() throws RemoteException {
        System.out.println("Invocando listarUsuariosAcceso...");
        usuariosAcceso = new ArrayList<>();
        usuariosAcceso=usuarioDAO.UsuariosAcceso();
        return usuariosAcceso;
    }

    @Override
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosNoAcceso() throws RemoteException {
        System.out.println("Invocando listarUsuariosNoAcceso...");
        usuariosNoAcceso = new ArrayList<>();
        usuariosNoAcceso = usuarioDAO.UsuariosNoAcceso();
        return usuariosNoAcceso;
    }
    
}
