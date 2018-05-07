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
    private String path = "../src/acceso/archivos/admin.txt";

    public AdministradorDAO() {
    }

    public boolean iniciarSesion(AdministradorDTO objAdminControlES, Archivo archivo){

        boolean acceso = false;

        try {
            archivo.abrirArchivo(path,false,false);
            if (archivo.puedeLeer()){
                String datos = archivo.leerArchivo();
                // datos: admin;root
                String[] partes = datos.split(";");
                String login = partes[0];
                String clave = partes[1];
                if(login.equals(objAdminControlES.getLogin()) &&
                        clave.equals(objAdminControlES.getClave())){
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

    public boolean modificarAdmin(AdministradorDTO objAdminControlES, Archivo archivo){
        boolean modificado = false;

        try {
            archivo.abrirArchivo(path,true,false);
            archivo.escribirArchivo(objAdminControlES.getLogin() + ";"
                    + objAdminControlES.getClave());
            archivo.cerrarArchivo();
            modificado = true;
        } catch (IOException e) {
            System.out.println("ERROR. Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return modificado;
    }

    public ArrayList<UsuarioAccesoInstalacionesDTO> listarUsuariosEnInstalaciones(){
        String directorio = "../src/acceso/archivos/instalaciones";
        ArrayList<UsuarioAccesoInstalacionesDTO> lista = new ArrayList<>();
        UsuarioAccesoInstalacionesDTO user = new UsuarioAccesoInstalacionesDTO();
        
        try{
            File f = new File(directorio);
            File[] ficheros = f.listFiles();
            for (int i=0;i<ficheros.length;i++){
                try {
                    FileReader archivo = new FileReader(ficheros[i].getName());
                    BufferedReader b = new BufferedReader(archivo);
                    user.setCodigo(b.readLine());
                    user.setHoraEntrada(b.readLine());
                    user.setFechaEntrada(b.readLine());
                    b.close();
                    lista.add(user);
                } catch (FileNotFoundException ex) {
                    System.out.println("ERROR. El archivo no ha sido encontrado " + ex.getMessage());
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR. Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return lista;
    }

    
    
}
