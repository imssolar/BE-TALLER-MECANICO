package com.tallermecanico.dto.response;

public class DeleteGravedadCarroceriaResponseDto {

    private Integer id;
    private String gravedad;
    private String message;

    // Constructors
    public DeleteGravedadCarroceriaResponseDto() {
    }

    public DeleteGravedadCarroceriaResponseDto(Integer id, String gravedad, String message) {
        this.id = id;
        this.gravedad = gravedad;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGravedad() {
        return gravedad;
    }

    public void setGravedad(String gravedad) {
        this.gravedad = gravedad;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
