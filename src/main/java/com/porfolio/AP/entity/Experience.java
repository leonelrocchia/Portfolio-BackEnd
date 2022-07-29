package com.porfolio.AP.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Experience {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String puesto;
    @NotBlank
    private String empleador;
    @NotBlank
    private String descripcion;
    @NotBlank
    private String img;
    private float inicio;
    private float fin;

    //constructores

    public Experience() {
    }

    public Experience(String puesto, String empleador, String descripcion, String img, float inicio, float fin) {
        this.puesto = puesto;
        this.empleador = empleador;
        this.descripcion = descripcion;
        this.img = img;
        this.inicio = inicio;
        this.fin = fin;
    }

    //getter&setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
