package com.tallermecanico.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "marcas_neumatico")
public class MarcasNeumatico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 15, nullable = false)
    private String marca;

    @OneToMany(mappedBy = "marca", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Neumatico> neumaticos;

    // Constructors
    public MarcasNeumatico() {
    }

    public MarcasNeumatico(String marca) {
        this.marca = marca;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public List<Neumatico> getNeumaticos() {
        return neumaticos;
    }

    public void setNeumaticos(List<Neumatico> neumaticos) {
        this.neumaticos = neumaticos;
    }
}
