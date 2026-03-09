package com.tallermecanico.dto.response;

public class DeleteHerramientaResponseDto {

    private Integer id;
    private String herramienta;
    private String message;

    // Constructors
    public DeleteHerramientaResponseDto() {
    }

    public DeleteHerramientaResponseDto(Integer id, String herramienta, String message) {
        this.id = id;
        this.herramienta = herramienta;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHerramienta() {
        return herramienta;
    }

    public void setHerramienta(String herramienta) {
        this.herramienta = herramienta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
