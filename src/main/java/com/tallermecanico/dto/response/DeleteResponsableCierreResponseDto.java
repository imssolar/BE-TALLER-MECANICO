package com.tallermecanico.dto.response;

public class DeleteResponsableCierreResponseDto {

    private Integer id;
    private String nombre;
    private String message;

    // Constructors
    public DeleteResponsableCierreResponseDto() {
    }

    public DeleteResponsableCierreResponseDto(Integer id, String nombre, String message) {
        this.id = id;
        this.nombre = nombre;
        this.message = message;
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
