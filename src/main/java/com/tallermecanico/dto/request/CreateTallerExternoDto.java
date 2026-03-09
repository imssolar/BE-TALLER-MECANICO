package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateTallerExternoDto {

    @NotBlank(message = "La razón social es requerida")
    @Size(max = 50, message = "La razón social no puede exceder 50 caracteres")
    private String razonSocial;

    @Size(max = 12, message = "El RUT no puede exceder 12 caracteres")
    private String rut;

    @Size(max = 100, message = "La dirección no puede exceder 100 caracteres")
    private String direccion;

    private Integer idComuna;

    @Size(max = 15, message = "El fono no puede exceder 15 caracteres")
    private String fono;

    // Constructors
    public CreateTallerExternoDto() {
    }

    // Getters and Setters
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getIdComuna() {
        return idComuna;
    }

    public void setIdComuna(Integer idComuna) {
        this.idComuna = idComuna;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
}
