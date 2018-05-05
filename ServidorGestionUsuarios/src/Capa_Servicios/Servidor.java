package Capa_Servicios;

import Capa_Negocio.sop_rmi.administradorGUImpl;
import Capa_Negocio.sop_rmi.gestionUsuariosImpl;

import java.rmi.RemoteException;

public class Servidor {

    public static void main(String[] args) throws RemoteException {
        String direccionIpRMIRegistry = args[0];
        int numPuertoRMIRegistry = Integer.parseInt(args[1]);

        gestionUsuariosImpl objRemoto = new gestionUsuariosImpl();
        administradorGUImpl objRemotoAdminGUI = new administradorGUImpl();

        try {
            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemoto,
                    direccionIpRMIRegistry,numPuertoRMIRegistry,"GestionUsuarios");

            UtilidadesRegistroS.arrancarNS(numPuertoRMIRegistry);
            UtilidadesRegistroS.RegistrarObjetoRemoto(objRemotoAdminGUI,
                    direccionIpRMIRegistry,numPuertoRMIRegistry,"LoginAdmin");

        }catch (Exception e){
            System.out.println("No fue posible arrancar el NS o registrar el objeto remoto " +e.getMessage());
        }


    }
}
