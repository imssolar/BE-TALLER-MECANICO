package com.tallermecanico.dto.response;

public class TorreControlResponseDto {

    private Integer id;
    private Integer idBus;
    private String patenteB;
    private String falla;
    private String tipoFalla;
    private Integer idEmpleadoMecanico;
    private String nombreCompletoMecanico;
    private Integer idEmpleadoElectrico;
    private String nombreCompletoElectrico;
    private String status;
    private Boolean cerrado;

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

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }

    public String getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(String tipoFalla) {
        this.tipoFalla = tipoFalla;
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

    public Integer getIdEmpleadoElectrico() {
        return idEmpleadoElectrico;
    }

    public void setIdEmpleadoElectrico(Integer idEmpleadoElectrico) {
        this.idEmpleadoElectrico = idEmpleadoElectrico;
    }

    public String getNombreCompletoElectrico() {
        return nombreCompletoElectrico;
    }

    public void setNombreCompletoElectrico(String nombreCompletoElectrico) {
        this.nombreCompletoElectrico = nombreCompletoElectrico;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Boolean getCerrado() {
        return cerrado;
    }

    public void setCerrado(Boolean cerrado) {
        this.cerrado = cerrado;
    }
}
