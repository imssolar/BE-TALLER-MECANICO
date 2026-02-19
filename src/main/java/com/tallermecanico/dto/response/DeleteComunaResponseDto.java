package com.tallermecanico.dto.response;

public class DeleteComunaResponseDto {

    private Integer id;
    private String comuna;
    private String message;

    // Constructors
    public DeleteComunaResponseDto() {
    }

    public DeleteComunaResponseDto(Integer id, String comuna, String message) {
        this.id = id;
        this.comuna = comuna;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getComuna() {
        return comuna;
    }

    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
