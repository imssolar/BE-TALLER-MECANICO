package com.tallermecanico.dto.response;

public class DeleteModelosNeumaticoResponseDto {

    private Integer id;
    private String modelo;
    private String message;

    // Constructors
    public DeleteModelosNeumaticoResponseDto() {
    }

    public DeleteModelosNeumaticoResponseDto(Integer id, String modelo) {
        this.id = id;
        this.modelo = modelo;
        this.message = String.format("Modelo '%s' eliminado correctamente", modelo);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
