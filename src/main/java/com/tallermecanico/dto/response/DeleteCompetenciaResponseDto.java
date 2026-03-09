package com.tallermecanico.dto.response;

public class DeleteCompetenciaResponseDto {

    private Integer id;
    private String competencia;
    private String message;

    // Constructors
    public DeleteCompetenciaResponseDto() {
    }

    public DeleteCompetenciaResponseDto(Integer id, String competencia, String message) {
        this.id = id;
        this.competencia = competencia;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
