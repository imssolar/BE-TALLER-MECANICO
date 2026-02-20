package com.tallermecanico.dto.response;

public class DeleteResponsableResponseDto {

    private Integer id;
    private String responsable;
    private String message;

    // Constructors
    public DeleteResponsableResponseDto() {
    }

    public DeleteResponsableResponseDto(Integer id, String responsable, String message) {
        this.id = id;
        this.responsable = responsable;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getResponsable() {
        return responsable;
    }

    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
