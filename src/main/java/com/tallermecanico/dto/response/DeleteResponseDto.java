package com.tallermecanico.dto.response;

public class DeleteResponseDto {

    private Integer id;
    private String nombre;

    // Constructors
    public DeleteResponseDto() {
    }

    public DeleteResponseDto(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
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
}
