package com.tallermecanico.dto.response;

public class DeleteInfraHerraPatronResponseDto {

    private String idInfra;
    private String descripcion;
    private String message;

    // Constructors
    public DeleteInfraHerraPatronResponseDto() {
    }

    public DeleteInfraHerraPatronResponseDto(String idInfra, String descripcion, String message) {
        this.idInfra = idInfra;
        this.descripcion = descripcion;
        this.message = message;
    }

    // Getters and Setters
    public String getIdInfra() {
        return idInfra;
    }

    public void setIdInfra(String idInfra) {
        this.idInfra = idInfra;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
