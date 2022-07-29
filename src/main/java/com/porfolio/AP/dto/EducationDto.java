package com.porfolio.AP.dto;

import javax.validation.constraints.NotBlank;

public class EducationDto {
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    private float inicio;
    private float fin;

    public EducationDto() {
    }

    public EducationDto(String titulo, String institucion, String descripcion, String img, float inicio, float fin) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.descripcion = descripcion;
        this.img = img;
        this.inicio = inicio;
        this.fin = fin;
    }

    //g&s


    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public float getInicio() {
        return inicio;
    }

    public void setInicio(float inicio) {
        this.inicio = inicio;
    }

    public float getFin() {
        return fin;
    }

    public void setFin(float fin) {
        this.fin = fin;
    }
}
