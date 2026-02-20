package com.tallermecanico.dto.response;

public class DeleteMedicionProductoResponseDto {

    private Integer id;
    private String producto;
    private String message;

    // Constructors
    public DeleteMedicionProductoResponseDto() {
    }

    public DeleteMedicionProductoResponseDto(Integer id, String producto, String message) {
        this.id = id;
        this.producto = producto;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
