package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class UpdateMedicionHistoricoDto {

    private Integer idBus;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Long km;

    @Min(value = 0, message = "El nro boucher no puede ser negativo")
    private Long nroBoucher;

    private LocalDateTime fechaHoraInicio;

    private LocalDateTime fechaHoraFin;

    @Size(max = 20, message = "El tipo no puede exceder 20 caracteres")
    private String tipo;

    @Size(max = 50, message = "La marca no puede exceder 50 caracteres")
    private String marca;

    @Size(max = 50, message = "El proveedor no puede exceder 50 caracteres")
    private String proveedor;

    @Size(max = 50, message = "La descripción no puede exceder 50 caracteres")
    private String descripcion;

    @Size(max = 50, message = "La medición no puede exceder 50 caracteres")
    private String medicion;

    @Size(max = 150, message = "Las observaciones no pueden exceder 150 caracteres")
    private String observaciones;

    @Size(max = 20, message = "El resultado no puede exceder 20 caracteres")
    private String resultado;

    // Constructors
    public UpdateMedicionHistoricoDto() {
    }

    // Getters and Setters
    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Long getKm() {
        return km;
    }

    public void setKm(Long km) {
        this.km = km;
    }

    public Long getNroBoucher() {
        return nroBoucher;
    }

    public void setNroBoucher(Long nroBoucher) {
        this.nroBoucher = nroBoucher;
    }

    public LocalDateTime getFechaHoraInicio() {
        return fechaHoraInicio;
    }

    public void setFechaHoraInicio(LocalDateTime fechaHoraInicio) {
        this.fechaHoraInicio = fechaHoraInicio;
    }

    public LocalDateTime getFechaHoraFin() {
        return fechaHoraFin;
    }

    public void setFechaHoraFin(LocalDateTime fechaHoraFin) {
        this.fechaHoraFin = fechaHoraFin;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMedicion() {
        return medicion;
    }

    public void setMedicion(String medicion) {
        this.medicion = medicion;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }
}
