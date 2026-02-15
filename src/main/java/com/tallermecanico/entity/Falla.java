package com.tallermecanico.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Fallas")
public class Falla {

    @Id
    @Column(name = "id_falla")
    private String idFalla;

    @Column(name = "falla", length = 25)
    private String falla;

    public Falla() {}

    public Falla(String idFalla, String falla) {
        this.idFalla = idFalla;
        this.falla = falla;
    }

    public String getIdFalla() {
        return idFalla;
    }

    public void setIdFalla(String idFalla) {
        this.idFalla = idFalla;
    }

    public String getFalla() {
        return falla;
    }

    public void setFalla(String falla) {
        this.falla = falla;
    }
}
