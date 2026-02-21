package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public class CreateFacturaMantDto {

    private Integer idProveedor;

    private Long numeroFactura;

    private LocalDate fecha;

    @Size(max = 15, message = "El modelo no puede exceder 15 caracteres")
    private String modelo;

    private Integer idGlosa;

    private Integer idTallerExterno;

    // Constructors
    public CreateFacturaMantDto() {
    }

    // Getters and Setters
    public Integer getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(Integer idProveedor) {
        this.idProveedor = idProveedor;
    }

    public Long getNumeroFactura() {
        return numeroFactura;
    }

    public void setNumeroFactura(Long numeroFactura) {
        this.numeroFactura = numeroFactura;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getIdGlosa() {
        return idGlosa;
    }

    public void setIdGlosa(Integer idGlosa) {
        this.idGlosa = idGlosa;
    }

    public Integer getIdTallerExterno() {
        return idTallerExterno;
    }

    public void setIdTallerExterno(Integer idTallerExterno) {
        this.idTallerExterno = idTallerExterno;
    }
}
