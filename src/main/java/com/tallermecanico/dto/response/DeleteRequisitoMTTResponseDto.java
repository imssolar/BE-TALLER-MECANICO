package com.tallermecanico.dto.response;

public class DeleteRequisitoMTTResponseDto {

    private Integer id;
    private String requisito;
    private String message;

    // Constructors
    public DeleteRequisitoMTTResponseDto() {
    }

    public DeleteRequisitoMTTResponseDto(Integer id, String requisito, String message) {
        this.id = id;
        this.requisito = requisito;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
