package com.tallermecanico.dto.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CreateTerminalDto {

    @NotNull(message = "El ID del terminal es requerido")
    private Integer idTerminal;

    @Size(max = 15, message = "El nombre del terminal no puede exceder 15 caracteres")
    private String terminal;

    @Size(max = 3, message = "El prefijo no puede exceder 3 caracteres")
    private String prefijo;

    // Constructors
    public CreateTerminalDto() {
    }

    public CreateTerminalDto(Integer idTerminal, String terminal, String prefijo) {
        this.idTerminal = idTerminal;
        this.terminal = terminal;
        this.prefijo = prefijo;
    }

    // Getters and Setters
    public Integer getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(Integer idTerminal) {
        this.idTerminal = idTerminal;
    }

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
