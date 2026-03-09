package com.tallermecanico.dto.response;

public class DeleteTrabajosMecResponseDto {

    private Integer id;
    private String trabajoMec;
    private String message;

    // Constructors
    public DeleteTrabajosMecResponseDto() {
    }

    public DeleteTrabajosMecResponseDto(Integer id, String trabajoMec) {
        this.id = id;
        this.trabajoMec = trabajoMec;
        this.message = String.format("Trabajo mecánico '%s' eliminado correctamente", trabajoMec);
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTrabajoMec() {
        return trabajoMec;
    }

    public void setTrabajoMec(String trabajoMec) {
        this.trabajoMec = trabajoMec;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
