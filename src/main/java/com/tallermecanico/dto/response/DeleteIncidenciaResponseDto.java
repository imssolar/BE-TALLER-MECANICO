package com.tallermecanico.dto.response;

public class DeleteIncidenciaResponseDto {

    private Integer id;
    private String incidencia;
    private String message;

    // Constructors
    public DeleteIncidenciaResponseDto() {
    }

    public DeleteIncidenciaResponseDto(Integer id, String incidencia, String message) {
        this.id = id;
        this.incidencia = incidencia;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIncidencia() {
        return incidencia;
    }

    public void setIncidencia(String incidencia) {
        this.incidencia = incidencia;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
