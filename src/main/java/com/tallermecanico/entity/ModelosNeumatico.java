package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "modelos_neumatico")
public class ModelosNeumatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String modelo;

    @OneToMany(mappedBy = "modeloNeumatico", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Neumatico> neumaticos;

    // Constructors
    public ModelosNeumatico() {
    }

    public ModelosNeumatico(String modelo) {
        this.modelo = modelo;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public List<Neumatico> getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(List<Neumatico> neumaticos) {
        this.neumaticos = neumaticos;
    }
}
