package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class CreatePagoBonosDto {

    @NotNull(message = "La fecha es requerida")
    private LocalDate fecha;

    public CreatePagoBonosDto() {
    }

    public CreatePagoBonosDto(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
