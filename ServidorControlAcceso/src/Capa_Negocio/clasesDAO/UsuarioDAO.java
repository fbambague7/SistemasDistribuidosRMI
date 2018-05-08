/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Negocio.clasesDAO;

import Capa_Acceso.Archivo;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 *
 * @author USUARIO
 */
public class UsuarioDAO {
    Archivo archivo = new Archivo();
    public UsuarioDAO() {
    }
    
    public boolean solicitar(String codigo, String area, boolean acceso){
        boolean dentro = false;
        String path="";
        
        if(acceso=true)
            path = "../src/acceso/archivos/solicitudes/solicitudesDeAcceso.txt";
        else
            path = "../src/acceso/archivos/solicitudes/solicitudesDeNoAcceso.txt";
        try {
            File archivo = new File(path);
            if(!archivo.exists()){
                Calendar calendario = new GregorianCalendar();            
                BufferedWriter bw;
                try {
                    bw = new BufferedWriter(new FileWriter(archivo));
                    bw.write(codigo + "\n" +area + "\n" + calendario.get(Calendar.HOUR) + "\n" + calendario.get(Calendar.DAY_OF_MONTH)
                    + " de " + getMes(calendario.get(Calendar.MONTH)) + " de " + calendario.get(Calendar.YEAR)+ "\n" + acceso);
                    bw.close();
                } catch (IOException ex) {
                    System.out.println("ERROR! Se ha producido un error al crear el archivo " + ex.getMessage());
                }
                dentro = true;
            }  
        } catch (Exception e) {
            System.out.println("ERROR! Se ha producido un error al crear el archivo " + e.getMessage());
        }
        return dentro;
    }
        
    public boolean salirDeLasInstalaciones(String codigo){
        String path = "../src/acceso/archivos/instalaciones/usuario_" + codigo + ".txt";
        boolean dentro = false;
        try {
            File fichero = new File(path);
            fichero.delete();
            dentro = true;
        } catch (Exception e) {
            dentro = false;
        }
        return dentro;
    }
    
    public boolean esUsuarioRegistrado(String codigo){
        String path = "../src/acceso/archivos/instalaciones/usuario_" + codigo + ".txt";
        File archivo = new File(path);
        if(archivo.exists()) 
            return true;
        else 
            return false;
    }
    
    private String getMes(int mes){
        String month = "";
        switch(mes){
            case 1: month = "enero"; break;
            case 2: month = "febrero"; break;
            case 3: month = "marzo"; break;
            case 4: month = "abril"; break;
            case 5: month = "mayo"; break;
            case 6: month = "junio"; break;
            case 7: month = "julio"; break;
            case 8: month = "agosto"; break;
            case 9: month = "septiembre"; break;
            case 10: month = "octubre"; break;
            case 11: month = "noviembre"; break;
            case 12: month = "diciembre"; break;
        }
        return month;
    }
    
}
