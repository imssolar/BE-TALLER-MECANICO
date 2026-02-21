package com.tallermecanico.dto.response;

public class DeleteInfraestructurasPlanResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteInfraestructurasPlanResponseDto() {
    }

    public DeleteInfraestructurasPlanResponseDto(Integer id, String message) {
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
