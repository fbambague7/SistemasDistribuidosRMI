package Capa_Negocio.sop_rmi;

import Capa_Negocio.sop_rmi.CallbackInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements CallbackInt {
    public CallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void notificarIngresoUsuario() throws RemoteException {
        /*
           TODO: Implementar la notificacion al administrador que un usuario a ingresado.
           (msg: rol, nombres, apellidos)
         */

    }
}
