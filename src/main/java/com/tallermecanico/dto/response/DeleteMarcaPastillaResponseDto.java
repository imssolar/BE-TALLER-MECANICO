package com.tallermecanico.dto.response;

public class DeleteMarcaPastillaResponseDto {

    private Integer id;
    private String marcaPastilla;
    private String message;

    // Constructors
    public DeleteMarcaPastillaResponseDto() {
    }

    public DeleteMarcaPastillaResponseDto(Integer id, String marcaPastilla, String message) {
        this.id = id;
        this.marcaPastilla = marcaPastilla;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarcaPastilla() {
        return marcaPastilla;
    }

    public void setMarcaPastilla(String marcaPastilla) {
        this.marcaPastilla = marcaPastilla;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
