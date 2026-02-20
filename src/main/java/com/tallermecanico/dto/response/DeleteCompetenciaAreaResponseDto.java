package com.tallermecanico.dto.response;

public class DeleteCompetenciaAreaResponseDto {

    private Integer id;
    private String area;
    private String message;

    // Constructors
    public DeleteCompetenciaAreaResponseDto() {
    }

    public DeleteCompetenciaAreaResponseDto(Integer id, String area, String message) {
        this.id = id;
        this.area = area;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
