package com.tallermecanico.dto.response;

public class RutaResponseDto {

    private Integer idRuta;
    private String ruta;

    // Constructors
    public RutaResponseDto() {
    }

    public RutaResponseDto(Integer idRuta, String ruta) {
        this.idRuta = idRuta;
        this.ruta = ruta;
    }

    // Getters and Setters
    public Integer getIdRuta() {
        return idRuta;
    }

    public void setIdRuta(Integer idRuta) {
        this.idRuta = idRuta;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }
}
