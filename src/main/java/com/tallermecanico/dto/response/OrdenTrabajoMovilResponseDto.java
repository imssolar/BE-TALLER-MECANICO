package com.tallermecanico.dto.response;

import java.time.LocalDateTime;

public class OrdenTrabajoMovilResponseDto {

    private Integer id;
    private String tipoOtm;
    private Integer idTerminal;
    private Long nroOtManager;
    private Integer nroMovil;
    private Integer km;
    private String ppu;
    private Integer idConductor;
    private String nombreCompletoConductor;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;
    private String trabajoARealizar;
    private String obsRecepcion;
    private Integer idResponsable;
    private String nombreCompletoResponsable;
    private LocalDateTime horaResponsable;
    private Integer idRespTecnico;
    private String nombreCompletoRespTecnico;
    private LocalDateTime horaTecnico;
    private Integer idRespRecepciona;
    private String nombreCompletoRespRecepciona;
    private LocalDateTime horaRecepcion;
    private String obsTecnicas;
    private String autoriza;
    private String retira;
    private String bodega;
    private String formato;

    public OrdenTrabajoMovilResponseDto() {}

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTipoOtm() { return tipoOtm; }
    public void setTipoOtm(String tipoOtm) { this.tipoOtm = tipoOtm; }

    public Integer getIdTerminal() { return idTerminal; }
    public void setIdTerminal(Integer idTerminal) { this.idTerminal = idTerminal; }

    public Long getNroOtManager() { return nroOtManager; }
    public void setNroOtManager(Long nroOtManager) { this.nroOtManager = nroOtManager; }

    public Integer getNroMovil() { return nroMovil; }
    public void setNroMovil(Integer nroMovil) { this.nroMovil = nroMovil; }

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

    public String getObsRecepcion() { return obsRecepcion; }
    public void setObsRecepcion(String obsRecepcion) { this.obsRecepcion = obsRecepcion; }

    public Integer getIdResponsable() { return idResponsable; }
    public void setIdResponsable(Integer idResponsable) { this.idResponsable = idResponsable; }

    public String getNombreCompletoResponsable() { return nombreCompletoResponsable; }
    public void setNombreCompletoResponsable(String nombreCompletoResponsable) { this.nombreCompletoResponsable = nombreCompletoResponsable; }

    public LocalDateTime getHoraResponsable() { return horaResponsable; }
    public void setHoraResponsable(LocalDateTime horaResponsable) { this.horaResponsable = horaResponsable; }

    public Integer getIdRespTecnico() { return idRespTecnico; }
    public void setIdRespTecnico(Integer idRespTecnico) { this.idRespTecnico = idRespTecnico; }

    public String getNombreCompletoRespTecnico() { return nombreCompletoRespTecnico; }
    public void setNombreCompletoRespTecnico(String nombreCompletoRespTecnico) { this.nombreCompletoRespTecnico = nombreCompletoRespTecnico; }

    public LocalDateTime getHoraTecnico() { return horaTecnico; }
    public void setHoraTecnico(LocalDateTime horaTecnico) { this.horaTecnico = horaTecnico; }

    public Integer getIdRespRecepciona() { return idRespRecepciona; }
    public void setIdRespRecepciona(Integer idRespRecepciona) { this.idRespRecepciona = idRespRecepciona; }

    public String getNombreCompletoRespRecepciona() { return nombreCompletoRespRecepciona; }
    public void setNombreCompletoRespRecepciona(String nombreCompletoRespRecepciona) { this.nombreCompletoRespRecepciona = nombreCompletoRespRecepciona; }

    public LocalDateTime getHoraRecepcion() { return horaRecepcion; }
    public void setHoraRecepcion(LocalDateTime horaRecepcion) { this.horaRecepcion = horaRecepcion; }

    public String getObsTecnicas() { return obsTecnicas; }
    public void setObsTecnicas(String obsTecnicas) { this.obsTecnicas = obsTecnicas; }

    public String getAutoriza() { return autoriza; }
    public void setAutoriza(String autoriza) { this.autoriza = autoriza; }

    public String getRetira() { return retira; }
    public void setRetira(String retira) { this.retira = retira; }

    public String getBodega() { return bodega; }
    public void setBodega(String bodega) { this.bodega = bodega; }

    public String getFormato() { return formato; }
    public void setFormato(String formato) { this.formato = formato; }
}
