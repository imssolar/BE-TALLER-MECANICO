package com.tallermecanico.dto.response;

public class DeleteMantencionMovilResponseDto {

    private Integer id;
    private String item;
    private String message;

    // Constructors
    public DeleteMantencionMovilResponseDto() {
    }

    public DeleteMantencionMovilResponseDto(Integer id, String item, String message) {
        this.id = id;
        this.item = item;
        this.message = message;
    }

    // Getters and Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
