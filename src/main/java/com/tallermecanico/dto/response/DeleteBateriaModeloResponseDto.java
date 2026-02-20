package com.tallermecanico.dto.response;

public class DeleteBateriaModeloResponseDto {

    private Integer id;
    private String modelo;
    private String message;

    // Constructors
    public DeleteBateriaModeloResponseDto() {
    }

    public DeleteBateriaModeloResponseDto(Integer id, String modelo, String message) {
        this.id = id;
        this.modelo = modelo;
        this.message = message;
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
