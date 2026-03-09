package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "requisitos_mtt")
public class RequisitoMTT {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "requisito", length = 70, nullable = false, unique = true)
    private String requisito;

    @Column(name = "tipo", length = 1)
    private String tipo;

    @Column(name = "tipo_filtro", length = 2)
    private String tipoFiltro;

    // Constructors
    public RequisitoMTT() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRequisito() {
        return requisito;
    }

    public void setRequisito(String requisito) {
        this.requisito = requisito;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTipoFiltro() {
        return tipoFiltro;
    }

    public void setTipoFiltro(String tipoFiltro) {
        this.tipoFiltro = tipoFiltro;
    }
}
