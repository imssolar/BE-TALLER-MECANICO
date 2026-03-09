package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class CreateDetalleIPSDto {

    private Integer idOrdenTrabajoProg;

    private Integer idOrdenTrabajoMovil;

    @Size(max = 5, message = "El id IPS no puede exceder 5 caracteres")
    private String idIps;

    @DecimalMin(value = "0", message = "Los litros deben ser mayor o igual a 0")
    private BigDecimal litros;

    // Constructors
    public CreateDetalleIPSDto() {
    }

    // Getters and Setters
    public Integer getIdOrdenTrabajoProg() {
        return idOrdenTrabajoProg;
    }

    public void setIdOrdenTrabajoProg(Integer idOrdenTrabajoProg) {
        this.idOrdenTrabajoProg = idOrdenTrabajoProg;
    }

    public Integer getIdOrdenTrabajoMovil() {
        return idOrdenTrabajoMovil;
    }

    public void setIdOrdenTrabajoMovil(Integer idOrdenTrabajoMovil) {
        this.idOrdenTrabajoMovil = idOrdenTrabajoMovil;
    }

    public String getIdIps() {
        return idIps;
    }

    public void setIdIps(String idIps) {
        this.idIps = idIps;
    }

    public BigDecimal getLitros() {
        return litros;
    }

    public void setLitros(BigDecimal litros) {
        this.litros = litros;
    }
}
