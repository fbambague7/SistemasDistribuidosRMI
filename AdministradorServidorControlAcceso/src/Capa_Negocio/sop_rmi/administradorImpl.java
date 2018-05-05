/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDTO.AdministradorDTO;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

/**
 *
 * @author USUARIO
 */
public class administradorImpl extends UnicastRemoteObject implements administradorCAint{

    private AdministradorDTO adminDTO;

    public administradorImpl() throws RemoteException{
        super();
        adminDTO= new AdministradorDTO();
    }
    
    
    
    @Override
    public boolean loginAdministrador(String loginAdmin, String passAdmin) throws RemoteException {
        System.out.println("Invocando a Login Administrador...");
        boolean bandera = false;
        
        if((adminDTO.getLogin().equals(loginAdmin))&&(adminDTO.getClave().equals(passAdmin))){
            bandera = true;
        }

        return bandera;       
    }

    @Override
    public boolean modificarAdmin(AdministradorDTO clsAdministradorDTO) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
