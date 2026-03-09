package com.tallermecanico.dto.response;

public class DeleteGlosaResponseDto {

    private Integer id;
    private String glosa;
    private String message;

    // Constructors
    public DeleteGlosaResponseDto() {
    }

    public DeleteGlosaResponseDto(Integer id, String glosa) {
        this.id = id;
        this.glosa = glosa;
        this.message = String.format("Glosa '%s' eliminada correctamente", glosa);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGlosa() {
        return glosa;
    }

    public void setGlosa(String glosa) {
        this.glosa = glosa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
