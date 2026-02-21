package com.tallermecanico.dto.response;

public class DeleteRegistroMensualResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteRegistroMensualResponseDto() {
    }

    public DeleteRegistroMensualResponseDto(Integer id, String message) {
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
