package com.tallermecanico.dto.request;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import java.math.BigDecimal;

public class UpdateDetalleMTTOTDto {

    private Integer idOrdenTrabajo;

    @Size(max = 4, message = "El id MTT no debe exceder los 4 caracteres")
    private String idMtt;

    @DecimalMin(value = "0", message = "Los litros MTT deben ser mayor o igual a 0")
    private BigDecimal litrosMtt;

    // Constructors
    public UpdateDetalleMTTOTDto() {
    }

    // Getters and Setters
    public Integer getIdOrdenTrabajo() {
        return idOrdenTrabajo;
    }

    public void setIdOrdenTrabajo(Integer idOrdenTrabajo) {
        this.idOrdenTrabajo = idOrdenTrabajo;
    }

    public String getIdMtt() {
        return idMtt;
    }

    public void setIdMtt(String idMtt) {
        this.idMtt = idMtt;
    }

    public BigDecimal getLitrosMtt() {
        return litrosMtt;
    }

    public void setLitrosMtt(BigDecimal litrosMtt) {
        this.litrosMtt = litrosMtt;
    }
}
