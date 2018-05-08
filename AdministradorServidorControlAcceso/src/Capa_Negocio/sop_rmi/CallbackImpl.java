package Capa_Negocio.sop_rmi;

import Capa_Negocio.sop_rmi.CallbackInt;
import Capa_Presentacion.JFrameAdminCAListar;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CallbackImpl extends UnicastRemoteObject implements CallbackInt {
    
    private JFrameAdminCAListar gui;
    public CallbackImpl(JFrameAdminCAListar gui) throws RemoteException {
        super();
        this.gui=gui;
    }

    @Override
    public void notificarIngresoUsuario(String rol, String nombres) throws RemoteException {
       gui.notificar("el usuario "+nombres+" y rol " + rol + " ha iniciado sesión");
    }
}
