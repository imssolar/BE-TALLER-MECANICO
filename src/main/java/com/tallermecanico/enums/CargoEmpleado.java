package com.tallermecanico.enums;

public enum CargoEmpleado {
    CONDUCTOR("Conductor"),
    MECANICO("Mecanico"),
    ADMINISTRATIVO("Administrativo"),
    JEFE_TERMINAL("Jefe de Terminal");

    private final String displayName;

    CargoEmpleado(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
