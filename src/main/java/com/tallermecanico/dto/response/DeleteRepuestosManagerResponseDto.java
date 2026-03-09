package com.tallermecanico.dto.response;

public class DeleteRepuestosManagerResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteRepuestosManagerResponseDto() {
    }

    public DeleteRepuestosManagerResponseDto(Integer id, String message) {
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
