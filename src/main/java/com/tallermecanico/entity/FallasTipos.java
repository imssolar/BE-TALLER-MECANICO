package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "fallas_tipos")
public class FallasTipos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_falla")
    private Falla falla;

    @Column(name = "tipo_falla", length = 50)
    private String tipoFalla;

    public FallasTipos(Integer id, Falla falla,String tipoFalla){
        this.id = id;
        this.falla= falla;
        this.tipoFalla = tipoFalla;
    }

    public FallasTipos(){}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Falla getFalla() {
        return falla;
    }

    public void setFalla(Falla falla) {
        this.falla = falla;
    }

    public String getTipoFalla() {
        return tipoFalla;
    }

    public void setTipoFalla(String tipoFalla) {
        this.tipoFalla = tipoFalla;
    }
}
