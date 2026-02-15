package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "estados_neumatico")
public class EstadosNeumatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String estado;

    @OneToMany(mappedBy = "estado", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Neumatico> neumaticos;

    // Constructors
    public EstadosNeumatico() {
    }

    public EstadosNeumatico(String estado) {
        this.estado = estado;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Neumatico> getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(List<Neumatico> neumaticos) {
        this.neumaticos = neumaticos;
    }
}
