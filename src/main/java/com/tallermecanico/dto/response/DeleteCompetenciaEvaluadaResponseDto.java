package com.tallermecanico.dto.response;

public class DeleteCompetenciaEvaluadaResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteCompetenciaEvaluadaResponseDto() {
    }

    public DeleteCompetenciaEvaluadaResponseDto(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
