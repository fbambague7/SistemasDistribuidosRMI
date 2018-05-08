/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Capa_Servicios;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;

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
    
    public static void RegistrarObjetoRemoto(Remote objetoRemoto, String dirIP, int numPuerto, String nombreObjeto) {
        String UrlRegistro = "rmi://" + dirIP + ":" + numPuerto + "/" + nombreObjeto;
        try {
            Naming.rebind(UrlRegistro, objetoRemoto);
            System.out.println("Se realizo el registro con la direccion: " + UrlRegistro);
            System.out.println("Esperando peticiones ...");
        } catch (RemoteException e) {
            System.out.println("Error en el registro del objeto remoto: " +  e);
            e.printStackTrace();
        } catch (MalformedURLException e) {
            System.out.println("Error url inválida");
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    
}
