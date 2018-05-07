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

public class estaUsuariosImpl extends UnicastRemoteObject implements estaUsuariosInt {
    
    FileReader fr;
    BufferedReader br;
    
    public estaUsuariosImpl() throws RemoteException {
        super();
    }

    @Override
    public UsuarioDTO esUsuarioRegistrado(String codigo) throws RemoteException {
        boolean existe;
        String ruta = "../src/acceso/usuarios/usuario_"+codigo+".txt"; 
        String linea,nombres,clave;
        EnumArea enumArea=null;
        EnumRol enumRol=null;
        File fichero = new File(ruta);
        existe = fichero.exists();
        UsuarioDTO userDTO = null;
        String[] row = null;
        if(existe){
            System.out.println("Usuario ha sido encontrado");
            
            try {
                while(br.ready()){
                    linea = br.readLine();
                    row = linea.split("_");
                }
            } catch (IOException ex) {
                Logger.getLogger(estaUsuariosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                    br.close();
            } catch (IOException ex) {
                Logger.getLogger(estaUsuariosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            nombres = row[1];
            switch (row[2]) {
                case "norte":
                    enumRol = EnumRol.administrativo;
                    break;
                case "sur":
                    enumRol = EnumRol.docente;
                    break;
                case "este":
                    enumRol = EnumRol.estudiante;
                    break;
            }
            clave = row[3];
            switch (row[4]) {
                case "norte":
                    enumArea = EnumArea.norte;
                    break;
                case "sur":
                    enumArea = EnumArea.sur;
                    break;
                case "este":
                    enumArea = EnumArea.este;
                    break;
                case "oeste":
                    enumArea = EnumArea.oeste;
                    break;
            }
            userDTO = new UsuarioDTO(codigo,nombres,clave,enumArea,enumRol);
        }
            try {
                fr = new FileReader(ruta);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(estaUsuariosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        return userDTO;
    }
}

