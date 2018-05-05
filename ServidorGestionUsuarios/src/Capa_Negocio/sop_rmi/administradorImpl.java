package Capa_Negocio.sop_rmi;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDTO.AdministradorDTO;


import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class administradorImpl extends UnicastRemoteObject implements administradorint {

    private Archivo archivo;

    public administradorImpl() throws RemoteException {
        super();
        archivo = new Archivo();
    }

    @Override
    public boolean loginAdministrador(String loginAdmin, String passAdmin) throws RemoteException {
        System.out.println("Invocando iniciarSesion()...");
        boolean acceso = false;


        System.out.println("Nueva Instancia de Archivo()");
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        try {
            archivo.abrirArchivo("../src/acceso/archivos/admin.txt",false,false);
            if (archivo.puedeLeer()){
                String datos = archivo.leerArchivo();
                // datos: admin;root
                String[] partes = datos.split(";");
                String login = partes[0];
                String clave = partes[1];
                if(login.equals(loginAdmin) &&
                        clave.equals(passAdmin)){
                    acceso = true;
                }
            }
            archivo.cerrarArchivo();
        } catch (FileNotFoundException ex){
            System.out.println("ERROR. El archivo no ha sido encontrado " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("ERROR! Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return acceso;
    }

    @Override
    public boolean modificarAdmin(AdministradorDTO clsAdministradorDTO) throws RemoteException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
