package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;

public class UpdateBusTallerCarDto {

    @Size(max = 7, message = "La patente no puede exceder 7 caracteres")
    private String patenteB;

    @Size(max = 50, message = "La marca no puede exceder 50 caracteres")
    private String marcaB;

    @Size(max = 50, message = "El motor no puede exceder 50 caracteres")
    private String motorB;

    @Size(max = 15, message = "El modelo no puede exceder 15 caracteres")
    private String modeloB;

    @Min(value = 1900, message = "El año de fabricación debe ser mayor o igual a 1900")
    private Integer anioFabB;

    @Size(max = 15, message = "La transmisión no puede exceder 15 caracteres")
    private String transmisionB;

    private Boolean operativaB;

    @Min(value = 0, message = "El kilometraje no puede ser negativo")
    private Integer kmB;

    @Size(max = 2, message = "La zona no puede exceder 2 caracteres")
    private String zonaB;

    private Integer idTerminal;

    @Min(value = 0, message = "El número de neumáticos no puede ser negativo")
    private Short nroNeumaticosB;

    private Boolean activoB;

    @Size(max = 10, message = "La fecha de emergencia no puede exceder 10 caracteres")
    private String fEmergenciaB;

    @Size(max = 10, message = "La hora de emergencia no puede exceder 10 caracteres")
    private String hEmergenciaB;

    @Size(max = 80, message = "Las observaciones de emergencia no pueden exceder 80 caracteres")
    private String obsEmergenciaB;

    private Boolean abastecimientoB;
    private Boolean mantencionB;
    private Boolean operacionB;
    private Boolean noControladaB;
    private Boolean operativaPatio;

    @Size(max = 10, message = "El proyecto de reparación no puede exceder 10 caracteres")
    private String proyRep;

    @Min(value = 0, message = "El número de baterías no puede ser negativo")
    private Integer nroBaterias;

    // Constructors
    public UpdateBusTallerCarDto() {
    }

    // Getters and Setters
    public String getPatenteB() {
        return patenteB;
    }

    public void setPatenteB(String patenteB) {
        this.patenteB = patenteB != null ? patenteB.trim().toUpperCase() : null;
    }

    public String getMarcaB() {
        return marcaB;
    }

    public void setMarcaB(String marcaB) {
        this.marcaB = marcaB;
    }

    public String getMotorB() {
        return motorB;
    }

    public void setMotorB(String motorB) {
        this.motorB = motorB;
    }

    public String getModeloB() {
        return modeloB;
    }

    public void setModeloB(String modeloB) {
        this.modeloB = modeloB;
    }

    public Integer getAnioFabB() {
        return anioFabB;
    }

    public void setAnioFabB(Integer anioFabB) {
        this.anioFabB = anioFabB;
    }

    public String getTransmisionB() {
        return transmisionB;
    }

    public void setTransmisionB(String transmisionB) {
        this.transmisionB = transmisionB;
    }

    public Boolean getOperativaB() {
        return operativaB;
    }

    public void setOperativaB(Boolean operativaB) {
        this.operativaB = operativaB;
    }

    public Integer getKmB() {
        return kmB;
    }

    public void setKmB(Integer kmB) {
        this.kmB = kmB;
    }

    public String getZonaB() {
        return zonaB;
    }

    public void setZonaB(String zonaB) {
        this.zonaB = zonaB;
    }

    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public Short getNroNeumaticosB() {
        return nroNeumaticosB;
    }

    public void setNroNeumaticosB(Short nroNeumaticosB) {
        this.nroNeumaticosB = nroNeumaticosB;
    }

    public Boolean getActivoB() {
        return activoB;
    }

    public void setActivoB(Boolean activoB) {
        this.activoB = activoB;
    }

    public String getFEmergenciaB() {
        return fEmergenciaB;
    }

    public void setFEmergenciaB(String fEmergenciaB) {
        this.fEmergenciaB = fEmergenciaB;
    }

    public String getHEmergenciaB() {
        return hEmergenciaB;
    }

    public void setHEmergenciaB(String hEmergenciaB) {
        this.hEmergenciaB = hEmergenciaB;
    }

    public String getObsEmergenciaB() {
        return obsEmergenciaB;
    }

    public void setObsEmergenciaB(String obsEmergenciaB) {
        this.obsEmergenciaB = obsEmergenciaB;
    }

    public Boolean getAbastecimientoB() {
        return abastecimientoB;
    }

    public void setAbastecimientoB(Boolean abastecimientoB) {
        this.abastecimientoB = abastecimientoB;
    }

    public Boolean getMantencionB() {
        return mantencionB;
    }

    public void setMantencionB(Boolean mantencionB) {
        this.mantencionB = mantencionB;
    }

    public Boolean getOperacionB() {
        return operacionB;
    }

    public void setOperacionB(Boolean operacionB) {
        this.operacionB = operacionB;
    }

    public Boolean getNoControladaB() {
        return noControladaB;
    }

    public void setNoControladaB(Boolean noControladaB) {
        this.noControladaB = noControladaB;
    }

    public Boolean getOperativaPatio() {
        return operativaPatio;
    }

    public void setOperativaPatio(Boolean operativaPatio) {
        this.operativaPatio = operativaPatio;
    }

    public String getProyRep() {
        return proyRep;
    }

    public void setProyRep(String proyRep) {
        this.proyRep = proyRep;
    }

    public Integer getNroBaterias() {
        return nroBaterias;
    }

    public void setNroBaterias(Integer nroBaterias) {
        this.nroBaterias = nroBaterias;
    }
}
