package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;
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
    Archivo archivo;

    public listarUsuariosImpl() throws RemoteException {
        super();
        archivo = new Archivo();
        usuariosAcceso = new ArrayList<>();
        usuariosNoAcceso = new ArrayList<>();
    }

    /*
    @Override
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuarios() throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    */

    @Override
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosAcceso() throws RemoteException {
        System.out.println("Invocando listarUsuariosAcceso...");
       
        System.out.println("Nueva Instancia de Archivo()");
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        try {
            archivo.abrirArchivo("../src/acceso/archivos/solicitudesDeAcceso.txt",false,false);
            while(archivo.puedeLeer()){
                String datos = archivo.leerArchivo();
                // datos: admin;root
                String[] partes = datos.split(";");
                String codigo = partes[0];
                String hora = partes[1];
                String fecha = partes[2];
                
                usuarioDTO = new UsuarioAccesoInstalacionesDTO(codigo, hora, fecha);
                usuariosAcceso.add(usuarioDTO);
                
            }
            archivo.cerrarArchivo();
        } catch (FileNotFoundException ex){
            System.out.println("ERROR. El archivo no ha sido encontrado " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("ERROR! Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return usuariosAcceso;
    }

    @Override
    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosNoAcceso() throws RemoteException {
        System.out.println("Invocando listarUsuariosNoAcceso...");
       
        System.out.println("Nueva Instancia de Archivo()");
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        try {
            archivo.abrirArchivo("../src/acceso/archivos/solicitudesDeAcceso.txt",false,false);
            while(archivo.puedeLeer()){
                String datos = archivo.leerArchivo();
                // datos: admin;root
                String[] partes = datos.split(";");
                String codigo = partes[0];
                String hora = partes[1];
                String fecha = partes[2];
                
                usuarioDTO = new UsuarioAccesoInstalacionesDTO(codigo, hora, fecha);
                usuariosNoAcceso.add(usuarioDTO);
                
            }
            archivo.cerrarArchivo();
        } catch (FileNotFoundException ex){
            System.out.println("ERROR. El archivo no ha sido encontrado " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("ERROR! Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return usuariosNoAcceso;
    }

    
}
