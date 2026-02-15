package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "cargos")
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idCargo;

    @Column(name="cargo", length = 20)
    private String cargo;

    public Cargo(){}
    public Cargo(Integer idCargo,String cargo){
        this.cargo = cargo;
        this.idCargo = idCargo;
    }

    public String getCargo(){
        return this.cargo;
    }

    public void setCargo(String cargo){
        this.cargo = cargo;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }
}
