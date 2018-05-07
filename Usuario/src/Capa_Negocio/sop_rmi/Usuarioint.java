/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.sop_rmi;

import Capa_Negocio.clasesDTO.UsuarioDTO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author USUARIO
 */
public interface UsuarioInt  extends Remote{
    public UsuarioDTO solicitarAcceso(String codigo, String clave, String Area) throws RemoteException;
    public void notificar(String rol, String nombre)throws RemoteException;
    
}