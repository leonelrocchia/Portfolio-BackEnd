package com.porfolio.AP.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

public class ProjectDto {

    @NotBlank
    private String proyecto;
    private String cliente;
    @NotBlank
    private String descripcion;
    private String img;
    @Min(1950) @Max(2022)
    private float year;
    @NotBlank
    private String link;

    //constructores

    public ProjectDto() {
    }

    public ProjectDto(String proyecto, String cliente, String descripcion, String img, float year, String link) {
        this.proyecto = proyecto;
        this.cliente = cliente;
        this.descripcion = descripcion;
        this.img = img;
        this.year = year;
        this.link = link;
    }

    //getter&setter

    public String getProyecto() {
        return proyecto;
    }

    public void setProyecto(String proyecto) {
        this.proyecto = proyecto;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
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

    public float getYear() {
        return year;
    }

    public void setYear(float year) {
        this.year = year;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
