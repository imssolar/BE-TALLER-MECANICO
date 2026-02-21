package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class UpdateOTCarroceriaDto {

    @Size(max = 15, message = "El tipo no puede exceder 15 caracteres")
    private String tipoOttc;

    private Integer idTerminal;

    private Integer idBus;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer km;

    @Size(max = 7, message = "La PPU no puede exceder 7 caracteres")
    private String ppu;

    private LocalDateTime fechaHoraIngreso;

    private LocalDateTime fechaHoraSalida;

    private Integer idGravedadCarroceria;

    @Size(max = 200, message = "El detalle de carroceria no puede exceder 200 caracteres")
    private String detalleCarroceria;

    private Integer idGravedadPintura;

    @Size(max = 200, message = "El detalle de pintura no puede exceder 200 caracteres")
    private String detallePintura;

    private Integer idGravedadFibra;

    @Size(max = 200, message = "El detalle de fibra no puede exceder 200 caracteres")
    private String detalleFibra;

    // Constructors
    public UpdateOTCarroceriaDto() {
    }

    // Getters and Setters
    public String getTipoOttc() {
        return tipoOttc;
    }

    public void setTipoOttc(String tipoOttc) {
        this.tipoOttc = tipoOttc;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public Integer getKm() {
        return km;
    }

    public void setKm(Integer km) {
        this.km = km;
    }

    public String getPpu() {
        return ppu;
    }

    public void setPpu(String ppu) {
        this.ppu = ppu;
    }

    public LocalDateTime getFechaHoraIngreso() {
        return fechaHoraIngreso;
    }

    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) {
        this.fechaHoraIngreso = fechaHoraIngreso;
    }

    public LocalDateTime getFechaHoraSalida() {
        return fechaHoraSalida;
    }

    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) {
        this.fechaHoraSalida = fechaHoraSalida;
    }

    public Integer getIdGravedadCarroceria() {
        return idGravedadCarroceria;
    }

    public void setIdGravedadCarroceria(Integer idGravedadCarroceria) {
        this.idGravedadCarroceria = idGravedadCarroceria;
    }

    public String getDetalleCarroceria() {
        return detalleCarroceria;
    }

    public void setDetalleCarroceria(String detalleCarroceria) {
        this.detalleCarroceria = detalleCarroceria;
    }

    public Integer getIdGravedadPintura() {
        return idGravedadPintura;
    }

    public void setIdGravedadPintura(Integer idGravedadPintura) {
        this.idGravedadPintura = idGravedadPintura;
    }

    public String getDetallePintura() {
        return detallePintura;
    }

    public void setDetallePintura(String detallePintura) {
        this.detallePintura = detallePintura;
    }

    public Integer getIdGravedadFibra() {
        return idGravedadFibra;
    }

    public void setIdGravedadFibra(Integer idGravedadFibra) {
        this.idGravedadFibra = idGravedadFibra;
    }

    public String getDetalleFibra() {
        return detalleFibra;
    }

    public void setDetalleFibra(String detalleFibra) {
        this.detalleFibra = detalleFibra;
    }
}
