package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "registro_mensual")
public class RegistroMensual {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "anio")
    private Integer anio;

    @Column(name = "item", length = 5)
    private String item;

    @Column(name = "enero")
    private Integer enero;

    @Column(name = "febrero")
    private Integer febrero;

    @Column(name = "marzo")
    private Integer marzo;

    @Column(name = "abril")
    private Integer abril;

    @Column(name = "mayo")
    private Integer mayo;

    @Column(name = "junio")
    private Integer junio;

    @Column(name = "julio")
    private Integer julio;

    @Column(name = "agosto")
    private Integer agosto;

    @Column(name = "septiembre")
    private Integer septiembre;

    @Column(name = "octubre")
    private Integer octubre;

    @Column(name = "noviembre")
    private Integer noviembre;

    @Column(name = "diciembre")
    private Integer diciembre;

    @Column(name = "tipo", length = 15)
    private String tipo;

    // Constructors
    public RegistroMensual() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAnio() {
        return anio;
    }

    public void setAnio(Integer anio) {
        this.anio = anio;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Integer getEnero() {
        return enero;
    }

    public void setEnero(Integer enero) {
        this.enero = enero;
    }

    public Integer getFebrero() {
        return febrero;
    }

    public void setFebrero(Integer febrero) {
        this.febrero = febrero;
    }

    public Integer getMarzo() {
        return marzo;
    }

    public void setMarzo(Integer marzo) {
        this.marzo = marzo;
    }

    public Integer getAbril() {
        return abril;
    }

    public void setAbril(Integer abril) {
        this.abril = abril;
    }

    public Integer getMayo() {
        return mayo;
    }

    public void setMayo(Integer mayo) {
        this.mayo = mayo;
    }

    public Integer getJunio() {
        return junio;
    }

    public void setJunio(Integer junio) {
        this.junio = junio;
    }

    public Integer getJulio() {
        return julio;
    }

    public void setJulio(Integer julio) {
        this.julio = julio;
    }

    public Integer getAgosto() {
        return agosto;
    }

    public void setAgosto(Integer agosto) {
        this.agosto = agosto;
    }

    public Integer getSeptiembre() {
        return septiembre;
    }

    public void setSeptiembre(Integer septiembre) {
        this.septiembre = septiembre;
    }

    public Integer getOctubre() {
        return octubre;
    }

    public void setOctubre(Integer octubre) {
        this.octubre = octubre;
    }

    public Integer getNoviembre() {
        return noviembre;
    }

    public void setNoviembre(Integer noviembre) {
        this.noviembre = noviembre;
    }

    public Integer getDiciembre() {
        return diciembre;
    }

    public void setDiciembre(Integer diciembre) {
        this.diciembre = diciembre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
