package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UpdateOrdenTrabajoDto {

    private Integer idTerminal;

    @Size(max = 20, message = "El tipo de OT no puede exceder los 20 caracteres")
    private String tipoOt;

    private Long nroOtManager;

    private Integer idBus;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer km;

    @Size(max = 8, message = "La PPU no puede exceder los 8 caracteres")
    private String ppu;

    private Integer idConductor;

    private LocalDateTime fechaHoraIngreso;

    private LocalDateTime fechaHoraSalida;

    @Size(max = 120, message = "El trabajo a realizar no puede exceder los 120 caracteres")
    private String trabajoARealizar;

    @Size(max = 300, message = "Las observaciones de trabajo mecánico no pueden exceder los 300 caracteres")
    private String obsTrabMecanico;

    @Size(max = 500, message = "Las observaciones de trabajo eléctrico no pueden exceder los 500 caracteres")
    private String obsTrabElectrico;

    private Integer idJefeTurnoPatio;

    private LocalDateTime horaJefeTurnoPatio;

    private Integer idJefeTurnoMant;

    private LocalDateTime horaJefeTurnoMant;

    private Integer idSupervCalidad;

    private LocalDateTime horaSupervCalidad;

    @Size(max = 100, message = "Las observaciones de control de calidad no pueden exceder los 100 caracteres")
    private String obsControlCalidad;

    @Size(max = 50, message = "El representante que autoriza no puede exceder los 50 caracteres")
    private String repAutoriza;

    @Size(max = 50, message = "El representante que retira no puede exceder los 50 caracteres")
    private String repRetira;

    @Size(max = 50, message = "El representante de bodega no puede exceder los 50 caracteres")
    private String repBodega;

    @Size(max = 25, message = "El item de falla no puede exceder los 25 caracteres")
    private String itemFalla;

    // Constructors
    public UpdateOrdenTrabajoDto() {
    }

    // Getters and Setters
    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getTipoOt() {
        return tipoOt;
    }

    public void setTipoOt(String tipoOt) {
        this.tipoOt = tipoOt;
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

    public String getObsTrabMecanico() {
        return obsTrabMecanico;
    }

    public void setObsTrabMecanico(String obsTrabMecanico) {
        this.obsTrabMecanico = obsTrabMecanico;
    }

    public String getObsTrabElectrico() {
        return obsTrabElectrico;
    }

    public void setObsTrabElectrico(String obsTrabElectrico) {
        this.obsTrabElectrico = obsTrabElectrico;
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

    public String getItemFalla() {
        return itemFalla;
    }

    public void setItemFalla(String itemFalla) {
        this.itemFalla = itemFalla;
    }
}
