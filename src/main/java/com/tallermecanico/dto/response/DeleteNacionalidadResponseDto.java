package com.tallermecanico.dto.response;

public class DeleteNacionalidadResponseDto {

    private Integer id;
    private String nacionalidad;
    private String message;

    // Constructors
    public DeleteNacionalidadResponseDto() {
    }

    public DeleteNacionalidadResponseDto(Integer id, String nacionalidad, String message) {
        this.id = id;
        this.nacionalidad = nacionalidad;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
