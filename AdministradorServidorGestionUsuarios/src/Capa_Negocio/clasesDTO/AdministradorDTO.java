package Capa_Negocio.clasesDTO;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class AdministradorDTO implements Serializable{
    private String login;
    private String clave;

    public AdministradorDTO(String login, String clave) {
        this.login = login;
        this.clave = clave;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
