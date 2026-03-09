package com.tallermecanico.dto.response;

public class DeleteItemMantencionNResponseDto {

    private Integer id;
    private String descripcion;
    private String message;

    // Constructors
    public DeleteItemMantencionNResponseDto() {
    }

    public DeleteItemMantencionNResponseDto(Integer id, String descripcion, String message) {
        this.id = id;
        this.descripcion = descripcion;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
