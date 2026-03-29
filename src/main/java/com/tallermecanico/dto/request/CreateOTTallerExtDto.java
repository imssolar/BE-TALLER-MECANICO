package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CreateOTTallerExtDto {

    @NotNull(message = "El id es requerido")
    private Integer id;

    private Integer idBus;

    private Integer km;

    @Size(max = 8, message = "La PPU no puede exceder 8 caracteres")
    private String ppu;

    @Size(max = 50, message = "El proveedor no puede exceder 50 caracteres")
    private String proveedor;

    private Integer idConductor;

    @Size(max = 50, message = "El recorrido no puede exceder 50 caracteres")
    private String recorrido;

    private LocalDate fecha;

    @Size(max = 30, message = "El recibe taller no puede exceder 30 caracteres")
    private String recibeTaller;

    private LocalDateTime horaLlegada;

    private LocalDateTime horaSalida;

    @Size(max = 150, message = "El diagnostico no puede exceder 150 caracteres")
    private String diagnostico;

    @Size(max = 50, message = "El nombre preparador no puede exceder 50 caracteres")
    private String nombrePreparador;

    private LocalDateTime horaPreparador;

    @Size(max = 50, message = "El nombre revisor no puede exceder 50 caracteres")
    private String nombreRevisor;

    private LocalDateTime horaRevisor;

    @Size(max = 50, message = "El nombre ejecutor no puede exceder 50 caracteres")
    private String nombreEjecutor;

    private LocalDateTime horaEjecutor;

    private Integer total;

    @Size(max = 30, message = "Las incidencias no pueden exceder 30 caracteres")
    private String incidencias;

    @Size(max = 50, message = "El sistema no puede exceder 50 caracteres")
    private String sistema;

    private LocalDate fechaSalida;

    // Constructors
    public CreateOTTallerExtDto() {
    }

    // Getters and Setters
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

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public Integer getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(Integer idConductor) {
        this.idConductor = idConductor;
    }

    public String getRecorrido() {
        return recorrido;
    }

    public void setRecorrido(String recorrido) {
        this.recorrido = recorrido;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getRecibeTaller() {
        return recibeTaller;
    }

    public void setRecibeTaller(String recibeTaller) {
        this.recibeTaller = recibeTaller;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(LocalDateTime horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(LocalDateTime horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getDiagnostico() {
        return diagnostico;
    }

    public void setDiagnostico(String diagnostico) {
        this.diagnostico = diagnostico;
    }

    public String getNombrePreparador() {
        return nombrePreparador;
    }

    public void setNombrePreparador(String nombrePreparador) {
        this.nombrePreparador = nombrePreparador;
    }

    public LocalDateTime getHoraPreparador() {
        return horaPreparador;
    }

    public void setHoraPreparador(LocalDateTime horaPreparador) {
        this.horaPreparador = horaPreparador;
    }

    public String getNombreRevisor() {
        return nombreRevisor;
    }

    public void setNombreRevisor(String nombreRevisor) {
        this.nombreRevisor = nombreRevisor;
    }

    public LocalDateTime getHoraRevisor() {
        return horaRevisor;
    }

    public void setHoraRevisor(LocalDateTime horaRevisor) {
        this.horaRevisor = horaRevisor;
    }

    public String getNombreEjecutor() {
        return nombreEjecutor;
    }

    public void setNombreEjecutor(String nombreEjecutor) {
        this.nombreEjecutor = nombreEjecutor;
    }

    public LocalDateTime getHoraEjecutor() {
        return horaEjecutor;
    }

    public void setHoraEjecutor(LocalDateTime horaEjecutor) {
        this.horaEjecutor = horaEjecutor;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public String getIncidencias() {
        return incidencias;
    }

    public void setIncidencias(String incidencias) {
        this.incidencias = incidencias;
    }

    public String getSistema() {
        return sistema;
    }

    public void setSistema(String sistema) {
        this.sistema = sistema;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }
}
