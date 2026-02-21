package com.tallermecanico.dto.response;

public class DeleteCostoSMResponseDto {

    private Integer id;
    private String pautaSm;
    private String message;

    // Constructors
    public DeleteCostoSMResponseDto() {
    }

    public DeleteCostoSMResponseDto(Integer id, String pautaSm, String message) {
        this.id = id;
        this.pautaSm = pautaSm;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPautaSm() {
        return pautaSm;
    }

    public void setPautaSm(String pautaSm) {
        this.pautaSm = pautaSm;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
