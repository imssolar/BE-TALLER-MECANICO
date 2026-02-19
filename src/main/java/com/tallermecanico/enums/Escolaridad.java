package com.tallermecanico.enums;

public enum Escolaridad {
    BASICA("Básica"),
    MEDIA("Media"),
    TECNICA("Técnica"),
    UNIVERSITARIA("Universitaria"),
    POSTGRADO("Postgrado");

    private final String displayName;

    Escolaridad(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
