package com.tallermecanico.dto.request;

import com.tallermecanico.enums.CargoEmpleado;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class CreateCompetenciaDto {

    private CargoEmpleado cargo;

    private Integer idCompetenciaArea;

    @Size(max = 100, message = "La competencia no debe exceder los 100 caracteres")
    private String competencia;

    private Integer orden;

    @DecimalMin(value = "0", message = "El teórico debe ser mayor o igual a 0")
    private BigDecimal teorico;

    // Constructors
    public CreateCompetenciaDto() {
    }

    // Getters and Setters
    public CargoEmpleado getCargo() {
        return cargo;
    }

    public void setCargo(CargoEmpleado cargo) {
        this.cargo = cargo;
    }

    public Integer getIdCompetenciaArea() {
        return idCompetenciaArea;
    }

    public void setIdCompetenciaArea(Integer idCompetenciaArea) {
        this.idCompetenciaArea = idCompetenciaArea;
    }

    public String getCompetencia() {
        return competencia;
    }

    public void setCompetencia(String competencia) {
        this.competencia = competencia;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public BigDecimal getTeorico() {
        return teorico;
    }

    public void setTeorico(BigDecimal teorico) {
        this.teorico = teorico;
    }
}
