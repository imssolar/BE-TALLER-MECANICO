package com.tallermecanico.enums;

public enum EstadoCivil {
    SOLTERO("Soltero"),
    CASADO("Casado"),
    DIVORCIADO("Divorciado"),
    VIUDO("Viudo");

    private final String displayName;

    EstadoCivil(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
