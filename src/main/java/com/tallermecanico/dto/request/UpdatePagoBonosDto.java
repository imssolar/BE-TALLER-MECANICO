package com.tallermecanico.dto.request;

import java.time.LocalDate;

public class UpdatePagoBonosDto {

    private LocalDate fecha;

    public UpdatePagoBonosDto() {
    }

    public UpdatePagoBonosDto(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
}
