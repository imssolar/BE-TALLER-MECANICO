package com.tallermecanico.dto.response;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class OTTallerExtResponseDto {

    private Integer id;

    private Integer idBus;
    private String patenteB;

    private Integer km;
    private String ppu;
    private String proveedor;

    private Integer idConductor;
    private String nombreConductor;

    private String recorrido;
    private LocalDate fecha;
    private String recibeTaller;
    private LocalDateTime horaLlegada;
    private LocalDateTime horaSalida;
    private String diagnostico;
    private String nombrePreparador;
    private LocalDateTime horaPreparador;
    private String nombreRevisor;
    private LocalDateTime horaRevisor;
    private String nombreEjecutor;
    private LocalDateTime horaEjecutor;
    private Integer total;
    private String incidencias;
    private String sistema;
    private LocalDate fechaSalida;

    public OTTallerExtResponseDto() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdBus() { return idBus; }
    public void setIdBus(Integer idBus) { this.idBus = idBus; }

    public String getPatenteB() { return patenteB; }
    public void setPatenteB(String patenteB) { this.patenteB = patenteB; }

    public Integer getKm() { return km; }
    public void setKm(Integer km) { this.km = km; }

    public String getPpu() { return ppu; }
    public void setPpu(String ppu) { this.ppu = ppu; }

    public String getProveedor() { return proveedor; }
    public void setProveedor(String proveedor) { this.proveedor = proveedor; }

    public Integer getIdConductor() { return idConductor; }
    public void setIdConductor(Integer idConductor) { this.idConductor = idConductor; }

    public String getNombreConductor() { return nombreConductor; }
    public void setNombreConductor(String nombreConductor) { this.nombreConductor = nombreConductor; }

    public String getRecorrido() { return recorrido; }
    public void setRecorrido(String recorrido) { this.recorrido = recorrido; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }

    public String getRecibeTaller() { return recibeTaller; }
    public void setRecibeTaller(String recibeTaller) { this.recibeTaller = recibeTaller; }

    public LocalDateTime getHoraLlegada() { return horaLlegada; }
    public void setHoraLlegada(LocalDateTime horaLlegada) { this.horaLlegada = horaLlegada; }

    public LocalDateTime getHoraSalida() { return horaSalida; }
    public void setHoraSalida(LocalDateTime horaSalida) { this.horaSalida = horaSalida; }

    public String getDiagnostico() { return diagnostico; }
    public void setDiagnostico(String diagnostico) { this.diagnostico = diagnostico; }

    public String getNombrePreparador() { return nombrePreparador; }
    public void setNombrePreparador(String nombrePreparador) { this.nombrePreparador = nombrePreparador; }

    public LocalDateTime getHoraPreparador() { return horaPreparador; }
    public void setHoraPreparador(LocalDateTime horaPreparador) { this.horaPreparador = horaPreparador; }

    public String getNombreRevisor() { return nombreRevisor; }
    public void setNombreRevisor(String nombreRevisor) { this.nombreRevisor = nombreRevisor; }

    public LocalDateTime getHoraRevisor() { return horaRevisor; }
    public void setHoraRevisor(LocalDateTime horaRevisor) { this.horaRevisor = horaRevisor; }

    public String getNombreEjecutor() { return nombreEjecutor; }
    public void setNombreEjecutor(String nombreEjecutor) { this.nombreEjecutor = nombreEjecutor; }

    public LocalDateTime getHoraEjecutor() { return horaEjecutor; }
    public void setHoraEjecutor(LocalDateTime horaEjecutor) { this.horaEjecutor = horaEjecutor; }

    public Integer getTotal() { return total; }
    public void setTotal(Integer total) { this.total = total; }

    public String getIncidencias() { return incidencias; }
    public void setIncidencias(String incidencias) { this.incidencias = incidencias; }

    public String getSistema() { return sistema; }
    public void setSistema(String sistema) { this.sistema = sistema; }

    public LocalDate getFechaSalida() { return fechaSalida; }
    public void setFechaSalida(LocalDate fechaSalida) { this.fechaSalida = fechaSalida; }
}
