package com.tallermecanico.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "terminal")
public class Terminal {

    @Id
    @Column(name = "id_terminal")
    private Integer idTerminal;

    @Column(length = 15)
    private String terminal;

    @Column(length = 3)
    private String prefijo;

    @JsonIgnore
    @OneToMany(mappedBy = "terminal", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Bus> buses;

    // Constructors
    public Terminal() {
    }

    public Terminal(Integer idTerminal, String terminal, String prefijo) {
        this.idTerminal = idTerminal;
        this.terminal = terminal;
        this.prefijo = prefijo;
    }

    // Getters and Setters
    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo;
    }

    public List<Bus> getBuses() {
        return buses;
    }

    public void setBuses(List<Bus> buses) {
        this.buses = buses;
    }
}
