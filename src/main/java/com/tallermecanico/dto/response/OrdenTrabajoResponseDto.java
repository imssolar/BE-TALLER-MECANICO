package com.tallermecanico.dto.response;

import java.time.LocalDateTime;

public class OrdenTrabajoResponseDto {

    private Integer id;
    private Integer idTerminal;
    private String nombreTerminal;
    private String tipoOt;
    private Long nroOtManager;
    private Integer idBus;
    private String patenteB;
    private Integer km;
    private String ppu;
    private Integer idConductor;
    private String nombreCompletoConductor;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private String trabajoARealizar;
    private String obsTrabMecanico;
    private String obsTrabElectrico;
    private Integer idJefeTurnoPatio;
    private String nombreCompletoJefeTurnoPatio;
    private LocalDateTime horaJefeTurnoPatio;
    private Integer idJefeTurnoMant;
    private String nombreCompletoJefeTurnoMant;
    private LocalDateTime horaJefeTurnoMant;
    private Integer idSupervCalidad;
    private String nombreCompletoSupervCalidad;
    private LocalDateTime horaSupervCalidad;
    private String obsControlCalidad;
    private String repAutoriza;
    private String repRetira;
    private String repBodega;
    private String itemFalla;

    public OrdenTrabajoResponseDto() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdTerminal() { return idTerminal; }
    public void setIdTerminal(Integer idTerminal) { this.idTerminal = idTerminal; }

    public String getNombreTerminal() { return nombreTerminal; }
    public void setNombreTerminal(String nombreTerminal) { this.nombreTerminal = nombreTerminal; }

    public String getTipoOt() { return tipoOt; }
    public void setTipoOt(String tipoOt) { this.tipoOt = tipoOt; }

    public Long getNroOtManager() { return nroOtManager; }
    public void setNroOtManager(Long nroOtManager) { this.nroOtManager = nroOtManager; }

    public Integer getIdBus() { return idBus; }
    public void setIdBus(Integer idBus) { this.idBus = idBus; }

    public String getPatenteB() { return patenteB; }
    public void setPatenteB(String patenteB) { this.patenteB = patenteB; }

    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }

    public String getPpu() { return ppu; }
    public void setPpu(String ppu) { this.ppu = ppu; }

    public Integer getIdConductor() { return idConductor; }
    public void setIdConductor(Integer idConductor) { this.idConductor = idConductor; }

    public String getNombreCompletoConductor() { return nombreCompletoConductor; }
    public void setNombreCompletoConductor(String nombreCompletoConductor) { this.nombreCompletoConductor = nombreCompletoConductor; }

    public LocalDateTime getFechaHoraIngreso() { return fechaHoraIngreso; }
    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) { this.fechaHoraIngreso = fechaHoraIngreso; }

    public LocalDateTime getFechaHoraSalida() { return fechaHoraSalida; }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) { this.fechaHoraSalida = fechaHoraSalida; }

    public String getTrabajoARealizar() { return trabajoARealizar; }
    public void setTrabajoARealizar(String trabajoARealizar) { this.trabajoARealizar = trabajoARealizar; }

    public String getObsTrabMecanico() { return obsTrabMecanico; }
    public void setObsTrabMecanico(String obsTrabMecanico) { this.obsTrabMecanico = obsTrabMecanico; }

    public String getObsTrabElectrico() { return obsTrabElectrico; }
    public void setObsTrabElectrico(String obsTrabElectrico) { this.obsTrabElectrico = obsTrabElectrico; }

    public Integer getIdJefeTurnoPatio() { return idJefeTurnoPatio; }
    public void setIdJefeTurnoPatio(Integer idJefeTurnoPatio) { this.idJefeTurnoPatio = idJefeTurnoPatio; }

    public String getNombreCompletoJefeTurnoPatio() { return nombreCompletoJefeTurnoPatio; }
    public void setNombreCompletoJefeTurnoPatio(String nombreCompletoJefeTurnoPatio) { this.nombreCompletoJefeTurnoPatio = nombreCompletoJefeTurnoPatio; }

    public LocalDateTime getHoraJefeTurnoPatio() { return horaJefeTurnoPatio; }
    public void setHoraJefeTurnoPatio(LocalDateTime horaJefeTurnoPatio) { this.horaJefeTurnoPatio = horaJefeTurnoPatio; }

    public Integer getIdJefeTurnoMant() { return idJefeTurnoMant; }
    public void setIdJefeTurnoMant(Integer idJefeTurnoMant) { this.idJefeTurnoMant = idJefeTurnoMant; }

    public String getNombreCompletoJefeTurnoMant() { return nombreCompletoJefeTurnoMant; }
    public void setNombreCompletoJefeTurnoMant(String nombreCompletoJefeTurnoMant) { this.nombreCompletoJefeTurnoMant = nombreCompletoJefeTurnoMant; }

    public LocalDateTime getHoraJefeTurnoMant() { return horaJefeTurnoMant; }
    public void setHoraJefeTurnoMant(LocalDateTime horaJefeTurnoMant) { this.horaJefeTurnoMant = horaJefeTurnoMant; }

    public Integer getIdSupervCalidad() { return idSupervCalidad; }
    public void setIdSupervCalidad(Integer idSupervCalidad) { this.idSupervCalidad = idSupervCalidad; }

    public String getNombreCompletoSupervCalidad() { return nombreCompletoSupervCalidad; }
    public void setNombreCompletoSupervCalidad(String nombreCompletoSupervCalidad) { this.nombreCompletoSupervCalidad = nombreCompletoSupervCalidad; }

    public LocalDateTime getHoraSupervCalidad() { return horaSupervCalidad; }
    public void setHoraSupervCalidad(LocalDateTime horaSupervCalidad) { this.horaSupervCalidad = horaSupervCalidad; }

    public String getObsControlCalidad() { return obsControlCalidad; }
    public void setObsControlCalidad(String obsControlCalidad) { this.obsControlCalidad = obsControlCalidad; }

    public String getRepAutoriza() { return repAutoriza; }
    public void setRepAutoriza(String repAutoriza) { this.repAutoriza = repAutoriza; }

    public String getRepRetira() { return repRetira; }
    public void setRepRetira(String repRetira) { this.repRetira = repRetira; }

    public String getRepBodega() { return repBodega; }
    public void setRepBodega(String repBodega) { this.repBodega = repBodega; }

    public String getItemFalla() { return itemFalla; }
    public void setItemFalla(String itemFalla) { this.itemFalla = itemFalla; }
}
