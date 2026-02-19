package com.tallermecanico.dto.response;

public class DeleteMotivoCambioResponseDto {

    private Integer id;
    private String motivo;
    private String message;

    // Constructors
    public DeleteMotivoCambioResponseDto() {
    }

    public DeleteMotivoCambioResponseDto(Integer id, String motivo, String message) {
        this.id = id;
        this.motivo = motivo;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
