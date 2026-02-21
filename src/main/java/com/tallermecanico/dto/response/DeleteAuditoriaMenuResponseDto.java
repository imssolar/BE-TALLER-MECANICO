package com.tallermecanico.dto.response;

public class DeleteAuditoriaMenuResponseDto {

    private Long id;
    private String usuario;

    public DeleteAuditoriaMenuResponseDto() {
    }

    public DeleteAuditoriaMenuResponseDto(Long id, String usuario) {
        this.id = id;
        this.usuario = usuario;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
