package com.tallermecanico.dto.response;

public class DeleteEmpleadoResponseDto {

    private String message;
    private Integer id;
    private String nombreCompleto;
    private String rut;

    // Constructors
    public DeleteEmpleadoResponseDto() {
    }

    public DeleteEmpleadoResponseDto(Integer id, String nombreCompleto, String rut) {
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.rut = rut;
        this.message = String.format("Empleado %s (RUT: %s) eliminado correctamente", nombreCompleto, rut);
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }
}
