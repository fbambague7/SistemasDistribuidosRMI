package Capa_Negocio.sop_rmi;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CallbackInt extends Remote {
    public void notificarIngresoUsuario()  throws RemoteException;
}
