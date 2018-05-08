package Capa_Servicios;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public class UtilidadesRegistroC {
    public static Remote obtenerObjRemoto(int puerto, String dirIP, String nameObjReg){
        String URLRegistro;
        URLRegistro = "rmi://" + dirIP + ":" + puerto + "/" +nameObjReg;
        try {
            return Naming.lookup(URLRegistro);
        }
        catch (NotBoundException | MalformedURLException | RemoteException e){
            System.out.println("Excepcion en obtención del objeto remoto "+e);
            return null;
        }
    }
}
