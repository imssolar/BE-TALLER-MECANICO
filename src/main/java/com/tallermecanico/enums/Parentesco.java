package com.tallermecanico.enums;

public enum Parentesco {
    PADRE("Padre"),
    MADRE("Madre"),
    HERMANO("Hermano"),
    HERMANA("Hermana"),
    CONYUGE("Cónyuge"),
    HIJO("Hijo"),
    HIJA("Hija"),
    OTRO("Otro");

    private final String displayName;

    Parentesco(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
