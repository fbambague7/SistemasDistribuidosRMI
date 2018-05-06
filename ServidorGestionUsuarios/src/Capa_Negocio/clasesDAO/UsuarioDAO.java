/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.clasesDAO;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDTO.UsuarioDTO;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author JULIAN
 */
public class UsuarioDAO {
    private String ruta="../src/acceso/usuarios/usuario_";
    private Archivo archivo;
    public UsuarioDAO() {
        archivo = new Archivo();
    }

    public boolean registrarUsuario(UsuarioDTO objUsuarios){
        boolean registrado = false;

        ruta+=objUsuarios.getCodigo();
        ruta+=".txt";

        String datos= objUsuarios.getCodigo()+";"+objUsuarios.getNombres()+";"
                +objUsuarios.getArea()+";"+objUsuarios.getRol();
        try {
            archivo.abrirArchivo(ruta,true,true);
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

    public boolean modificarUsuario (UsuarioDTO objUsuarios){
        boolean modificado = false;

        ruta+=objUsuarios.getCodigo();
        ruta+=".txt";

        String datos = objUsuarios.getCodigo()+";"+objUsuarios.getNombres()+";"
                +objUsuarios.getArea()+";"+objUsuarios.getRol();
        try {
            archivo.abrirArchivo(ruta,true,false);
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

    public boolean consultarUsuario(String codigo, String clave, String area){
        boolean existe;

        ruta+=codigo;
        ruta+=".txt";

        File fichero = new File(ruta);
        existe = fichero.exists();
        if(existe)
            System.out.println("Usuario ha sido encontrado");
        else
            System.out.println("Ususario no ha sido encontrado");
        return existe;
    }

    public boolean eliminarUsuario(String codigo){
        boolean eliminado;

        ruta+= codigo;
        ruta+=".txt";

        File fichero = new File(ruta);
        eliminado = fichero.delete();
        if(eliminado)
            System.out.println("Usuario eliminado correctamente");
        else
            System.out.println("Usuario no se pudo eliminar");
        return eliminado;
}
}
