package com.tallermecanico.dto.response;

import java.time.LocalDate;

public class DeletePagoBonosResponseDto {

    private Integer id;
    private LocalDate fecha;
    private String message;

    public DeletePagoBonosResponseDto() {
    }

    public DeletePagoBonosResponseDto(Integer id, LocalDate fecha, String message) {
        this.id = id;
        this.fecha = fecha;
        this.message = message;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
