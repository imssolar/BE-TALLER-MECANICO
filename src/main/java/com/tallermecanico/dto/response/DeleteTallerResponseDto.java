package com.tallermecanico.dto.response;

public class DeleteTallerResponseDto {

    private Integer id;
    private String taller;
    private String message;

    // Constructors
    public DeleteTallerResponseDto() {
    }

    public DeleteTallerResponseDto(Integer id, String taller, String message) {
        this.id = id;
        this.taller = taller;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTaller() {
        return taller;
    }

    public void setTaller(String taller) {
        this.taller = taller;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
