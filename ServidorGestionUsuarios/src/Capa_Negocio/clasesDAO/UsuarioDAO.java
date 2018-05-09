/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.clasesDAO;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDTO.EnumArea;
import Capa_Negocio.clasesDTO.EnumRol;
import Capa_Negocio.clasesDTO.UsuarioDTO;
import Capa_Negocio.sop_rmi.estaUsuariosImpl;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author JULIAN
 */
public class UsuarioDAO {
    //private String ruta="../src/Capa_Acceso/usuarios/usuario_";
    private Archivo archivo;
    public UsuarioDAO() {
        archivo = new Archivo();
    }

    public boolean registrarUsuario(UsuarioDTO usuario){
        boolean registrado = false;
        String ruta="../src/Capa_Acceso/usuarios/usuario_";
        ruta+=usuario.getCodigo();
        ruta+=".txt";

        String datos= usuario.getCodigo()+"_"+usuario.getNombres()+"_"
                +usuario.getRol()+"_"+usuario.getClave()+"_"+usuario.getArea();
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

    public boolean modificarUsuario (UsuarioDTO usuario){
        boolean modificado = false;
        String ruta="../src/Capa_Acceso/usuarios/usuario_";
        ruta+=usuario.getCodigo();
        ruta+=".txt";

        String datos = usuario.getCodigo()+"_"+usuario.getNombres()+"_"
                +usuario.getRol()+"_"+usuario.getClave()+"_"+usuario.getArea();
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

    public UsuarioDTO consultarUsuario(String codigo){
        boolean existe;

        String clave;
        String area;
        String ruta="../src/Capa_Acceso/usuarios/usuario_";
        //String ruta="C:/Users/USUARIO/Documents/GitHub/SistemasDistribuidosRMI/ServidorGestionUsuarios/src/Capa_Acceso/usuarios/usuario_";
        ruta+=codigo;
        ruta+=".txt";

        String linea,nombres;
        EnumArea enumArea=null;
        EnumRol enumRol=null;
        File fichero = new File(ruta);
        existe = fichero.exists();
        UsuarioDTO userDTO = null;
        String[] row = null;
        if(existe){
            System.out.println("Usuario ha sido encontrado");
            
            try {
                archivo.abrirArchivo(ruta, false, false);
                String datos = archivo.leerArchivo();
                row = datos.split("_");
                nombres = row[1];
                switch (row[2]) {
                    case "administrativo":
                        enumRol = EnumRol.administrativo;
                        break;
                    case "docente":
                        enumRol = EnumRol.docente;
                        break;
                    case "estudiante":
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
                userDTO = new UsuarioDTO(nombres,codigo,clave,enumArea,enumRol);
                archivo.cerrarArchivo();
                
            } catch (IOException ex) {
                Logger.getLogger(estaUsuariosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            return null;
        }
        return userDTO;
        
    }

    public boolean eliminarUsuario(String codigo){
        boolean eliminado;
        String ruta="../src/Capa_Acceso/usuarios/usuario_";
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
    
    public UsuarioDTO consultarUsuario1(String codigo, String clave, String area){
        boolean existe;
        String ruta="../src/Capa_Acceso/usuarios/usuario_";
        //String ruta="C:/Users/USUARIO/Documents/GitHub/SistemasDistribuidosRMI/ServidorGestionUsuarios/src/Capa_Acceso/usuarios/usuario_";
        ruta+=codigo;
        ruta+=".txt";

        String linea,nombres;
        EnumArea enumArea=null;
        EnumRol enumRol=null;
        File fichero = new File(ruta);
        existe = fichero.exists();
        UsuarioDTO userDTO = null;
        String[] row = null;
        if(existe){
            System.out.println("Usuario ha sido encontrado");
            
            try {
                archivo.abrirArchivo(ruta, false, false);
                String datos = archivo.leerArchivo();
                row = datos.split("_");
                nombres = row[1];
                switch (row[2]) {
                    case "administrativo":
                        enumRol = EnumRol.administrativo;
                        break;
                    case "docente":
                        enumRol = EnumRol.docente;
                        break;
                    case "estudiante":
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
                userDTO = new UsuarioDTO(nombres,codigo,clave,enumArea,enumRol);
                archivo.cerrarArchivo();
                
            } catch (IOException ex) {
                Logger.getLogger(estaUsuariosImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }else{
            return null;
        }
        return userDTO;
        
    }
}
