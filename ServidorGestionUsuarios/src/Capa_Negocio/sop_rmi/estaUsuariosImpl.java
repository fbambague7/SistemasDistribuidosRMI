package Capa_Negocio.sop_rmi;



import Capa_Negocio.clasesDTO.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import Capa_Negocio.clasesDTO.UsuarioDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDAO.UsuarioDAO;

public class estaUsuariosImpl extends UnicastRemoteObject implements estaUsuariosInt {
    
    
    private Archivo archivo;
    private UsuarioDAO userDAO;
    
    public estaUsuariosImpl() throws RemoteException {
        super();
        userDAO = new UsuarioDAO();
    }

    @Override
    public UsuarioDTO obtenerUsuarioRegistrado(String codigo,String clave, String area) throws RemoteException {
        System.out.println("Obteniendo el usuario...");
        return userDAO.consultarUsuario(codigo, clave, area);
    }
}