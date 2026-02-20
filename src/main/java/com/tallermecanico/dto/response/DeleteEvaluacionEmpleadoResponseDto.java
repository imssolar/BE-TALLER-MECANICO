package com.tallermecanico.dto.response;

public class DeleteEvaluacionEmpleadoResponseDto {

    private Integer id;
    private Integer anio;
    private String message;

    // Constructors
    public DeleteEvaluacionEmpleadoResponseDto() {
    }

    public DeleteEvaluacionEmpleadoResponseDto(Integer id, Integer anio, String message) {
        this.id = id;
        this.anio = anio;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
