package com.tallermecanico.dto.response;

public class DeleteRepuestoResponseDto {

    private Integer id;
    private String repuesto;
    private String message;

    // Constructors
    public DeleteRepuestoResponseDto() {
    }

    public DeleteRepuestoResponseDto(Integer id, String repuesto, String message) {
        this.id = id;
        this.repuesto = repuesto;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRepuesto() {
        return repuesto;
    }

    public void setRepuesto(String repuesto) {
        this.repuesto = repuesto;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
