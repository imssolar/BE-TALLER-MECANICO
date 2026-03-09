package com.tallermecanico.dto.response;

public class DeleteSistemaResponseDto {

    private Integer id;
    private String nombre;
    private String message;

    // Constructors
    public DeleteSistemaResponseDto() {
    }

    public DeleteSistemaResponseDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
        this.message = String.format("Sistema '%s' eliminado correctamente", nombre);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
