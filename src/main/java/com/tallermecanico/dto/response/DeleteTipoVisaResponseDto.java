package com.tallermecanico.dto.response;

public class DeleteTipoVisaResponseDto {

    private Integer id;
    private String tipoVisa;
    private String message;

    // Constructors
    public DeleteTipoVisaResponseDto() {
    }

    public DeleteTipoVisaResponseDto(Integer id, String tipoVisa, String message) {
        this.id = id;
        this.tipoVisa = tipoVisa;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoVisa() {
        return tipoVisa;
    }

    public void setTipoVisa(String tipoVisa) {
        this.tipoVisa = tipoVisa;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
