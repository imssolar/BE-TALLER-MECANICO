package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UpdateOrdenTrabajoProgDto {

    private Integer idTerminal;

    private Long nroOtManager;

    private Integer idBus;

    private Integer km;

    @Size(max = 8, message = "La PPU no puede exceder 8 caracteres")
    private String ppu;

    private Integer idConductor;

    private LocalDateTime fechaHoraIngreso;

    private LocalDateTime fechaHoraSalida;

    @Size(max = 120, message = "El trabajo a realizar no puede exceder 120 caracteres")
    private String trabajoARealizar;

    private Integer idJefeTurnoPatio;

    private LocalDateTime horaJefeTurnoPatio;

    private Integer idJefeTurnoMant;

    private LocalDateTime horaJefeTurnoMant;

    private Integer idSupervCalidad;

    private LocalDateTime horaSupervCalidad;

    @Size(max = 100, message = "La observacion de control de calidad no puede exceder 100 caracteres")
    private String obsControlCalidad;

    @Size(max = 50, message = "El representante que autoriza no puede exceder 50 caracteres")
    private String repAutoriza;

    @Size(max = 50, message = "El representante que retira no puede exceder 50 caracteres")
    private String repRetira;

    @Size(max = 50, message = "El representante de bodega no puede exceder 50 caracteres")
    private String repBodega;

    @Size(max = 55, message = "El item no puede exceder 55 caracteres")
    private String item;

    @Size(max = 2, message = "El formato no puede exceder 2 caracteres")
    private String formato;

    // Constructors
    public UpdateOrdenTrabajoProgDto() {
    }

    // Getters and Setters
    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Long getNroOtManager() {
        return nroOtManager;
    }

    public void setNroOtManager(Long nroOtManager) {
        this.nroOtManager = nroOtManager;
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

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
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

    public String getTrabajoARealizar() {
        return trabajoARealizar;
    }

    public void setTrabajoARealizar(String trabajoARealizar) {
        this.trabajoARealizar = trabajoARealizar;
    }

    public Integer getIdJefeTurnoPatio() {
        return idJefeTurnoPatio;
    }

    public void setIdJefeTurnoPatio(Integer idJefeTurnoPatio) {
        this.idJefeTurnoPatio = idJefeTurnoPatio;
    }

    public LocalDateTime getHoraJefeTurnoPatio() {
        return horaJefeTurnoPatio;
    }

    public void setHoraJefeTurnoPatio(LocalDateTime horaJefeTurnoPatio) {
        this.horaJefeTurnoPatio = horaJefeTurnoPatio;
    }

    public Integer getIdJefeTurnoMant() {
        return idJefeTurnoMant;
    }

    public void setIdJefeTurnoMant(Integer idJefeTurnoMant) {
        this.idJefeTurnoMant = idJefeTurnoMant;
    }

    public LocalDateTime getHoraJefeTurnoMant() {
        return horaJefeTurnoMant;
    }

    public void setHoraJefeTurnoMant(LocalDateTime horaJefeTurnoMant) {
        this.horaJefeTurnoMant = horaJefeTurnoMant;
    }

    public Integer getIdSupervCalidad() {
        return idSupervCalidad;
    }

    public void setIdSupervCalidad(Integer idSupervCalidad) {
        this.idSupervCalidad = idSupervCalidad;
    }

    public LocalDateTime getHoraSupervCalidad() {
        return horaSupervCalidad;
    }

    public void setHoraSupervCalidad(LocalDateTime horaSupervCalidad) {
        this.horaSupervCalidad = horaSupervCalidad;
    }

    public String getObsControlCalidad() {
        return obsControlCalidad;
    }

    public void setObsControlCalidad(String obsControlCalidad) {
        this.obsControlCalidad = obsControlCalidad;
    }

    public String getRepAutoriza() {
        return repAutoriza;
    }

    public void setRepAutoriza(String repAutoriza) {
        this.repAutoriza = repAutoriza;
    }

    public String getRepRetira() {
        return repRetira;
    }

    public void setRepRetira(String repRetira) {
        this.repRetira = repRetira;
    }

    public String getRepBodega() {
        return repBodega;
    }

    public void setRepBodega(String repBodega) {
        this.repBodega = repBodega;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
