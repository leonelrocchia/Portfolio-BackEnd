package com.porfolio.AP.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ExperienceDto {

    @NotBlank
    private String puesto;
    @NotBlank
    private String empleador;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    @Min(1950) @Max(2022)
    private float inicio;
    @Min(1950) @Max(2022)
    private float fin;

    //constructores

    public ExperienceDto() {
    }

    public ExperienceDto(String puesto, String empleador, String descripcion, String img, float inicio, float fin) {
        this.puesto = puesto;
        this.empleador = empleador;
        this.descripcion = descripcion;
        this.img = img;
        this.inicio = inicio;
        this.fin = fin;
    }

    //getter&setter

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getEmpleador() {
        return empleador;
    }

    public void setEmpleador(String empleador) {
        this.empleador = empleador;
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
