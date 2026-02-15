package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateTerminalDto {

    @Size(max = 15, message = "El nombre del terminal no puede exceder 15 caracteres")
    private String terminal;

    @Size(max = 3, message = "El prefijo no puede exceder 3 caracteres")
    private String prefijo;

    // Constructors
    public UpdateTerminalDto() {
    }

    public UpdateTerminalDto(String terminal, String prefijo) {
        this.terminal = terminal;
        this.prefijo = prefijo;
    }

    // Getters and Setters
    public String getTerminal() {
        return terminal;
    }

    public void setTerminal(String terminal) {
        this.terminal = terminal != null ? terminal.trim() : null;
    }

    public String getPrefijo() {
        return prefijo;
    }

    public void setPrefijo(String prefijo) {
        this.prefijo = prefijo != null ? prefijo.trim().toUpperCase() : null;
    }
}
