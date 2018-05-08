package Capa_Negocio.clasesDTO;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class UsuarioAccesoInstalacionesDTO implements Serializable{
    private String codigo;
    private String area;
    private String horaEntrada;
    private String fechaEntrada;
    private boolean acceso;

    public UsuarioAccesoInstalacionesDTO() {
    }
    
    public UsuarioAccesoInstalacionesDTO(String codigo, String area, String horaEntrada, String fechaEntrada) {
        this.codigo = codigo;
        this.area=area;
        this.horaEntrada = horaEntrada;
        this.fechaEntrada = fechaEntrada;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
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

    public boolean isAcceso() {
        return acceso;
    }

    public void setAcceso(boolean acceso) {
        this.acceso = acceso;
    }
       
}
