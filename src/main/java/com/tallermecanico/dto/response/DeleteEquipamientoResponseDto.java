package com.tallermecanico.dto.response;

public class DeleteEquipamientoResponseDto {

    private Integer id;
    private String equipamiento;
    private String message;

    // Constructors
    public DeleteEquipamientoResponseDto() {
    }

    public DeleteEquipamientoResponseDto(Integer id, String equipamiento, String message) {
        this.id = id;
        this.equipamiento = equipamiento;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEquipamiento() {
        return equipamiento;
    }

    public void setEquipamiento(String equipamiento) {
        this.equipamiento = equipamiento;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
