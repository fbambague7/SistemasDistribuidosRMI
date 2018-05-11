/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.clasesDAO;

import Capa_Acceso.Archivo;
import Capa_Negocio.clasesDTO.UsuarioAccesoInstalacionesDTO;
import Capa_Negocio.clasesDTO.UsuarioDTO;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO {

    ArrayList<UsuarioAccesoInstalacionesDTO> usuariosAcceso;
    ArrayList<UsuarioAccesoInstalacionesDTO> usuariosNoAcceso;
    UsuarioAccesoInstalacionesDTO usuarioDTO;
    Archivo archivo = new Archivo();

    public UsuarioDAO() {
    }

    public boolean solicitar(String codigo, String area, boolean acceso) throws IOException {
        boolean dentro = false;
        String path = "";
        String datos = "";

        if (acceso == true) {
            path = "../src/Capa_Acceso/solicitudes/solicitudesDeAcceso.txt";
        } else {
            path = "../src/Capa_Acceso/solicitudes/solicitudesDeNoAcceso.txt";
        }

        archivo.abrirArchivo(path,true,true);
        String nuevo = "";
        try {
                Calendar calendario = new GregorianCalendar();

                    nuevo = codigo + "_" + area + "_" + calendario.get(Calendar.HOUR) + "_" + calendario.get(Calendar.DAY_OF_MONTH)
                            + " de " + getMes(calendario.get(Calendar.MONTH)) + " de " + calendario.get(Calendar.YEAR);

                    archivo.escribirArchivo(nuevo);
                    archivo.cerrarArchivo();

                dentro = true;

        } catch (Exception e) {
            System.out.println("ERROR! Se ha producido un error al crear el archivo " + e.getMessage());
        }
        return dentro;
    }

    public ArrayList<UsuarioAccesoInstalacionesDTO> UsuariosAcceso() {
        System.out.println("Nueva Instancia de Archivo()");
        usuariosAcceso = new ArrayList<>();
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        try {
            archivo.abrirArchivo("../src/Capa_Acceso/solicitudes/solicitudesDeAcceso.txt", false, false);
            while (archivo.puedeLeer()) {
                String datos = archivo.leerArchivo();
                String[] partes = datos.split("_");
                String codigo = partes[0];
                String area = partes[1];
                String hora = partes[2];
                String fecha = partes[3];
                //boolean acceso = Boolean.parseBoolean(partes[4]);
                //if (acceso == true) {
                usuarioDTO = new UsuarioAccesoInstalacionesDTO(codigo, area, hora, fecha);
                usuariosAcceso.add(usuarioDTO);
                //}

            }
            archivo.cerrarArchivo();
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR. El archivo no ha sido encontrado " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("ERROR! Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return usuariosAcceso;
    }

    public ArrayList<UsuarioAccesoInstalacionesDTO> UsuariosNoAcceso() {
        System.out.println("Nueva Instancia de Archivo()");
        usuariosNoAcceso = new ArrayList<>();
        File file = new File(".");
        System.out.println(file.getAbsolutePath());

        try {
            archivo.abrirArchivo("../src/Capa_Acceso/solicitudes/solicitudesDeNoAcceso.txt", false, false);
            while (archivo.puedeLeer()) {
                String datos = archivo.leerArchivo();
                String[] partes = datos.split("_");
                String codigo = partes[0];
                String area = partes[1];
                String hora = partes[2];
                String fecha = partes[3];
                //boolean acceso = Boolean.parseBoolean(partes[4]);
                //if (acceso == false) {
                usuarioDTO = new UsuarioAccesoInstalacionesDTO(codigo, area, hora, fecha);
                usuariosNoAcceso.add(usuarioDTO);
                //}

            }
            archivo.cerrarArchivo();
        } catch (FileNotFoundException ex) {
            System.out.println("ERROR. El archivo no ha sido encontrado " + ex.getMessage());

        } catch (IOException e) {
            System.out.println("ERROR! Se ha producido un error al leer el archivo " + e.getMessage());
        }
        return usuariosNoAcceso;
    }

    private String getMes(int mes) {
        String month = "";
        switch (mes) {
            case 1:
                month = "enero";
                break;
            case 2:
                month = "febrero";
                break;
            case 3:
                month = "marzo";
                break;
            case 4:
                month = "abril";
                break;
            case 5:
                month = "mayo";
                break;
            case 6:
                month = "junio";
                break;
            case 7:
                month = "julio";
                break;
            case 8:
                month = "agosto";
                break;
            case 9:
                month = "septiembre";
                break;
            case 10:
                month = "octubre";
                break;
            case 11:
                month = "noviembre";
                break;
            case 12:
                month = "diciembre";
                break;
        }
        return month;
    }

}
