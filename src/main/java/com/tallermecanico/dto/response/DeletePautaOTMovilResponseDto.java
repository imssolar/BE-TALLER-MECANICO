package com.tallermecanico.dto.response;

public class DeletePautaOTMovilResponseDto {

    private Integer id;
    private String pauta;
    private String message;

    // Constructors
    public DeletePautaOTMovilResponseDto() {
    }

    public DeletePautaOTMovilResponseDto(Integer id, String pauta, String message) {
        this.id = id;
        this.pauta = pauta;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
