package com.tallermecanico.dto.response;

public class DeleteLiquidoResponseDto {

    private Integer id;
    private String liquido;
    private String message;

    // Constructors
    public DeleteLiquidoResponseDto() {
    }

    public DeleteLiquidoResponseDto(Integer id, String liquido, String message) {
        this.id = id;
        this.liquido = liquido;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLiquido() {
        return liquido;
    }

    public void setLiquido(String liquido) {
        this.liquido = liquido;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
