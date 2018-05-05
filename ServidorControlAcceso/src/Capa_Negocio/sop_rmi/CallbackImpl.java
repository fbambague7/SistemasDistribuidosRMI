package Capa_Negocio.sop_rmi;

import Capa_Negocio.sop_rmi.CallbackInt;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements CallbackInt {
    public CallbackImpl() throws RemoteException {
        super();
    }

    @Override
    public void notificarIngresoUsuario(String rol, String nombres) throws RemoteException {
        System.out.println("Rol: "+rol+" Nombres: "+nombres);
    }
}
