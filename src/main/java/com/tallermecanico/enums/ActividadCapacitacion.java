package com.tallermecanico.enums;

public enum ActividadCapacitacion {
    CHARLA("Charla"),
    TALLER("Taller"),
    CURSO("Curso"),
    SEMINARIO("Seminario"),
    INDUCCION("Inducción");

    private final String displayName;

    ActividadCapacitacion(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
