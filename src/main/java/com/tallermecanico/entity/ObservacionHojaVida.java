package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "observacion_hoja_vida")
public class ObservacionHojaVida {

    @Id
    @Column(name = "id_obs", length = 3)
    private String idObs;

    @Column(name = "observacion", length = 30)
    private String observacion;

    // Constructors
    public ObservacionHojaVida() {
    }

    // Getters and Setters
    public String getIdObs() {
        return idObs;
    }

    public void setIdObs(String idObs) {
        this.idObs = idObs;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
