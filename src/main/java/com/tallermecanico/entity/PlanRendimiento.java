package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "plan_rendimiento", uniqueConstraints = @UniqueConstraint(columnNames = {"id_marca", "id_modelo", "id_estado"}))
public class PlanRendimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_marca", nullable = false)
    private MarcasNeumatico marca;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_modelo", nullable = false)
    private ModelosNeumatico modelo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_estado", nullable = false)
    private EstadosNeumatico estado;

    @Column(name = "rendimiento", nullable = false)
    private Integer rendimiento;

    // Constructors
    public PlanRendimiento() {
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public MarcasNeumatico getMarca() {
        return marca;
    }

    public void setMarca(MarcasNeumatico marca) {
        this.marca = marca;
    }

    public ModelosNeumatico getModelo() {
        return modelo;
    }

    public void setModelo(ModelosNeumatico modelo) {
        this.modelo = modelo;
    }

    public EstadosNeumatico getEstado() {
        return estado;
    }

    public void setEstado(EstadosNeumatico estado) {
        this.estado = estado;
    }

    public Integer getRendimiento() {
        return rendimiento;
    }

    public void setRendimiento(Integer rendimiento) {
        this.rendimiento = rendimiento;
    }
}
