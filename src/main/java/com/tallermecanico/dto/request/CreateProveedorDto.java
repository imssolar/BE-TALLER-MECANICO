package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CreateProveedorDto {

    @NotBlank(message = "El RUT es requerido")
    @Size(max = 12, message = "El RUT no puede exceder 12 caracteres")
    private String rut;

    @Size(max = 100, message = "La razón social no puede exceder 100 caracteres")
    private String razonSocial;

    @Size(max = 50, message = "La dirección no puede exceder 50 caracteres")
    private String direccion;

    private Integer idComuna;

    private Integer idCiudad;

    @Size(max = 15, message = "El fono 1 no puede exceder 15 caracteres")
    private String fono1;

    @Size(max = 15, message = "El fono 2 no puede exceder 15 caracteres")
    private String fono2;

    @Size(max = 30, message = "El email no puede exceder 30 caracteres")
    private String email;

    @Size(max = 30, message = "El contacto no puede exceder 30 caracteres")
    private String contacto;

    @Size(max = 15, message = "El fono de contacto no puede exceder 15 caracteres")
    private String fonoContacto;

    @Size(max = 15, message = "El área no puede exceder 15 caracteres")
    private String area;

    // Constructors
    public CreateProveedorDto() {
    }

    // Getters and Setters
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
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

    public Integer getIdCiudad() {
        return idCiudad;
    }

    public void setIdCiudad(Integer idCiudad) {
        this.idCiudad = idCiudad;
    }

    public String getFono1() {
        return fono1;
    }

    public void setFono1(String fono1) {
        this.fono1 = fono1;
    }

    public String getFono2() {
        return fono2;
    }

    public void setFono2(String fono2) {
        this.fono2 = fono2;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getFonoContacto() {
        return fonoContacto;
    }

    public void setFonoContacto(String fonoContacto) {
        this.fonoContacto = fonoContacto;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
