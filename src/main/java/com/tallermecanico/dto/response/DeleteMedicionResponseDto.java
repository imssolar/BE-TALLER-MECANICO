package com.tallermecanico.dto.response;

public class DeleteMedicionResponseDto {

    private Integer id;
    private String medicion;
    private String message;

    // Constructors
    public DeleteMedicionResponseDto() {
    }

    public DeleteMedicionResponseDto(Integer id, String medicion, String message) {
        this.id = id;
        this.medicion = medicion;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMedicion() {
        return medicion;
    }

    public void setMedicion(String medicion) {
        this.medicion = medicion;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
