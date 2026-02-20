package com.tallermecanico.dto.response;

public class DeleteMovilResponseDto {

    private Integer id;
    private String patente;
    private String message;

    // Constructors
    public DeleteMovilResponseDto() {
    }

    public DeleteMovilResponseDto(Integer id, String patente, String message) {
        this.id = id;
        this.patente = patente;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
