/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.clasesDAO;

import Capa_Acceso.Archivo;
import javafx.scene.shape.Arc;
import Capa_Negocio.clasesDTO.AdministradorDTO;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author JULIAN
 */
public class AdministradorDAO {
    private String path = "../src/acceso/archivos/admin.txt";
    private Archivo archivo;

    public AdministradorDAO() {
        archivo = new Archivo();
    }

    public boolean iniciarSesion(String loginAdmin, String passAdmin){


        boolean acceso = false;

        try {
            archivo.abrirArchivo(path,false,false);
            if (archivo.puedeLeer()){
                String datos = archivo.leerArchivo();
                // datos: admin;root
                String[] partes = datos.split("_");
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

    public boolean modificarAdmin(AdministradorDTO objAdminGestionUsuarios){
        boolean modificado = false;

        try {
            archivo.abrirArchivo(path,true,false);
            archivo.escribirArchivo(objAdminGestionUsuarios.getLogin() + "_"
                    + objAdminGestionUsuarios.getClave());
            archivo.cerrarArchivo();
            modificado = true;
        } catch (IOException e) {
            System.out.println("ERROR. Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return modificado;
}
}
