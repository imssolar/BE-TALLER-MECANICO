package com.tallermecanico.dto.response;

public class DeleteCapacitacionResponseDto {

    private Integer id;
    private String tema;
    private String message;

    // Constructors
    public DeleteCapacitacionResponseDto() {
    }

    public DeleteCapacitacionResponseDto(Integer id, String tema, String message) {
        this.id = id;
        this.tema = tema;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
