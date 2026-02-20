package com.tallermecanico.dto.request;

import jakarta.validation.constraints.Size;

public class UpdateAreaDto {

    @Size(max = 50, message = "El nombre del área no debe exceder los 50 caracteres")
    private String area;

    // Constructors
    public UpdateAreaDto() {
    }

    public UpdateAreaDto(String area) {
        this.area = area;
    }

    // Getters and Setters
    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }
}
