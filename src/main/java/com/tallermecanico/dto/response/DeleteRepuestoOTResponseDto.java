package com.tallermecanico.dto.response;

public class DeleteRepuestoOTResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteRepuestoOTResponseDto() {
    }

    public DeleteRepuestoOTResponseDto(Integer id, String message) {
        this.id = id;
        this.message = message;
    }

    // Getters
    public Integer getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }
}
