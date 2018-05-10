/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.clasesDAO;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDTO.AdministradorDTO;
import Capa_Negocio.clasesDTO.UsuarioAccesoInstalacionesDTO;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author USUARIO
 */
public class AdministradorDAO {
    private String path = "../src/Capa_Acceso/administrador/admin.txt";

    public AdministradorDAO() {
    }

    public boolean iniciarSesion(AdministradorDTO objAdminCA, Archivo archivo){

        boolean acceso = false;

        try {
            archivo.abrirArchivo(path,false,false);
            if (archivo.puedeLeer()){
                String datos = archivo.leerArchivo();
                String[] partes = datos.split("_");
                String login = partes[0];
                String clave = partes[1];
                if(login.equals(objAdminCA.getLogin()) &&
                        clave.equals(objAdminCA.getClave())){
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

    public boolean modificarAdmin(AdministradorDTO objAdminCA, Archivo archivo){
        boolean modificado = false;

        try {
            archivo.abrirArchivo(path,true,false);
            archivo.escribirArchivo(objAdminCA.getLogin() + "_"
                    + objAdminCA.getClave());
            archivo.cerrarArchivo();
            modificado = true;
        } catch (IOException e) {
            System.out.println("ERROR. Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return modificado;
    }


    
    
}
