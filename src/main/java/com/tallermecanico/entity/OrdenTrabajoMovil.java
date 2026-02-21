package com.tallermecanico.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "orden_trabajo_movil")
public class OrdenTrabajoMovil {

    @Id
    @Column(name = "id_otm")
    private Integer id;

    @Column(name = "tipo_otm", length = 15)
    private String tipoOtm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @Column(name = "nro_ot_manager")
    private Long nroOtManager;

    @Column(name = "nro_movil")
    private Integer nroMovil;

    @Column
    private Integer km;

    @Column(length = 8)
    private String ppu;

    @Column(length = 30)
    private String conductor;

    @Column(name = "fecha_hora_ingreso")
    private LocalDateTime fechaHoraIngreso;

    @Column(name = "fecha_hora_salida")
    private LocalDateTime fechaHoraSalida;

    @Column(name = "trabajo_a_realizar", length = 150)
    private String trabajoARealizar;

    @Column(name = "obs_recepcion", length = 150)
    private String obsRecepcion;

    @Column(length = 50)
    private String responsable;

    @Column(name = "hora_responsable")
    private LocalDateTime horaResponsable;

    @Column(name = "resp_tecnico", length = 50)
    private String respTecnico;

    @Column(name = "hora_tecnico")
    private LocalDateTime horaTecnico;

    @Column(name = "resp_recepciona", length = 50)
    private String respRecepciona;

    @Column(name = "hora_recepcion")
    private LocalDateTime horaRecepcion;

    @Column(name = "obs_tecnicas", length = 150)
    private String obsTecnicas;

    @Column(length = 50)
    private String autoriza;

    @Column(length = 50)
    private String retira;

    @Column(length = 50)
    private String bodega;

    @Column(length = 2)
    private String formato;

    // Constructors
    public OrdenTrabajoMovil() {
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

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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
