package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UpdateRepuestoOTDto {

    private Integer idOrdenTrabajo;

    private Integer idOrdenTrabajoProg;

    private Integer idOrdenTrabajoMovil;

    private Integer idGlosa;

    @Size(max = 15, message = "El id de repuesto no puede exceder 15 caracteres")
    private String idRepuesto;

    @Size(max = 50, message = "El repuesto no puede exceder 50 caracteres")
    private String repuesto;

    @Min(value = 0, message = "La cantidad no puede ser negativa")
    private Integer cantidad;

    @Min(value = 0, message = "El costo no puede ser negativo")
    private Integer costo;

    // Constructors
    public UpdateRepuestoOTDto() {
    }

    // Getters and Setters
    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

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

    public Integer getIdGlosa() {
        return idGlosa;
    }

    public void setIdGlosa(Integer idGlosa) {
        this.idGlosa = idGlosa;
    }

    public String getIdRepuesto() {
        return idRepuesto;
    }

    public void setIdRepuesto(String idRepuesto) {
        this.idRepuesto = idRepuesto;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Integer getCosto() {
        return costo;
    }

    public void setCosto(Integer costo) {
        this.costo = costo;
    }
}
