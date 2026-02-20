package com.tallermecanico.dto.response;

public class DeleteRelatorResponseDto {

    private Integer id;
    private String relator;
    private String message;

    // Constructors
    public DeleteRelatorResponseDto() {
    }

    public DeleteRelatorResponseDto(Integer id, String relator, String message) {
        this.id = id;
        this.relator = relator;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRelator() {
        return relator;
    }

    public void setRelator(String relator) {
        this.relator = relator;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
