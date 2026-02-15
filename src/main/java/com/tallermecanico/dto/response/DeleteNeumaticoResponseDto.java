package com.tallermecanico.dto.response;

public class DeleteNeumaticoResponseDto {

    private Integer id;
    private String message;

    // Constructors
    public DeleteNeumaticoResponseDto() {
    }

    public DeleteNeumaticoResponseDto(Integer id) {
        this.id = id;
        this.message = String.format("Neumático con ID %d eliminado correctamente", id);
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
