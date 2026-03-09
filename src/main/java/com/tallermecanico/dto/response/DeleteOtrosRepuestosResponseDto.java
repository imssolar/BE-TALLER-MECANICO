package com.tallermecanico.dto.response;

public class DeleteOtrosRepuestosResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteOtrosRepuestosResponseDto() {
    }

    public DeleteOtrosRepuestosResponseDto(Integer id, String message) {
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
