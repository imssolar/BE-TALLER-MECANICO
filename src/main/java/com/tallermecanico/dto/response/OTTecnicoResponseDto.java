package com.tallermecanico.dto.response;

import java.time.LocalDateTime;

public class OTTecnicoResponseDto {

    private Integer id;

    private Integer idOrdenTrabajo;
    private Integer idOrdenTrabajoProg;

    private Integer idEmpleado;
    private String nombreEmpleado;

    private String tipo;
    private String cargo;
    private LocalDateTime horaInicio;
    private LocalDateTime horaTermino;

    public OTTecnicoResponseDto() {
    }

    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }

    public Integer getIdOrdenTrabajo() { return idOrdenTrabajo; }
    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) { this.idOrdenTrabajo = idOrdenTrabajo; }

    public Integer getIdOrdenTrabajoProg() { return idOrdenTrabajoProg; }
    public void setIdOrdenTrabajoProg(Integer idOrdenTrabajoProg) { this.idOrdenTrabajoProg = idOrdenTrabajoProg; }

    public Integer getIdEmpleado() { return idEmpleado; }
    public void setIdEmpleado(Integer idEmpleado) { this.idEmpleado = idEmpleado; }

    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getCargo() { return cargo; }
    public void setCargo(String cargo) { this.cargo = cargo; }

    public LocalDateTime getHoraInicio() { return horaInicio; }
    public void setHoraInicio(LocalDateTime horaInicio) { this.horaInicio = horaInicio; }

    public LocalDateTime getHoraTermino() { return horaTermino; }
    public void setHoraTermino(LocalDateTime horaTermino) { this.horaTermino = horaTermino; }
}
