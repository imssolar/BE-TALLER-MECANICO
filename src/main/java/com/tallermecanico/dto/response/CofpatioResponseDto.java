package com.tallermecanico.dto.response;

import java.time.LocalDateTime;

public class CofpatioResponseDto {
    private Integer id;
    private Integer idBus;
    private String patenteB;
    private Integer km;
    private LocalDateTime fechaHora;
    private LocalDateTime fechaHoraOperativa;
    private String lugarPanne;
    private String cofPatio;
    private String nroCp;
    private Boolean combustible;
    private Integer idEmpleadoConductor;
    private String nombreCompletoConductor;
    private String falla;
    private String ubicacion;
    private String cabezal;
    private LocalDateTime horaReal;
    private String trabajoTerreno;
    private String obsTerreno;
    private Boolean operativaTerreno;
    private Integer idEmpleadoMecanico;
    private String nombreCompletoMecanico;
    private Boolean grua;
    private LocalDateTime horaLevantamiento;
    private LocalDateTime tiempoDetencion;
    private Integer idEmpleadoResponsable;
    private String nombreCompletoResponsable;
    private Integer aceiteMotor;
    private Integer aceiteTrans;
    private Integer aceiteDir;
    private Integer refrigerante;
    private Integer codigoPanne;
    private Integer idEmpleadoResponsableCierre;
    private String nombreCompletoResponsableCierre;
    private Long idIntranet;
    private String ubicacion2;
    private String ubicacionTerreno;
    private String tipoFalla;

    public CofpatioResponseDto() {}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdBus() {
        return idBus;
    }

    public void setIdBus(Integer idBus) {
        this.idBus = idBus;
    }

    public String getPatenteB() {
        return patenteB;
    }

    public void setPatenteB(String patenteB) {
        this.patenteB = patenteB;
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

    public Integer getIdEmpleadoConductor() {
        return idEmpleadoConductor;
    }

    public void setIdEmpleadoConductor(Integer idEmpleadoConductor) {
        this.idEmpleadoConductor = idEmpleadoConductor;
    }

    public String getNombreCompletoConductor() {
        return nombreCompletoConductor;
    }

    public void setNombreCompletoConductor(String nombreCompletoConductor) {
        this.nombreCompletoConductor = nombreCompletoConductor;
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

    public Integer getIdEmpleadoMecanico() {
        return idEmpleadoMecanico;
    }

    public void setIdEmpleadoMecanico(Integer idEmpleadoMecanico) {
        this.idEmpleadoMecanico = idEmpleadoMecanico;
    }

    public String getNombreCompletoMecanico() {
        return nombreCompletoMecanico;
    }

    public void setNombreCompletoMecanico(String nombreCompletoMecanico) {
        this.nombreCompletoMecanico = nombreCompletoMecanico;
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

    public Integer getIdEmpleadoResponsable() {
        return idEmpleadoResponsable;
    }

    public void setIdEmpleadoResponsable(Integer idEmpleadoResponsable) {
        this.idEmpleadoResponsable = idEmpleadoResponsable;
    }

    public String getNombreCompletoResponsable() {
        return nombreCompletoResponsable;
    }

    public void setNombreCompletoResponsable(String nombreCompletoResponsable) {
        this.nombreCompletoResponsable = nombreCompletoResponsable;
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

    public Integer getIdEmpleadoResponsableCierre() {
        return idEmpleadoResponsableCierre;
    }

    public void setIdEmpleadoResponsableCierre(Integer idEmpleadoResponsableCierre) {
        this.idEmpleadoResponsableCierre = idEmpleadoResponsableCierre;
    }

    public String getNombreCompletoResponsableCierre() {
        return nombreCompletoResponsableCierre;
    }

    public void setNombreCompletoResponsableCierre(String nombreCompletoResponsableCierre) {
        this.nombreCompletoResponsableCierre = nombreCompletoResponsableCierre;
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
