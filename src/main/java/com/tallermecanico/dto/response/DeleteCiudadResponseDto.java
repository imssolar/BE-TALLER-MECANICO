package com.tallermecanico.dto.response;

public class DeleteCiudadResponseDto {

    private Integer id;
    private String ciudad;
    private String message;

    // Constructors
    public DeleteCiudadResponseDto() {
    }

    public DeleteCiudadResponseDto(Integer id, String ciudad, String message) {
        this.id = id;
        this.ciudad = ciudad;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
