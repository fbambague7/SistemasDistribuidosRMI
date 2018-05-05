package Capa_Negocio.clasesDTO;

import java.io.Serializable;

/**
 *
 * @author Usuario
 */
public class UsuarioDTO implements Serializable{
    private String nombres;
   private String codigo;
   private EnumArea area;
   private EnumRol rol;

    public UsuarioDTO(String nombres, String codigo, EnumArea area, EnumRol rol) {
        this.nombres = nombres;
        this.codigo = codigo;
        this.area = area;
        this.rol = rol;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public EnumArea getArea() {
        return area;
    }

    public void setArea(EnumArea area) {
        this.area = area;
    }

    public EnumRol getRol() {
        return rol;
    }

    public void setRol(EnumRol rol) {
        this.rol = rol;
    }
    
}
