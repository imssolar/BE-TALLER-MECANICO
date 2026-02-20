package com.tallermecanico.dto.response;

public class DeleteProveedorResponseDto {

    private Integer id;
    private String razonSocial;
    private String message;

    // Constructors
    public DeleteProveedorResponseDto() {
    }

    public DeleteProveedorResponseDto(Integer id, String razonSocial, String message) {
        this.id = id;
        this.razonSocial = razonSocial;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
