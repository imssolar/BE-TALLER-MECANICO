package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "taller_externo")
public class TallerExterno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 12)
    private String rut;

    @Column(name = "razon_social", length = 50)
    private String razonSocial;

    @Column(length = 100)
    private String direccion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_comuna")
    private Comuna comuna;

    @Column(length = 15)
    private String fono;

    // Constructors
    public TallerExterno() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Comuna getComuna() {
        return comuna;
    }

    public void setComuna(Comuna comuna) {
        this.comuna = comuna;
    }

    public String getFono() {
        return fono;
    }

    public void setFono(String fono) {
        this.fono = fono;
    }
}
