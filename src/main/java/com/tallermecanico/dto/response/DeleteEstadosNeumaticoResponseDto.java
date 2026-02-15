package com.tallermecanico.dto.response;

public class DeleteEstadosNeumaticoResponseDto {

    private Integer id;
    private String estado;
    private String message;

    // Constructors
    public DeleteEstadosNeumaticoResponseDto() {
    }

    public DeleteEstadosNeumaticoResponseDto(Integer id, String estado) {
        this.id = id;
        this.estado = estado;
        this.message = String.format("Estado '%s' eliminado correctamente", estado);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
