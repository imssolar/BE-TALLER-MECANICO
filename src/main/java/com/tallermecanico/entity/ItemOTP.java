package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "items_otp")
public class ItemOTP {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item", length = 50, nullable = false, unique = true)
    private String item;

    @Column(name = "pauta", length = 3)
    private String pauta;

    @Column(name = "tipo", length = 2)
    private String tipo;

    @Column(name = "control", length = 15)
    private String control;

    @Column(name = "formato", length = 2)
    private String formato;

    // Constructors
    public ItemOTP() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getPauta() {
        return pauta;
    }

    public void setPauta(String pauta) {
        this.pauta = pauta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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
