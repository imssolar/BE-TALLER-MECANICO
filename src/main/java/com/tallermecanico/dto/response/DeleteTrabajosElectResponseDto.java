package com.tallermecanico.dto.response;

public class DeleteTrabajosElectResponseDto {

    private Integer id;
    private String tipoTE;
    private String message;

    // Constructors
    public DeleteTrabajosElectResponseDto() {
    }

    public DeleteTrabajosElectResponseDto(Integer id, String tipoTE) {
        this.id = id;
        this.tipoTE = tipoTE;
        this.message = String.format("Trabajo eléctrico '%s' eliminado correctamente", tipoTE);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTipoTE() {
        return tipoTE;
    }

    public void setTipoTE(String tipoTE) {
        this.tipoTE = tipoTE;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
