package com.tallermecanico.enums;

public enum LicenciaConducir {
    A1("Para taxis (ya no se otorga, reemplazada por A2)"),
    A2("Taxis, ambulancias, vehículos de transporte público y privado con capacidad de 10 a 17 pasajeros"),
    A3("Vehículos de transporte público y privado de pasajeros sin límite de capacidad (incluye escolares y ambulancias)"),
    A4("Transporte de carga con peso bruto superior a 3.500 kg"),
    A5("Vehículos de carga, simples o articulados, con peso bruto superior a 3.500 kg, incluso combinaciones de vehículos"),
    D("Maquinaria automotriz (tractores, grúas, etc.)"),
    E("Vehículos de tracción animal (carretelas, carros)"),
    F("Vehículos de emergencia (policía, bomberos, ambulancias)");

    private final String displayName;

    LicenciaConducir(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
