package com.tallermecanico.dto.response;

public class DeleteBateriaMotivoCambioResponseDto {

    private Integer id;
    private String motivoCambio;
    private String message;

    // Constructors
    public DeleteBateriaMotivoCambioResponseDto() {
    }

    public DeleteBateriaMotivoCambioResponseDto(Integer id, String motivoCambio, String message) {
        this.id = id;
        this.motivoCambio = motivoCambio;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivoCambio() {
        return motivoCambio;
    }

    public void setMotivoCambio(String motivoCambio) {
        this.motivoCambio = motivoCambio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
