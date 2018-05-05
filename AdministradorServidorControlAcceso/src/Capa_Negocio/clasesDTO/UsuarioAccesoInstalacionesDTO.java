package Capa_Negocio.clasesDTO;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class UsuarioAccesoInstalacionesDTO implements Serializable{
    private String codigo;
    private String horaEntrada;
    private String fechaEntrada;
    
    public UsuarioAccesoInstalacionesDTO(String codigo, String horaEntrada, String fechaEntrada) {
        this.codigo = codigo;
        this.horaEntrada = horaEntrada;
        this.fechaEntrada = fechaEntrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}

