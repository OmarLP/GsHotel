package org.oleon.gshotel.modelo;

public class Cliente {
    private int idCliente;
    private String tipoDocuemnto;
    private String documento;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String telefono;
    private String correo;

    public Cliente() {
    }

    public Cliente(int idCliente, String tipoDocuemnto, String documento, String nombres, String apellidoPaterno, String apellidoMaterno, String telefono, String correo) {
        this.idCliente = idCliente;
        this.tipoDocuemnto = tipoDocuemnto;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidoPaterno = apellidoPaterno;
        this.apellidoMaterno = apellidoMaterno;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipoDocuemnto() {
        return tipoDocuemnto;
    }

    public void setTipoDocuemnto(String tipoDocuemnto) {
        this.tipoDocuemnto = tipoDocuemnto;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
}
