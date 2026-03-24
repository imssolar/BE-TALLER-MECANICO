package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class UpdateOrdenTrabajoMovilDto {

    @Size(max = 15, message = "El tipo de OTM no debe exceder los 15 caracteres")
    private String tipoOtm;

    private Integer idTerminal;

    private Long nroOtManager;

    private Integer nroMovil;

    private Integer km;

    @Size(max = 8, message = "La PPU no debe exceder los 8 caracteres")
    private String ppu;

    private Integer idConductor;

    private LocalDateTime fechaHoraIngreso;

    private LocalDateTime fechaHoraSalida;

    @Size(max = 150, message = "El trabajo a realizar no debe exceder los 150 caracteres")
    private String trabajoARealizar;

    @Size(max = 150, message = "La observacion de recepcion no debe exceder los 150 caracteres")
    private String obsRecepcion;

    private Integer idResponsable;

    private LocalDateTime horaResponsable;

    private Integer idRespTecnico;

    private LocalDateTime horaTecnico;

    private Integer idRespRecepciona;

    private LocalDateTime horaRecepcion;

    @Size(max = 150, message = "Las observaciones tecnicas no deben exceder los 150 caracteres")
    private String obsTecnicas;

    @Size(max = 50, message = "El campo autoriza no debe exceder los 50 caracteres")
    private String autoriza;

    @Size(max = 50, message = "El campo retira no debe exceder los 50 caracteres")
    private String retira;

    @Size(max = 50, message = "La bodega no debe exceder los 50 caracteres")
    private String bodega;

    @Size(max = 2, message = "El formato no debe exceder los 2 caracteres")
    private String formato;

    // Constructors
    public UpdateOrdenTrabajoMovilDto() {
    }

    // Getters and Setters
    public String getTipoOtm() {
        return tipoOtm;
    }

    public void setTipoOtm(String tipoOtm) {
        this.tipoOtm = tipoOtm;
    }

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

    public Integer getNroMovil() {
        return nroMovil;
    }

    public void setNroMovil(Integer nroMovil) {
        this.nroMovil = nroMovil;
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

    public String getObsRecepcion() {
        return obsRecepcion;
    }

    public void setObsRecepcion(String obsRecepcion) {
        this.obsRecepcion = obsRecepcion;
    }

    public Integer getIdResponsable() {
        return idResponsable;
    }

    public void setIdResponsable(Integer idResponsable) {
        this.idResponsable = idResponsable;
    }

    public LocalDateTime getHoraResponsable() {
        return horaResponsable;
    }

    public void setHoraResponsable(LocalDateTime horaResponsable) {
        this.horaResponsable = horaResponsable;
    }

    public Integer getIdRespTecnico() {
        return idRespTecnico;
    }

    public void setIdRespTecnico(Integer idRespTecnico) {
        this.idRespTecnico = idRespTecnico;
    }

    public LocalDateTime getHoraTecnico() {
        return horaTecnico;
    }

    public void setHoraTecnico(LocalDateTime horaTecnico) {
        this.horaTecnico = horaTecnico;
    }

    public Integer getIdRespRecepciona() {
        return idRespRecepciona;
    }

    public void setIdRespRecepciona(Integer idRespRecepciona) {
        this.idRespRecepciona = idRespRecepciona;
    }

    public LocalDateTime getHoraRecepcion() {
        return horaRecepcion;
    }

    public void setHoraRecepcion(LocalDateTime horaRecepcion) {
        this.horaRecepcion = horaRecepcion;
    }

    public String getObsTecnicas() {
        return obsTecnicas;
    }

    public void setObsTecnicas(String obsTecnicas) {
        this.obsTecnicas = obsTecnicas;
    }

    public String getAutoriza() {
        return autoriza;
    }

    public void setAutoriza(String autoriza) {
        this.autoriza = autoriza;
    }

    public String getRetira() {
        return retira;
    }

    public void setRetira(String retira) {
        this.retira = retira;
    }

    public String getBodega() {
        return bodega;
    }

    public void setBodega(String bodega) {
        this.bodega = bodega;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
