package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateAuditoriaMenuDto {

    @NotBlank(message = "El usuario es requerido")
    @Size(max = 50, message = "El usuario no puede exceder 50 caracteres")
    private String usuario;

    @Size(max = 70, message = "El menú no puede exceder 70 caracteres")
    private String menu;

    @Size(max = 20, message = "La opción no puede exceder 20 caracteres")
    private String opcion;

    @Size(max = 15, message = "El terminal no puede exceder 15 caracteres")
    private String terminal;

    @Size(max = 45, message = "La IP no puede exceder 45 caracteres")
    private String ip;

    public CreateAuditoriaMenuDto() {
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getOpcion() {
        return opcion;
    }

    public void setOpcion(String opcion) {
        this.opcion = opcion;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }
}
