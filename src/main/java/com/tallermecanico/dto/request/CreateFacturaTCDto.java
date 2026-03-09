package com.tallermecanico.dto.request;

import java.time.LocalDate;

public class CreateFacturaTCDto {

    private Integer idProveedor;

    private Long numeroFactura;

    private LocalDate fecha;

    private Integer idTerminal;

    // Constructors
    public CreateFacturaTCDto() {
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

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }
}
