package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDateTime;

public class UpdateCofpatioDto {

    private Integer idBus;

    @Min(value = 0, message = "El km no puede ser negativo")
    private Integer km;

    private LocalDateTime fechaHora;

    private LocalDateTime fechaHoraOperativa;

    @Size(max = 10, message = "El lugar panne no debe exceder los 10 caracteres")
    private String lugarPanne;

    @Size(max = 5, message = "El cof patio no debe exceder los 5 caracteres")
    private String cofPatio;

    @Size(max = 5, message = "El nro cp no debe exceder los 5 caracteres")
    private String nroCp;

    private Boolean combustible;

    @Size(max = 80, message = "El conductor no debe exceder los 80 caracteres")
    private String conductor;

    @Size(max = 50, message = "La falla no debe exceder los 50 caracteres")
    private String falla;

    @Size(max = 50, message = "La ubicacion no debe exceder los 50 caracteres")
    private String ubicacion;

    @Size(max = 50, message = "El cabezal no debe exceder los 50 caracteres")
    private String cabezal;

    private LocalDateTime horaReal;

    @Size(max = 300, message = "El trabajo terreno no debe exceder los 300 caracteres")
    private String trabajoTerreno;

    @Size(max = 300, message = "La obs terreno no debe exceder los 300 caracteres")
    private String obsTerreno;

    private Boolean operativaTerreno;

    @Size(max = 50, message = "El mecanico no debe exceder los 50 caracteres")
    private String mecanico;

    private Boolean grua;

    private LocalDateTime horaLevantamiento;

    private LocalDateTime tiempoDetencion;

    @Size(max = 25, message = "El responsable no debe exceder los 25 caracteres")
    private String responsable;

    @Min(value = 0, message = "El aceite motor no puede ser negativo")
    private Integer aceiteMotor;

    @Min(value = 0, message = "El aceite trans no puede ser negativo")
    private Integer aceiteTrans;

    @Min(value = 0, message = "El aceite dir no puede ser negativo")
    private Integer aceiteDir;

    @Min(value = 0, message = "El refrigerante no puede ser negativo")
    private Integer refrigerante;

    @Min(value = 0, message = "El codigo panne no puede ser negativo")
    private Integer codigoPanne;

    @Size(max = 50, message = "El responsable cierre no debe exceder los 50 caracteres")
    private String responsableCierre;

    private Long idIntranet;

    @Size(max = 15, message = "La ubicacion2 no debe exceder los 15 caracteres")
    private String ubicacion2;

    @Size(max = 50, message = "La ubicacion terreno no debe exceder los 50 caracteres")
    private String ubicacionTerreno;

    @Size(max = 50, message = "El tipo falla no debe exceder los 50 caracteres")
    private String tipoFalla;

    // Constructors
    public UpdateCofpatioDto() {
    }

    // Getters and Setters
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

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public LocalDateTime getFechaHoraOperativa() {
        return fechaHoraOperativa;
    }

    public void setFechaHoraOperativa(LocalDateTime fechaHoraOperativa) {
        this.fechaHoraOperativa = fechaHoraOperativa;
    }

    public String getLugarPanne() {
        return lugarPanne;
    }

    public void setLugarPanne(String lugarPanne) {
        this.lugarPanne = lugarPanne;
    }

    public String getCofPatio() {
        return cofPatio;
    }

    public void setCofPatio(String cofPatio) {
        this.cofPatio = cofPatio;
    }

    public String getNroCp() {
        return nroCp;
    }

    public void setNroCp(String nroCp) {
        this.nroCp = nroCp;
    }

    public Boolean getCombustible() {
        return combustible;
    }

    public void setCombustible(Boolean combustible) {
        this.combustible = combustible;
    }

    public String getConductor() {
        return conductor;
    }

    public void setConductor(String conductor) {
        this.conductor = conductor;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getCabezal() {
        return cabezal;
    }

    public void setCabezal(String cabezal) {
        this.cabezal = cabezal;
    }

    public LocalDateTime getHoraReal() {
        return horaReal;
    }

    public void setHoraReal(LocalDateTime horaReal) {
        this.horaReal = horaReal;
    }

    public String getTrabajoTerreno() {
        return trabajoTerreno;
    }

    public void setTrabajoTerreno(String trabajoTerreno) {
        this.trabajoTerreno = trabajoTerreno;
    }

    public String getObsTerreno() {
        return obsTerreno;
    }

    public void setObsTerreno(String obsTerreno) {
        this.obsTerreno = obsTerreno;
    }

    public Boolean getOperativaTerreno() {
        return operativaTerreno;
    }

    public void setOperativaTerreno(Boolean operativaTerreno) {
        this.operativaTerreno = operativaTerreno;
    }

    public String getMecanico() {
        return mecanico;
    }

    public void setMecanico(String mecanico) {
        this.mecanico = mecanico;
    }

    public Boolean getGrua() {
        return grua;
    }

    public void setGrua(Boolean grua) {
        this.grua = grua;
    }

    public LocalDateTime getHoraLevantamiento() {
        return horaLevantamiento;
    }

    public void setHoraLevantamiento(LocalDateTime horaLevantamiento) {
        this.horaLevantamiento = horaLevantamiento;
    }

    public LocalDateTime getTiempoDetencion() {
        return tiempoDetencion;
    }

    public void setTiempoDetencion(LocalDateTime tiempoDetencion) {
        this.tiempoDetencion = tiempoDetencion;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public Integer getAceiteMotor() {
        return aceiteMotor;
    }

    public void setAceiteMotor(Integer aceiteMotor) {
        this.aceiteMotor = aceiteMotor;
    }

    public Integer getAceiteTrans() {
        return aceiteTrans;
    }

    public void setAceiteTrans(Integer aceiteTrans) {
        this.aceiteTrans = aceiteTrans;
    }

    public Integer getAceiteDir() {
        return aceiteDir;
    }

    public void setAceiteDir(Integer aceiteDir) {
        this.aceiteDir = aceiteDir;
    }

    public Integer getRefrigerante() {
        return refrigerante;
    }

    public void setRefrigerante(Integer refrigerante) {
        this.refrigerante = refrigerante;
    }

    public Integer getCodigoPanne() {
        return codigoPanne;
    }

    public void setCodigoPanne(Integer codigoPanne) {
        this.codigoPanne = codigoPanne;
    }

    public String getResponsableCierre() {
        return responsableCierre;
    }

    public void setResponsableCierre(String responsableCierre) {
        this.responsableCierre = responsableCierre;
    }

    public Long getIdIntranet() {
        return idIntranet;
    }

    public void setIdIntranet(Long idIntranet) {
        this.idIntranet = idIntranet;
    }

    public String getUbicacion2() {
        return ubicacion2;
    }

    public void setUbicacion2(String ubicacion2) {
        this.ubicacion2 = ubicacion2;
    }

    public String getUbicacionTerreno() {
        return ubicacionTerreno;
    }

    public void setUbicacionTerreno(String ubicacionTerreno) {
        this.ubicacionTerreno = ubicacionTerreno;
    }

    public String getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(String tipoFalla) {
        this.tipoFalla = tipoFalla;
    }
}
