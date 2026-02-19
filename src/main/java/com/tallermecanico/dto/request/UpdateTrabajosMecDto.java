package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateTrabajosMecDto {

    @Size(max = 100, message = "El trabajo mecánico no puede exceder 100 caracteres")
    private String trabajoMec;

    private Integer idGlosa;

    // Constructors
    public UpdateTrabajosMecDto() {
    }

    public UpdateTrabajosMecDto(String trabajoMec, Integer idGlosa) {
        this.trabajoMec = trabajoMec;
        this.idGlosa = idGlosa;
    }

    // Getters and Setters
    public String getTrabajoMec() {
        return trabajoMec;
    }

    public void setTrabajoMec(String trabajoMec) {
        this.trabajoMec = trabajoMec;
    }

    public Integer getIdGlosa() {
        return idGlosa;
    }

    public void setIdGlosa(Integer idGlosa) {
        this.idGlosa = idGlosa;
    }
}
