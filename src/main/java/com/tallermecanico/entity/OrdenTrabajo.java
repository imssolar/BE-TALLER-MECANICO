package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "orden_trabajo")
public class OrdenTrabajo {

    @Id
    @Column(name = "id_ot")
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_terminal")
    private Terminal terminal;

    @Column(name = "tipo_ot", length = 20)
    private String tipoOt;

    @Column(name = "nro_ot_manager")
    private Long nroOtManager;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_bus")
    private Bus bus;

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

    @Column(name = "trabajo_a_realizar", length = 120)
    private String trabajoARealizar;

    @Column(name = "obs_trab_mecanico", length = 300)
    private String obsTrabMecanico;

    @Column(name = "obs_trab_electrico", length = 500)
    private String obsTrabElectrico;

    @Column(name = "jefe_turno_patio", length = 50)
    private String jefeTurnoPatio;

    @Column(name = "hora_jefe_turno_patio")
    private LocalDateTime horaJefeTurnoPatio;

    @Column(name = "jefe_turno_mant", length = 50)
    private String jefeTurnoMant;

    @Column(name = "hora_jefe_turno_mant")
    private LocalDateTime horaJefeTurnoMant;

    @Column(name = "superv_calidad", length = 50)
    private String supervCalidad;

    @Column(name = "hora_superv_calidad")
    private LocalDateTime horaSupervCalidad;

    @Column(name = "obs_control_calidad", length = 100)
    private String obsControlCalidad;

    @Column(name = "rep_autoriza", length = 50)
    private String repAutoriza;

    @Column(name = "rep_retira", length = 50)
    private String repRetira;

    @Column(name = "rep_bodega", length = 50)
    private String repBodega;

    @Column(name = "item_falla", length = 25)
    private String itemFalla;

    // Constructors
    public OrdenTrabajo() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
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

    public String getJefeTurnoPatio() {
        return jefeTurnoPatio;
    }

    public void setJefeTurnoPatio(String jefeTurnoPatio) {
        this.jefeTurnoPatio = jefeTurnoPatio;
    }

    public LocalDateTime getHoraJefeTurnoPatio() {
        return horaJefeTurnoPatio;
    }

    public void setHoraJefeTurnoPatio(LocalDateTime horaJefeTurnoPatio) {
        this.horaJefeTurnoPatio = horaJefeTurnoPatio;
    }

    public String getJefeTurnoMant() {
        return jefeTurnoMant;
    }

    public void setJefeTurnoMant(String jefeTurnoMant) {
        this.jefeTurnoMant = jefeTurnoMant;
    }

    public LocalDateTime getHoraJefeTurnoMant() {
        return horaJefeTurnoMant;
    }

    public void setHoraJefeTurnoMant(LocalDateTime horaJefeTurnoMant) {
        this.horaJefeTurnoMant = horaJefeTurnoMant;
    }

    public String getSupervCalidad() {
        return supervCalidad;
    }

    public void setSupervCalidad(String supervCalidad) {
        this.supervCalidad = supervCalidad;
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
