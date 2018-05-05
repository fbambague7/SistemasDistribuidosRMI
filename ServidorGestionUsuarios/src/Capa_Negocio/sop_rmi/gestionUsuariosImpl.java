package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;


import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import Capa_Negocio.clasesDTO.UsuarioDTO;

public class gestionUsuariosImpl extends UnicastRemoteObject implements gestionUsuariosInt {


    private Archivo archivo;
    public gestionUsuariosImpl() throws RemoteException {
        super();
        archivo = new Archivo();
    }

    @Override
    public boolean registrarUsuario(UsuarioDTO objUsuarios) throws RemoteException {
        System.out.println("Invocando registrarUsuario()...");
        boolean registrado = false;


        String path="../src/acceso/usuarios/usuario_";
        path+=objUsuarios.getCodigo();
        path+=".txt";

        String datos= objUsuarios.getCodigo()+";"+objUsuarios.getNombres()+";"
                +objUsuarios.getArea()+";"+objUsuarios.getRol();
        try {
            archivo.abrirArchivo(path,true,true);
            archivo.escribirArchivo(datos);
            archivo.cerrarArchivo();
            registrado = true;
        } catch (FileNotFoundException e){
            System.out.println("ERROR. El archivo no ha sido encontrado " + e.getMessage());

        } catch (IOException e) {
            System.out.println("ERROR. Se ha producido un error al escribir el archivo "+e.getMessage());
        }

        if (registrado)
            System.out.println("Usuario registrado correctamente");
        else
            System.out.println("Usuario no se pudo registrar");
        return registrado;


    }

    @Override
    public boolean modificarUsuario(UsuarioDTO usuario) throws RemoteException {
        System.out.println("Invocando modificarUsuario()...");
        boolean modificado = false;

        String path="../src/acceso/usuarios/usuario_";
        path+=usuario.getCodigo();
        path+=".txt";
        String datos = usuario.getCodigo()+";"+usuario.getNombres()+";"
                +usuario+";"+usuario.getRol();
        try {
            archivo.abrirArchivo(path,true,false);

            archivo.escribirArchivo(datos);

            archivo.cerrarArchivo();
            modificado = true;
        } catch (FileNotFoundException e){
            System.out.println("ERROR. El archivo no ha sido encontrado " + e.getMessage());
        } catch (IOException e) {
            System.out.println("ERROR. Se ha producido un error al leer o escribir el archivo" + e.getMessage());
        }
        return modificado;
    }

    @Override
    public UsuarioDTO consultarUsuario(String codigo, String clave, String area) throws RemoteException {
        return null;
    }
    
    @Override
    public boolean eliminarUsuario(String codigo) throws RemoteException {
        System.out.println("Invocando eliminarUsuario()...");
        boolean eliminado;

        String path="../src/acceso/usuarios/usuario_";
        path+= codigo;
        path+=".txt";
        File fichero = new File(path);
        eliminado = fichero.delete();
        if(eliminado)
            System.out.println("Usuario eliminado correctamente");
        else
            System.out.println("Usuario no se pudo eliminar");
        return eliminado;
    }
}
