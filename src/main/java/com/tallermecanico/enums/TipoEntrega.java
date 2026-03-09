package com.tallermecanico.enums;

public enum TipoEntrega {
    EQUIPAMIENTO("Equipamiento"),
    HERRAMIENTA("Herramienta");

    private final String displayName;

    TipoEntrega(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
