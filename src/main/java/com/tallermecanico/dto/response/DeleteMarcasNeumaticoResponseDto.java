package com.tallermecanico.dto.response;

public class DeleteMarcasNeumaticoResponseDto {

    private Integer id;
    private String marca;
    private String message;

    // Constructors
    public DeleteMarcasNeumaticoResponseDto() {
    }

    public DeleteMarcasNeumaticoResponseDto(Integer id, String marca) {
        this.id = id;
        this.marca = marca;
        this.message = String.format("Marca '%s' eliminada correctamente", marca);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
