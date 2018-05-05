/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Servicios;

import java.rmi.Naming;
import java.rmi.Remote;

/**
 *
 * @author USUARIO
 */
public class UtilidadesRegistroC {
    public static Remote ObtenerObjRemoto(int puerto, String dirIP, String nameObjReg){
        String URLRegistro;
        URLRegistro  = "rmi://" + dirIP + ":" + puerto + "/"+nameObjReg;
        try
        {
            return Naming.lookup(URLRegistro);
        }
        catch (Exception e)
        {
            System.out.println("Excepcion en obtencion del objeto remoto"+ e);
            return null;
        }
    }
    
}
