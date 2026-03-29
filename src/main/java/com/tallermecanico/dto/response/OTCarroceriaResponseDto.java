package com.tallermecanico.dto.response;

import java.time.LocalDateTime;

public class OTCarroceriaResponseDto {

    private Integer id;
    private String tipoOttc;

    private Integer idTerminal;
    private String terminal;

    private Integer idBus;
    private String patenteB;

    private Integer km;
    private String ppu;
    private LocalDateTime fechaHoraIngreso;
    private LocalDateTime fechaHoraSalida;

    private Integer idGravedadCarroceria;
    private String gravedadCarroceria;
    private String detalleCarroceria;

    private Integer idGravedadPintura;
    private String gravedadPintura;
    private String detallePintura;

    private Integer idGravedadFibra;
    private String gravedadFibra;
    private String detalleFibra;

    public OTCarroceriaResponseDto() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public String getTipoOttc() { return tipoOttc; }
    public void setTipoOttc(String tipoOttc) { this.tipoOttc = tipoOttc; }

    public Integer getIdTerminal() { return idTerminal; }
    public void setIdTerminal(Integer idTerminal) { this.idTerminal = idTerminal; }

    public String getTerminal() { return terminal; }
    public void setTerminal(String terminal) { this.terminal = terminal; }

    public Integer getIdBus() { return idBus; }
    public void setIdBus(Integer idBus) { this.idBus = idBus; }

    public String getPatenteB() { return patenteB; }
    public void setPatenteB(String patenteB) { this.patenteB = patenteB; }

    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }

    public String getPpu() { return ppu; }
    public void setPpu(String ppu) { this.ppu = ppu; }

    public LocalDateTime getFechaHoraIngreso() { return fechaHoraIngreso; }
    public void setFechaHoraIngreso(LocalDateTime fechaHoraIngreso) { this.fechaHoraIngreso = fechaHoraIngreso; }

    public LocalDateTime getFechaHoraSalida() { return fechaHoraSalida; }
    public void setFechaHoraSalida(LocalDateTime fechaHoraSalida) { this.fechaHoraSalida = fechaHoraSalida; }

    public Integer getIdGravedadCarroceria() { return idGravedadCarroceria; }
    public void setIdGravedadCarroceria(Integer idGravedadCarroceria) { this.idGravedadCarroceria = idGravedadCarroceria; }

    public String getGravedadCarroceria() { return gravedadCarroceria; }
    public void setGravedadCarroceria(String gravedadCarroceria) { this.gravedadCarroceria = gravedadCarroceria; }

    public String getDetalleCarroceria() { return detalleCarroceria; }
    public void setDetalleCarroceria(String detalleCarroceria) { this.detalleCarroceria = detalleCarroceria; }

    public Integer getIdGravedadPintura() { return idGravedadPintura; }
    public void setIdGravedadPintura(Integer idGravedadPintura) { this.idGravedadPintura = idGravedadPintura; }

    public String getGravedadPintura() { return gravedadPintura; }
    public void setGravedadPintura(String gravedadPintura) { this.gravedadPintura = gravedadPintura; }

    public String getDetallePintura() { return detallePintura; }
    public void setDetallePintura(String detallePintura) { this.detallePintura = detallePintura; }

    public Integer getIdGravedadFibra() { return idGravedadFibra; }
    public void setIdGravedadFibra(Integer idGravedadFibra) { this.idGravedadFibra = idGravedadFibra; }

    public String getGravedadFibra() { return gravedadFibra; }
    public void setGravedadFibra(String gravedadFibra) { this.gravedadFibra = gravedadFibra; }

    public String getDetalleFibra() { return detalleFibra; }
    public void setDetalleFibra(String detalleFibra) { this.detalleFibra = detalleFibra; }
}
