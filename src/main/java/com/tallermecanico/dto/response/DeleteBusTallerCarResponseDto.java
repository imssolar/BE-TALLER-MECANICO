package com.tallermecanico.dto.response;

public class DeleteBusTallerCarResponseDto {

    private Integer idBus;
    private String message;

    // Constructors
    public DeleteBusTallerCarResponseDto() {
    }

    public DeleteBusTallerCarResponseDto(Integer idBus) {
        this.idBus = idBus;
        this.message = String.format("BusTallerCar con ID %d eliminado correctamente", idBus);
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
