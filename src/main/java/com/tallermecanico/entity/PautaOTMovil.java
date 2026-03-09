package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pautas_ot_moviles")
public class PautaOTMovil {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pauta", length = 50, nullable = false, unique = true)
    private String pauta;

    @Column(name = "codigo_pauta", length = 2)
    private String codigoPauta;

    @Column(name = "control", length = 15)
    private String control;

    @Column(name = "formato", length = 2)
    private String formato;

    // Constructors
    public PautaOTMovil() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getCodigoPauta() {
        return codigoPauta;
    }

    public void setCodigoPauta(String codigoPauta) {
        this.codigoPauta = codigoPauta;
    }

    public String getControl() {
        return control;
    }

    public void setControl(String control) {
        this.control = control;
    }

    public String getFormato() {
        return formato;
    }

    public void setFormato(String formato) {
        this.formato = formato;
    }
}
