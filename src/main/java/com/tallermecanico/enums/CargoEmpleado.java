package com.tallermecanico.enums;

public enum CargoEmpleado {
    CONDUCTOR("Conductor"),
    MECANICO("Mecanico"),
    ADMINISTRATIVO("Administrativo"),
    JEFE_TERMINAL("Jefe de Terminal"),
    JEFE_TURNO_PATIO("Jefe de Turno Patio"),
    JEFE_TURNO_MANT("Jefe de Turno Mantención"),
    SUPERVISOR_CALIDAD("Supervisor de Calidad");

    private final String displayName;

    CargoEmpleado(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
