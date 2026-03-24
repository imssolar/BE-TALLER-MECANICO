package com.tallermecanico.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "cofpatio")
public class Cofpatio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado_mecanico")
    private Empleado mecanico;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado_conductor")
    private Empleado conductor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado_responsable")
    private Empleado responsable;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_empleado_responsable_cierre")
    private Empleado responsableCierre;

    @Column
    private Integer km;

    @Column(name = "fecha_hora")
    private LocalDateTime fechaHora;

    @Column(name = "fecha_hora_operativa")
    private LocalDateTime fechaHoraOperativa;

    @Column(name = "lugar_panne", length = 10)
    private String lugarPanne;

    @Column(name = "cof_patio", length = 5)
    private String cofPatio;

    @Column(name = "nro_cp", length = 5)
    private String nroCp;

    @Column
    private Boolean combustible;

    @Column(length = 50)
    private String falla;

    @Column(length = 50)
    private String ubicacion;

    @Column(length = 50)
    private String cabezal;

    @Column(name = "hora_real")
    private LocalDateTime horaReal;

    @Column(name = "trabajo_terreno", length = 300)
    private String trabajoTerreno;

    @Column(name = "obs_terreno", length = 300)
    private String obsTerreno;

    @Column(name = "operativa_terreno")
    private Boolean operativaTerreno;

    @Column
    private Boolean grua;

    @Column(name = "hora_levantamiento")
    private LocalDateTime horaLevantamiento;

    @Column(name = "tiempo_detencion")
    private LocalDateTime tiempoDetencion;

    @Column(name = "aceite_motor")
    private Integer aceiteMotor;

    @Column(name = "aceite_trans")
    private Integer aceiteTrans;

    @Column(name = "aceite_dir")
    private Integer aceiteDir;

    @Column
    private Integer refrigerante;

    @Column(name = "codigo_panne")
    private Integer codigoPanne;

    @Column(name = "id_intranet")
    private Long idIntranet;

    @Column(name = "ubicacion2", length = 15)
    private String ubicacion2;

    @Column(name = "ubicacion_terreno", length = 50)
    private String ubicacionTerreno;

    @Column(name = "tipo_falla", length = 50)
    private String tipoFalla;

    // Constructors
    public Cofpatio() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
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

    public Empleado getMecanico() {
        return mecanico;
    }

    public void setMecanico(Empleado mecanico) {
        this.mecanico = mecanico;
    }

    public Empleado getConductor() {
        return conductor;
    }

    public void setConductor(Empleado conductor) {
        this.conductor = conductor;
    }

    public Empleado getResponsable() {
        return responsable;
    }

    public void setResponsable(Empleado responsable) {
        this.responsable = responsable;
    }

    public Empleado getResponsableCierre() {
        return responsableCierre;
    }

    public void setResponsableCierre(Empleado responsableCierre) {
        this.responsableCierre = responsableCierre;
    }

    
}
