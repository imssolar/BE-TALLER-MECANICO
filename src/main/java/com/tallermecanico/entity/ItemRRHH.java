package com.tallermecanico.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "item_rrhh")
public class ItemRRHH {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "item", length = 60, nullable = false, unique = true)
    private String item;

    // Constructors
    public ItemRRHH() {
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
}
