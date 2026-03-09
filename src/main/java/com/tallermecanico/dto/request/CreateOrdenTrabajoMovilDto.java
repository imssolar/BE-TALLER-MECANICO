package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CreateOrdenTrabajoMovilDto {

    @NotNull(message = "El id de la OTM es requerido")
    private Integer id;

    @Size(max = 15, message = "El tipo de OTM no debe exceder los 15 caracteres")
    private String tipoOtm;

    private Integer idTerminal;

    private Long nroOtManager;

    private Integer nroMovil;

    private Integer km;

    @Size(max = 8, message = "La PPU no debe exceder los 8 caracteres")
    private String ppu;

    @Size(max = 30, message = "El conductor no debe exceder los 30 caracteres")
    private String conductor;

    private LocalDateTime fechaHoraIngreso;

    private LocalDateTime fechaHoraSalida;

    @Size(max = 150, message = "El trabajo a realizar no debe exceder los 150 caracteres")
    private String trabajoARealizar;

    @Size(max = 150, message = "La observacion de recepcion no debe exceder los 150 caracteres")
    private String obsRecepcion;

    @Size(max = 50, message = "El responsable no debe exceder los 50 caracteres")
    private String responsable;

    private LocalDateTime horaResponsable;

    @Size(max = 50, message = "El responsable tecnico no debe exceder los 50 caracteres")
    private String respTecnico;

    private LocalDateTime horaTecnico;

    @Size(max = 50, message = "El responsable que recepciona no debe exceder los 50 caracteres")
    private String respRecepciona;

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
    public CreateOrdenTrabajoMovilDto() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
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

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public LocalDateTime getHoraResponsable() {
        return horaResponsable;
    }

    public void setHoraResponsable(LocalDateTime horaResponsable) {
        this.horaResponsable = horaResponsable;
    }

    public String getRespTecnico() {
        return respTecnico;
    }

    public void setRespTecnico(String respTecnico) {
        this.respTecnico = respTecnico;
    }

    public LocalDateTime getHoraTecnico() {
        return horaTecnico;
    }

    public void setHoraTecnico(LocalDateTime horaTecnico) {
        this.horaTecnico = horaTecnico;
    }

    public String getRespRecepciona() {
        return respRecepciona;
    }

    public void setRespRecepciona(String respRecepciona) {
        this.respRecepciona = respRecepciona;
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
